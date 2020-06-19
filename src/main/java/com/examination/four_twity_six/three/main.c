#include <Windows.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <stdbool.h>
#include <time.h>
#include "common.h"


uint32_t gNodeNumber;

// 消息结构
typedef struct _tagMsg {
	uint32_t dwSenderId;
	uint32_t dwReceiverId;
	uint32_t dwMsgType;
	uint32_t dwMsgLength;
	char msgData[1];
}Msg_t, *MsgP_t;

#define MAX_QUEUE_LENGTH	(32)
#define MAX_NB_SIZE			(16)
#define MAX_THREAD_COUNT	(32)
// 消息队列结构
typedef struct _tagMsgQueue {
	MsgP_t pMsg[MAX_QUEUE_LENGTH];
	uint32_t length;
	HANDLE evtFull;
	HANDLE evtEmpty;
	HANDLE mutex;
}MsgQueue_t, *MsgQueueP_t;

// 单个node的结构
typedef struct _tagNode {
	MsgQueue_t msgQueueToReceive;
	uint32_t dwNbCount;
	uint32_t dwNeighbors[MAX_NB_SIZE];
}Node_t, *NodeP_t;

// 全局的结点数组
NodeP_t pgNode;

THREAD uint32_t mThreadId;
// 发送一条信息，信息通过内存分配生成
bool sendMessage(MsgP_t msg) {
	NodeP_t pNode = pgNode + msg->dwReceiverId;
	MsgQueueP_t pQueue = &(pNode->msgQueueToReceive);

	DWORD dwWait;
restart:
	while (pQueue->length == MAX_QUEUE_LENGTH) {
		dwWait = WaitForSingleObject(pQueue->evtFull, 2000);
		if (dwWait == WAIT_FAILED) {
			printf("WaitEvent error: %d\n", GetLastError());
			return false;
		}
	}

	dwWait = WaitForSingleObject(pQueue->mutex, INFINITE);
	if (dwWait == WAIT_FAILED) {
		printf("WaitMutex error: %d\n", GetLastError());
		return false;
	}

	if (pQueue->length == MAX_QUEUE_LENGTH) {
		ReleaseMutex(pQueue->mutex);
		goto restart;
	}

	pQueue->pMsg[pQueue->length] = msg;
	pQueue->length++;

	ReleaseMutex(pQueue->mutex);

	if (!SetEvent(pQueue->evtEmpty)) {
		printf("SetEvent error: %d\n", GetLastError());
		return false;
	}

	return true;
}


MsgP_t receiveMsg(bool bWait, int32_t dwWaitTime) {
	NodeP_t pNode = pgNode + mThreadId;
	MsgQueueP_t pQueue = &(pNode->msgQueueToReceive);
	DWORD dwWait;
	int32_t dwWaitTime2;

restart:
	dwWaitTime2 = dwWaitTime;
	while (pQueue->length == 0) {
		if (!bWait || dwWaitTime2 <= 0 ) {
			return NULL;
		}
		dwWait = WaitForSingleObject(pQueue->evtEmpty, 1000);
		if (dwWait == WAIT_FAILED || dwWait == WAIT_ABANDONED) {
			printf("WaitEvent error: %d\n", GetLastError());
			return NULL;
		}
		else if (dwWait == WAIT_TIMEOUT) {
			dwWaitTime2 -= 1000;
		}
	}

	dwWait = WaitForSingleObject(pQueue->mutex, INFINITE);
	if (dwWait == WAIT_FAILED) {
		printf("WaitMutex error: %d\n", GetLastError());
		return NULL;
	}

	if (pQueue->length == 0) {
		ReleaseMutex(pQueue->mutex);
		goto restart;
	}

	MsgP_t msg = pQueue->pMsg[0];
	memmove(pQueue->pMsg, pQueue->pMsg + 1, sizeof(MsgP_t) * (pQueue->length - 1));
	pQueue->length--;

	ReleaseMutex(pQueue->mutex);

	if (!SetEvent(pQueue->evtFull)) {
		printf("SetEvent error: %d\n", GetLastError());
		return NULL;
	}

	return msg;
}

static void doSomeJobs() {
	uint32_t dwMilliseconds = rand();
	if (dwMilliseconds < mThreadId * 1000) {
		dwMilliseconds = mThreadId * 1000;
	}
	else if (dwMilliseconds > 5000) {
		dwMilliseconds = 5000;
	}
	printf("%d will do some jobs for %d milliseconds\n", mThreadId, dwMilliseconds);

	Sleep(dwMilliseconds);
}

HANDLE geRound;					// 全局同步的信号量
HANDLE gSyncMutex;				// 全局同步的互斥锁
uint32_t completed = 0;			// 标识每轮完成的结点数目

THREAD MsgP_t mMessageBuf[MAX_THREAD_COUNT];		// 线程的局部消息缓存

uint32_t receiveAllNbMessagesSync() {
	uint32_t dwCount = 0;

}

uint32_t root;
// 模拟结点的线程主函数
static unsigned __stdcall ThreadFunc(void* pArguments)
{
	bool visited = false;
	uint32_t parent = (uint32_t) -1;
	uint32_t depth = 0;

	mThreadId = (uint32_t)pArguments;
	srand(time(NULL) * mThreadId);

	uint32_t dwIter;
	for (dwIter = 0; dwIter < gNodeNumber; dwIter ++) {
		if (mThreadId == root) {
			if (dwIter == 0) {
				visited = true;
				depth = 0;
				/**
				1、为什么这里需要doSomeJobs？
				**/
				doSomeJobs();
				NodeP_t pMyself = pgNode + mThreadId;
				uint32_t dwIter;
				for (dwIter = 0; dwIter < pMyself->dwNbCount; dwIter++) {
					MsgP_t pMsg = (MsgP_t)malloc(sizeof(Msg_t));
					pMsg->dwReceiverId = pMyself->dwNeighbors[dwIter];
					pMsg->dwSenderId = mThreadId;
					sendMessage(pMsg);
				}
			}
		}
		else {
			MsgP_t msg;
			do {
				msg = receiveMsg(false, 1000);
				if (msg) {
					if (visited == false) {
						visited = true;
						depth = dwIter;
						parent = msg->dwSenderId;

						doSomeJobs();
						NodeP_t pMyself = pgNode + mThreadId;
						uint32_t dwIter;
						for (dwIter = 0; dwIter < pMyself->dwNbCount; dwIter++) {
							uint32_t neighbor = pMyself->dwNeighbors[dwIter];
							if (neighbor != msg->dwSenderId) {
								MsgP_t pMsg = (MsgP_t)malloc(sizeof(Msg_t));
								pMsg->dwReceiverId = neighbor;
								pMsg->dwSenderId = mThreadId;
								sendMessage(pMsg);
							}
						}
					}
					free(msg);
				}
			} while (msg);
		}


		uint32_t dwWait = WaitForSingleObject(gSyncMutex, INFINITE);
		if (dwWait == WAIT_FAILED) {
			printf("WaitMutex error: %d\n", GetLastError());
			return -1;
		}
		completed++;

		if (completed == gNodeNumber) {
			/**
			2、为什么SetEvent动作必须发生在释放mutex之前？
			**/
			printf("%d starts next round! local round is %d\n", mThreadId, dwIter);
			completed = 0;
			if (!SetEvent(geRound)) {
				printf("SetEvent error: %d\n", GetLastError());
				return -1;
			}
			if (!ResetEvent(geRound)) {
				printf("SetEvent error: %d\n", GetLastError());
				return -1;
			}
			ReleaseMutex(gSyncMutex);
		}
		else {
			printf("%d waits for next round! local round is %d, complete value: %d\n", mThreadId, dwIter, completed);
			ReleaseMutex(gSyncMutex);
			uint32_t dwWait = WaitForSingleObject(geRound, INFINITE);
			if (dwWait == WAIT_FAILED) {
				printf("WaitMutex error: %d\n", GetLastError());
				return -1;
			}
		}
	}


	printf("------------------------------------\n %d ends, my parent: %d, depth: %d, visited: %d\n", mThreadId, parent, depth, visited);
	return 0;
}

bool generateNbs(NodeP_t pNode, uint32_t dwNbCount) {
	uint32_t dwIter;
	uint32_t dwMyNumber = pNode - pgNode;

	uint32_t dwMaxNb = dwMyNumber;
	for (dwIter = pNode->dwNbCount; dwIter < dwNbCount; dwIter++) {
		if (dwMaxNb >= gNodeNumber - 1) {
			continue;
		}
		uint32_t neighbor = dwMaxNb + 1 + (rand() * (gNodeNumber - dwMaxNb - 1) / RAND_MAX);
		pNode->dwNeighbors[dwIter] = neighbor;
		pNode->dwNbCount++;

		NodeP_t pNeighbor = pgNode + neighbor;
		pNeighbor->dwNeighbors[pNeighbor->dwNbCount] = dwMyNumber;
		pNeighbor->dwNbCount++;

		if (neighbor == gNodeNumber - 1) {
			break;
		}
		dwMaxNb = neighbor;
	}

	return true;
}

bool InitEnvironment() {
	pgNode = (NodeP_t)malloc(gNodeNumber * sizeof(Node_t));
	if (!pgNode) {
		return -1;
	}
	memset(pgNode, 0, gNodeNumber * sizeof(Node_t));

	// errno_t err;
	srand(time(NULL));
	uint32_t wIter;
	for (wIter = 0; wIter < gNodeNumber; wIter++) {
		NodeP_t pNode = pgNode + wIter;
		uint32_t dwNbCount = rand() * MAX_NB_SIZE / RAND_MAX;

		pNode->msgQueueToReceive.evtEmpty = CreateEvent(NULL, FALSE, FALSE, NULL);
		pNode->msgQueueToReceive.evtFull = CreateEvent(NULL, FALSE, FALSE, NULL);
		pNode->msgQueueToReceive.mutex = CreateMutex(NULL, FALSE, NULL);

		if (!pNode->msgQueueToReceive.evtEmpty || !pNode->msgQueueToReceive.evtFull || !pNode->msgQueueToReceive.mutex) {
			printf("CreateEvent/Mutex error: %d\n", GetLastError());
			return false;
		}
		if (dwNbCount < pNode->dwNbCount) {
			continue;
		}
		else {
			generateNbs(pNode, dwNbCount);
		}
	}

	gSyncMutex = CreateMutex(NULL, FALSE, NULL);
	geRound = CreateEvent(NULL, TRUE, FALSE, NULL);
	return true;
}

void displayNodes() {
	uint32_t dwIter;
	for (dwIter = 0; dwIter < gNodeNumber; dwIter++) {
		NodeP_t pNode = pgNode + dwIter;

		printf("结点%d有%d个邻居：\n", dwIter, pNode->dwNbCount);

		uint32_t dwIter2;
		for (dwIter2 = 0; dwIter2 < pNode->dwNbCount; dwIter2++) {
			printf("%d\t", pNode->dwNeighbors[dwIter2]);
		}
		printf("\n");
	}
}


int main(int argc, char * argv[]) {
	if (argc == 1) {
		printf("请输入结点的数目\n");
		return -1;
	}
	gNodeNumber = atoi(argv[1]);
	if (gNodeNumber == 0) {
		printf("非法的结点数目\n");
		return -1;
	}
	printf("将创建%d个结点的分布式计算模拟环境\n", gNodeNumber);

	if (!InitEnvironment()) {
		return -1;
	}
	displayNodes();

	HANDLE aThread[MAX_THREAD_COUNT];

	root = 0;
	for (uint32_t i = 0; i < gNodeNumber; i++)
	{
		DWORD ThreadID;
		aThread[i] = CreateThread(
			NULL,       // default security attributes
			0,          // default stack size
			(LPTHREAD_START_ROUTINE)ThreadFunc,
			i,			// no thread function arguments
			0,          // default creation flags
			&ThreadID); // receive thread identifier

		if (aThread[i] == NULL)
		{
			printf("CreateThread error: %d\n", GetLastError());
			return 1;
		}
	}

	// Wait for all threads to terminate

	WaitForMultipleObjects(gNodeNumber, aThread, TRUE, INFINITE);

	printf("-------------------------------------\n");

	return 0;
}

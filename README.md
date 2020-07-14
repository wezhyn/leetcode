## 典型题型

### Min-Max
A,B 轮流选择一个队尾和队首的元素，当队列为空时，判断A,B谁拿取的总数最大
[StoneGame](src/main/java/com/leetcode/graph/StoneGame.kt)
### 规律
寻找数字间存在的规律，划分区间

[NumberOfDigitOne](src/main/java/com/offer/NumberOfDigitOne.kt)
[NthDigit](src/main/java/com/offer/NthDigit.kt)


### 正则表达式匹配[Complex]
使用递归模拟 ‘*’ 的匹配【状态机】，而不是常规的 while 匹配
注意如下的表达式：
```java
ture -> s= "aab" p= "c*a*b*"
true -> s="a"    p="ab*"
```
[RegularExpressionMatching](src/main/java/com/offer/RegularExpressionMatching.kt)

### 回溯法
回溯法适合由多个步骤组成的问题，每一个步骤都有多个选择，
如果用树形象的表示，在某一个节点有n个子节点，树的叶子节点为最终状态。
在当前叶子节点不满足约束时，回溯到上一个节点

#### 字典中回溯寻找单词
[WordSearch](src/main/java/com/offer/WordSearch.kt)

#### 全排序
[Permutations](src/main/java/com/offer/Permutations.kt)

### 双指针
#### 一维数组中使用双指针排序
[SortArrayByParity](src/main/java/com/offer/SortArrayByParity.kt)

### LinkedList
* 快慢指针寻找中间节点
第一次快慢指针从 Head 节点出发，快指针走两步，慢指针走一步，在慢指针走到环头节点前，快慢指针就会相遇，

第一个快指针都过得路程为 x+y1+y2+y1

第二个满指针走过的路程为 x+y1，所以 x=y2，只需要在头节点和相遇节点共同走x步，就会一起到达环头节点
![LinkedCycleII](img/LinkedListCycleII.png)

[LinkedListCycleII](src/main/java/com/offer/LinkedListCycleII.kt)
* [链表的反转](src/main/java/com/leetcode/graph/ReverseLinkedList.kt)

[Palindrome Linked List 两者的结合](src/main/java/com/leetcode/list/PalindromeLinkedList.kt)

### Divide and conquer
#### 使用组合进行细节的封装
[ConvertBinarySearchTreeToSortedDoublyLinkedList](src/main/java/com/offer/ConvertBinarySearchTreeToSortedDoublyLinkedList.kt)


### SP
#### Dijkstra
[NetworkDelayTime](src/main/java/com/leetcode/graph/NetworkDelayTime.kt)

#### Bellman-Ford
[CheapestFlightsWithinKStops](src/main/java/com/leetcode/graph/CheapestFlightsWithinKStops.kt)

### DP
将大问题分解成小问题，求解每个子问题的最优解，从而求出大问题的解
> dp=缓冲数组+递归
[减绳子](src/main/java/com/offer/CutCord.kt)
> 无正确性

#### 自底向上回溯模拟
[DungeonGame](src/main/java/com/leetcode/dp/DungeonGame.kt)

#### [hard][DP]
**[BurstBalloons](src/main/java/com/leetcode/dp/BurstBalloons.kt)**
> 逆向思维思考子步骤

#### 特殊形状的图形 [DP]
* 求最大面积正方形： **[MaximalSquare](src/main/java/com/leetcode/dp/MaximalSquare.kt)**
* 求二维矩形内某一个形状的和 [RangeSumQuery2D](src/main/java/com/leetcode/dp/RangeSumQuery2D.kt)

## 数据结构
### [跳表](https://lotabout.me/2018/skip-list/)

跳表的构建过程
1. 在插入过程中，只保证向下和向左查找
2. 直到最下层中找到插入位置，将target 置成随机层高，如果当前随机层高大于当前最大层高，则从head中的每一层的末尾指向当前target
[自我丑陋版SkipList](src/main/java/com/CollectionsUtil.kt)

![skiplist.png](https://lotabout.me/2018/skip-list/skip-list-insert-17.svg)

### 并查集
使用一个数组保存各节点之间的连接信息，可以用来判断给定的节点是否存在环路
[简陋版UF](src/main/java/com/UF.kt)

![uf.png](https://oi-wiki.org/ds/images/dsu1.png)



## Kotlin 使用
#### 谨慎 if 表达式
[carefulIfExpression](src/test/java/com/IfExpression.kt)
```kotlin
private fun add(i: Int, j: Int): Int = 2 + if (i == 1) 0 else i + if (j == 1) 0 else j
```
中 + 操作符优先于 return , 实际为
```java
   private final int add(int i, int j) {
      return  2 + (i == 1 ? 0 : i + (j == 1 ? 0 : j));
   }
```
正确写法
```kotlin
    private fun add(i: Int, j: Int): Int = 2 + if (i == 1) 0 else {
        i
    } + if (j == 1) 0 else j
```


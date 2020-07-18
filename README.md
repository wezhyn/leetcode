## 典型题型

### Min-Max
A,B 轮流选择一个队尾和队首的元素，当队列为空时，判断A,B谁拿取的总数最大

[StoneGame](src/main/java/com/leetcode/graph/StoneGame.kt)
给定一个数组，Alex 每次从数组的最左边或者最右边挑选一个，Lee 也是同样的操作，每次每人的选择都是最优的<br>
求最后的输赢关系

*Example 1:*

```
Input: [5,3,4,5]
Output: true
Explanation: 
Alex starts first, and can only take the first 5 or the last 5.
Say he takes the first 5, so that the row becomes [3, 4, 5].
If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
```

<hr>

### 规律
寻找数字间存在的规律，划分区间

[NumberOfDigitOne](src/main/java/com/offer/NumberOfDigitOne.kt)
给定一个n，求 [1,n] 区间内，1 出现的次数
> Example： <br>
> Input: 13 <br>
>Output: 6 <br>
>Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

[NthDigit](src/main/java/com/offer/NthDigit.kt) 
给定一个无限长的字符串，规律是 123456789101112..x(x+1)...n<br>
求第 n 个数字 所在的整数x
>Input: 11 <br>
>Output: 0 <br>
> Explanation:
 The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.


[丑数](src/main/java/com/offer/UglyNumberII.kt): 2<sup>i</sup>3<sup>j</sup>5<sup>k</sup><br>
求第 n 个丑数
> Input: n=10 <br>
> Output: 12 <br>
> Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

<hr>

### 排序的变种(O(n<sup>2</sup>)算法时考虑)
1. 基于归并排序的递归回退思路，从小数组到大数组
2. 基于快排分治的思路，将数组划分成左右数组
> 当在数组中使用 O(n<sup>2</sub>)的时间复杂度时，可以考虑使用排序的变种

#### 归并 [Reverse Pairs](src/main/java/com/offer/ReversePairs.kt)

Given an array `nums`, we call `(i, j)` an **_important reverse pair_** if `i < j` and `nums[i] > 2*nums[j]`.

You need to return the number of important reverse pairs in the given array.

**Example1:**

```
Input: [1,3,2,3,1]
Output: 2
```


### 二分查找(有序 O(n))
> 基于二分的思想，将 O(n) 变成 O(NlogN)
#### [Find First and Last Position of Element in Sorted Array](src/main/java/com/offer/FindFirstAndLastPositionOfElementInSortedArray.kt)

给定一个有序递增数组，查找目标 `target` 的最左端和最右端

**Example 1:**

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```
#### [数组中数值和下标相等的元素](src/main/java/com/offer/NumsEqualsSubscript.kt)
假设一个单调递增的数组里的每个元素都是整数并且是唯一的。

实现一个函数找出数组中任意一个数值等于其下标的元素。

**Example:**

```
Input: nums = [-3, -1, 1, 3, 5]
Output: 3
```

### 二叉树的查找
1. 前序遍历的利用
2. 中序遍历的利用
3. 后序遍历的利用[需要对左右子树先行进行特殊处理]

#### 非递归前序遍历[树的最大深度](src/main/java/com/offer/MaximumDepthOfBinaryTree.kt)

Given a binary tree, find its maximum depth.

**Example:**

```
Input:
    3
   / \
  9  20
    /  \
   15   7

output: 3
```


#### 非递归中序遍历[Kth Smallest Element in a BST](src/main/java/com/offer/KthSmallestElementInABST.kt)

Given a binary search tree, write a function `kthSmallest` to find the **k**th smallest element in it.

**Example:**

```
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
```

#### 递归后序遍历[检查是否是平衡二叉树](src/main/java/com/offer/KthSmallestElementInABST.kt)

给定一棵二叉树，判断该树是不是平衡二叉树
> 任意左右子树，高度差不大于1

**Example:**

```
Input: root = [3,3,8,null,4]
   5
  / \
 3   8
  \
   4
Output: true
```

### 回溯法
回溯法适合由多个步骤组成的问题，每一个步骤都有多个选择，
如果用树形象的表示，在某一个节点有n个子节点，树的叶子节点为最终状态。
在当前叶子节点不满足约束时，回溯到上一个节点

#### 字典中回溯寻找单词
[WordSearch](src/main/java/com/offer/WordSearch.kt)

#### 数字全排序
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


## 典型题型

### Min-Max
A,B 轮流选择一个队尾和队首的元素，当队列为空时，判断A,B谁拿取的总数最大
[StoneGame](src/main/java/com/leetcode/graph/StoneGame.kt)

### SP
#### Dijkstra
[NetworkDelayTime](src/main/java/com/leetcode/graph/NetworkDelayTime.kt)

#### Bellman-Ford
[CheapestFlightsWithinKStops](src/main/java/com/leetcode/graph/CheapestFlightsWithinKStops.kt)

### DP

#### 自底向上回溯模拟
[DungeonGame](src/main/java/com/leetcode/dp/DungeonGame.kt)

#### [hard][DP]
**[BurstBalloons](src/main/java/com/leetcode/dp/BurstBalloons.kt)**
> 逆向思维思考子步骤

#### 特殊形状的图形 [DP]
**[MaximalSquare](src/main/java/com/leetcode/dp/MaximalSquare.kt)**

### Kotlin 使用
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


# 动态规划（一）

## 定义

动态规划可以理解为用来优化递归的，比起递归，它少去了重复计算的部分。

## 通过 Fibonacci Sequence 理解递归

定义 Fibonacci 数列为：`0 1 1 2 3 5 8 13 ...`

即从第三个数起，第 n 的数的值为前两个数的和。写一段程序来求第 n 个数的值。

### 递推公式

第一步，根据题目可得递推公式：

``` java
Fib(i) = Fib(i - 1) + Fib(i - 2);
```

### 递归出口

第二步，寻找递归出口，很显然当 i == 0 时，Fib(i) == 0，当 i == 1 时，Fib(i) == 1。

所以，递归方法的代码为：

``` java
public int fibnacci(int i) {
  if (i == 0) {
    return 0;
  }
  if (i == 1) {
    return 1;
  }
  return fibnacci(i - 1) + fibnacci(i - 2);
}
```
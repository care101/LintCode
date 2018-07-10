# 动态规划（四）

序列型动态规划。

## Longest Increasing Subsequence

[题目](https://www.lintcode.com/problem/longest-increasing-subsequence/description)：找出一个数组中最长递增子序列的长度。

### 状态

设计一个长度为 arr 的一位数组 `dp[]`，dp[i] 代表 arr[0...i] 为止的最长递增子序列的长度。

### 状态方程

当 dp[i] < dp[i - 1] 时，dp[i] = 1。因为此时不可能再递增下去。
当 dp[i] > dp[i - 1] 时，dp[i] = max(dp[0...i - 1])。这时选择 dp[0...i - 1] 中的最大值再加一赋给 dp[1]。

### 初始化与结果

`dp[0]` 代表 arr 中前 0 个数的最长递增子序列长度，当然是 0。最后返回 dp 中的最大值。

### DP 代码

``` java
public int longestIncreasingSubsequence(int[] nums) {
  if (nums == null || nums.length == 0) {
    return 0;
  }
  int[] dp = new int[nums.length];
  dp[0] = 1;
  for (int i = 1; i < nums.length; i++) {
    if (nums[i] < nums[i - 1]) {
      dp[i] = 1;
    }
    for (int j = 0; j < i; j++) {
      if (nums[j] < nums[i]) {
        dp[i] = Math.max(dp[j] + 1, dp[i]);
      }
    }
  }

  int max = 0;
  for (int i = 0; i < dp.length; i++) {
    max = Math.max(max, dp[i]);
  }
  return max;
}
```

## Longest Common Subsequence

[题目](https://www.lintcode.com/problem/longest-common-subsequence/description)：在两个字符串中，找出它们的最长公共子序列，返回长度。

### 状态

假设 str1 的长度为 M，str2 的长度为 N，那么设计大小为 M*N 的二维数组 `dp[][]`，dp[i][j] 代表 str1[0...i] 和 str2[0...j] 的最长公共子序列的长度。

### 状态方程

dp[i][j] 的值有三种情况：

1. `dp[i][j] = dp[i - 1][j]`：代表 dp[i][j] 等于 str1[0...i-1] 与 str2[0...j] 的最长公共子序列的长度。
2. `dp[i][j] = dp[i][j - 1]`：代表 dp[i][j] 等于 str1[0...i] 与 str2[0...j - 1] 的最长公共子序列的长度。
3. `dp[i][j] = dp[i - 1][j - 1] + 1`：当 `str1[i] == str2[j]` 时，dp[i][j] 等于 str1[0...i - 1] 与 str2[0...j - 1] 的最长公共子序列的长度，再加上它本身的长度 1。

``` java
dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + 1)
```

### 初始化与结果

二维数组一般是初始化第一行和第一列，所以：

- dp[i][0] 表示 str1[0...i] 与 str2[0] 的最长公共子序列的长度，由于 str2[0] 的长度等于 1，因此当 `str1[i] == str2[0]` 时，小于 i 的 dp[i][0] = 0，大于 i 的 dp[i][0] = 1。
- dp[0][j] 同理，由于 str1[0] 的长度等于 1，小于 j 的 dp[0][j] = 0，大于 j 的 dp[0][j] = 1。

最后返回 dp 的最后一个数。

### DP 代码

``` java
public int longestCommonSubsequence(String A, String B) {
  if (A == null || A.length() == 0 || B == null || B.length() == 0) {
    return 0;
  }
  int[][] dp = new int[A.length()][B.length()];
  // initialize
  for (int i = 0; i < dp.length; i++) {
    dp[i][0] = 0;
    if(A.charAt(i) == B.charAt(0)) {
      for (int k = i; k < dp.length; k++) {
        dp[k][0] = 1;
      }
      break;
    }
  }
  for (int j = 0; j < dp[0].length; j++) {
    dp[0][j] = 0;
    if(B.charAt(j) == A.charAt(0)) {
      for (int k = j; k < dp[0].length; k++) {
        dp[0][k] = 1;
      }
      break;
    }
  }
  // traverse
  for (int i = 1; i < dp.length; i++) {
    for (int j = 1; j < dp[0].length; j++) {
      int temp1 = dp[i - 1][j];
      int temp2 = dp[i][j - 1];
      dp[i][j] = Math.max(temp1, temp2);
      if(A.charAt(i) == B.charAt(j)) {
        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
      }
    }
  }
  return dp[dp.length - 1][dp[0].length - 1];
}
```
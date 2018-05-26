# 双指针算法

## 相向双指针

相向双指针，指的是在算法一开始，两根指针分别位于数组或字符串的两端，相向而行。常见的算法题有：翻转字符串，比如在[binary search笔记](binarysearch.md)中的三步翻转法。

双指针模版的`for`循环写法：

``` java
public void reverse(int[] A) {
  for (int i = 0, j = A.length - 1; i < j; i++, j--) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}
```

双指针模版的`while`循环写法：

``` java
public void reverse(int[] A) {
  int start = 0, end = A.length - 1;
  while (start < end) {
    int temp = A[satrt];
    A[start] = A[end];
    A[end] = temp;
    start++;
    end--;
  }
}
```
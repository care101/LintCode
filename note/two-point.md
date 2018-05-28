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

### Two Sum

寻找一个数组中想加起来等于 target 的两个数。例如：

`[2, 7, 10, 13]`, target = `9`.

return: `[0,1]`

法一：利用 HashSet(或HashMap)。遍历数组，通过判断当前值的另一半是否在 HashSet 中来同时找到两个值。

``` java
public int[] twoSum(int[] A, int target) {
  int[] results = new int[2];
  if (A == null || A.length == 0) {
    return results;
  }

  Set<Integer> set = new HashSet<>();
  for (int i = 0; i < A.length; i++) {
    if (set.contains(target-A[i])) {
      results[0] = target - A[i];
      results[1] = A[i];
      return results;
    } else {
      set.add(A[i]);
    }
  }

  return results;
}
```

法二：双指针法。先将数组排序，左右指针分别指向头和尾，如果当前两个指针指向的值相加小于target，那么左指针++；如果当前两个指针指向的值相加大于target，那么右指针--。

``` java
public int[] twoSum(int[] A, int target) {
  int[] results = new int[2];
  if (A == null || A.length == 0) {
    return results;
  }

  Arrays.sort(A);

  int left = 0, right = A.length - 1;
  while (left < right) {
    if (A[left] + A[right] < target) {
      left++;
    }
    if (A[left] + A[right] > target) {
      right--;
    }
    if (A[left] + A[right] == target) {
      results[0] = A[left];
      results[0] = A[right];
      return results;
    }
  }
  return results;
}
```
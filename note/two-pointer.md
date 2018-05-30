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

其中 HashMap 的解法需要 `O(n)` 的空间与时间，双指针的解法需要 `O(1)` 的空间与 `O(n)` 的时间。

### 判断回文串

``` java
public boolean isPalindrome(String s) {
  if (s == null || s.length() == 0) {
    return true;
  }
  for (int i = 0, i = s.length() - 1; i < j; i++, j--) {
    if (s.charAt(i) != s.charAt(j)) {
      return false;
    }
  }
  return true;
}
```

Follow up: 判断回文串的时候不区分大小写，且忽略非英文字母。

对于不区分大小写这一点可以在比较时统一变成小写或大写来比较。忽略非英文字母需要使用`while`来不断跳过非英文字母。

``` java
public boolean isPalindrome(String s) {
  if (s == null || s.length() == 0) {
    return true;
  }

  int start = 0, end = s.length() - 1;
  while (start < end) {
    while (start < s.length() && !isValid(s.charAt(start))) {
      start++;
    }
    if (start == s.length()) {
      return true;
    }
    while (end >= 0 && !isValid(s.charAt(end))) {
      end--;
    }

    if (Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))) {
      break;
    } else {
      start++;
      end--;
    }
  }

  return end <= start;
}

private boolean isValid(char c) {
  return Character.isLetter(c) || Character.isDigit(c);
}
```

## 同向双指针

同向双指针指的是两根指针都从头出发，朝着一个方向前进。可以解决以下问题：

- 数组去重问题 Remove duplicates in an array
- 滑动窗口问题 Window Sum
- 两数之差问题 Two Difference
- 链表中点问题 Middle of Linked List
- 带环链表问题 Linked List Cycle

### 数组去重问题

``` java

```
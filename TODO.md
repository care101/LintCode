# TO DO

- 添加 python 和 JavaScript 版本

## String

[string](note/string.md)

- 比较 js 和 java 在字符串基础知识上的区别

## binarysearch

[binary search](note/binarysearch.md)

- 补充三步翻转法, 快速幂算法, 辗转相除法的代码。

## Two Pointer

- [Valid Palindrome II](https://www.lintcode.com/problem/valid-palindrome-ii/description): 我的删除算法出了错。不能理解答案里的`isValid(s, start + 1, end)`, `isValid(s, start, end - 1)`这两句。

``` java
private boolean isValid(String s, int delete) {
  StringBuilder builder = new StringBuilder(s);
  builder.deleteCharAt(delete);

  String newS = builder.toString();

  int start = 0, end = newS.length() - 1;
  while (start < end) {
    if (newS.charAt(start) != newS.charAt(end)) {
      return false;
    }
    start++;
    end--;
  }
  return true;
}
```

- [两数之差](src/org/likexin/twopointer/TwoSum7.java)的同向双指针解法。
- 数据流问题。
package org.likexin.string;

/**
 * http://www.lintcode.com/problem/strstr
 *
 * @author Shingo Lee
 */
public class StrStr {

  public static void main(String[] args) {
    System.out.println(new StrStr().strStr("abcdef", "ef"));
  }

  /**
   * 每一位每一位的遍历，时间复杂度O(n^2).
   *
   * @param source 母串
   * @param target 目标串
   * @return 目标串在母串中第一次出现的位置
   */
  public int strStr(String source, String target) {
    if (source == null || target == null) {
      return -1;
    }
    int j;
    for (int i = 0; i < source.length() - target.length() + 1; i++) {
      for (j = 0; j < target.length(); j++) {
        if (source.charAt(i + j) != target.charAt(j)) {
          break;
        }
      }
      if (j == target.length()) {
        return i;
      }
    }
    return -1;
  }

}

package org.likexin.string;

public class RotateString {

  /**
   * 先旋转 str[0...offset] 的部分，
   * 再旋转 str[offset...str.length] 的部分，
   * 再旋转整个数组。
   *
   * 要注意当 offset > str.length 的情况
   *
   * @param str: An array of char
   * @param offset: An integer
   * @return: nothing
   */
  public void rotateString(char[] str, int offset) {
    if (str == null || str.length == 0) {
      return;
    }
    offset = offset % str.length;
    reverse(str, 0, str.length - offset - 1);
    reverse(str, str.length - offset, str.length - 1);
    reverse(str, 0, str.length - 1);
  }

  private void reverse(char[] str, int i, int j) {
    while (i < j) {
      char temp = str[i];
      str[i] = str[j];
      str[j] = temp;
      i++;
      j--;
    }
  }
}

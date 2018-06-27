package org.likexin.string;

public class UniqueChar {

  /**
   * TODO: "aacbdd" 这个 case 不通过
   *
   * @param str: str: the given string
   * @return: char: the first unique character in a given string
   */
  public char firstUniqChar(String str) {
    if (str == null || str.length() == 0) {
      return ' ';
    }
    int[] count = new int[26];
    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i) - 'a']++;
    }

    for (int i = 0; i < count.length; i++) {
      if (count[i] == 1) {
        return (char)(i + 'a');
      }
    }
    return ' ';
  }
}

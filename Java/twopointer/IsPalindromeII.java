package org.likexin.twopointer;

public class IsPalindromeII {

  public boolean isPalindromeII(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    int start = 0, end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        // delete start or end
        if (isValid(s, start + 1, end) || isValid(s, start, end - 1)) {
          start++;
          end--;
        } else {
          break;
        }
      } else {
        start++;
        end--;
      }
    }
    return end <= start;
  }

  private boolean isValid(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

}

package org.likexin.twopointer;

public class IsPalindrome {

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

}

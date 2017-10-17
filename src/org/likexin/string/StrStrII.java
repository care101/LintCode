package org.likexin.string;

/**
 * http://www.lintcode.com/problem/strstrII
 *
 * @author Shingo Lee
 */
public class StrStrII {

    private final static int BASE = 1000000;

    /**
     * Rabin-Karp算法，和暴力遍历的解法类似，但使用哈希函数将字符串转换为整数，将在母串中找个这个字符串并比较这个字符串的时间缩短为O(1)。
     * 总的时间复杂度为O(m+n).
     *
     * @param source 母串
     * @param target 目标串
     * @return 目标串在母串中第一次出现的位置
     */
    public int strStrII(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int m = target.length();
        if (m == 0) {
            return 0;
        }

        // 31 ^ m
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }

        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        int hashCode = 0;
        for (int i = 0; i < source.length(); i++) {
            // abc + d
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            if (i < m - 1) {
                continue;
            }
            // abcd - a
            if (i >= m) {
                hashCode = hashCode - (power * source.charAt(i - m)) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }
            // double check
            if (hashCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStrII().strStrII("abcdef", "ef"));
    }

}

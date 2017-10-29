package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/divide-two-integers/
 *
 * @author Shingo Lee
 */
public class DivideTwoIntegers {

    /**
     * 这题要求不能使用除法乘法求余等运算，那么这时候一定要想到还有位运算能够做乘除。左移即乘2，右移即除2。
     * 注意：许多边界条件以及正负号。
     * 参考：https://www.youtube.com/watch?v=uD1Cw1JbD8E
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return 商
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        Long a = Math.abs((long)dividend);
        Long b = Math.abs((long)divisor);
        boolean isNegative = (dividend > 0) && (divisor < 0) || (dividend < 0 && divisor > 0);
        int result = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(-1, 1));
    }

}

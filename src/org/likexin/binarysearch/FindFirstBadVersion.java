package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/first-bad-version/
 *
 * @author Shingo Lee
 */
public class FindFirstBadVersion {

    /**
     * 要注意的是start从1开始，因为版本号没有从0开始的。
     *
     * @param n 版本号
     * @return 第一个错误的版本号
     */
    public int findFirstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }

        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (!SVNRepo.isBadVersion(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        if (SVNRepo.isBadVersion(end)) {
            return end;
        }
        return -1;
    }

}

class SVNRepo {
    public static boolean isBadVersion(int k) {
        return true;
    }
}

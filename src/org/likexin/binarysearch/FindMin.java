package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/
 *
 * @author Shingo Lee
 */
public class FindMin {

    /**
     * 如果中间的数小于最右边的数，说明右边是无序的；如果中间的数大于最右边的数，说明左边是无序的；如果中间的数等于最右边的数，说明整个数组都是一样的。
     *
     * @param nums 目标数组
     * @return 最小的数
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        int number = nums[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > number) {
                start = mid;
            } else if (nums[mid] < nums[start]) {
                end = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return start;
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new FindMin().findMin(nums));

        int[] nums1 = {1, 1, 1, 1, 1};
        System.out.println(new FindMin().findMin(nums1));

        int[] nums2 = {3, 4, 5, 1, 2};
        System.out.println(new FindMin().findMin(nums2));
    }

}

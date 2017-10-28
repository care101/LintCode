package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/maximum-number-in-mountain-sequence/#
 *
 * @author Shingo Lee
 */
public class MountainSequence {

    /**
     * 典型二分法，可以发现二分法不仅只针对有序数组，像这种先升后降或者先降后升的数组也有效，当然这也算是在部分有序的前提下。
     *
     * @param nums 目标元素
     * @return 目标元素的峰值
     */
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 6, 3};
        System.out.println(new MountainSequence().mountainSequence(nums));
    }

}

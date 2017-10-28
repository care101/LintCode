package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/last-position-of-target/
 *
 * @author Shingo Lee
 */
public class LastPosition {

    /**
     * 在使用二分法的时候，由于是判断最后一次出现的位置，那么当中间位置的数与target相等时，也要再往后半段移动。在最终判断start与end的位置时，应该优先判断end位置的情况。
     *
     * @param nums 目标数组(已排好序)
     * @param target 目标元素
     * @return 目标元素在目标数组中最后一次出现的位置
     */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 5};
        System.out.println(new LastPosition().lastPosition(nums, 5));
    }

}

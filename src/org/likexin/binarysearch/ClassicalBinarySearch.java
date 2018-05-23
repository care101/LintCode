package org.likexin.binarysearch;

public class ClassicalBinarySearch {

    public int findPosition(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        }
        if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        }
        return -1;
    }

}

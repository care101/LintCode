package org.likexin.twopointer;

public class QuickSelect {

  /**
   * 利用了快排的思想：先整体有序再部分有序。不同于快排的点在于当选择递归时，可以根据 k 值所处的位置选择递归左边还是右边。
   * 时间复杂度：O(n)
   * 空间复杂度：O(1)
   */
  public int kthLargestElement(int k, int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    return quickSelect(nums, 0, nums.length - 1, k);
  }

  private int quickSelect(int[] nums, int start, int end, int k) {
    if (start == end) {
      return nums[start];
    }

    int left = start, right = end;
    int pivot = nums[(start + end) / 2];

    while (left <= right) {
      while (left <= right && nums[left] > pivot) {
        left++;
      }
      while (left <= right && nums[right] < pivot) {
        right--;
      }
      if (left <= right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
      }
    }


    /**
     *
     *     k'              K''
     *     |               |
     * x x x x x x x x x x x x x x
     * |       |   |             |
     * s     right left          e
     *
     */


    if (start + k - 1 <= right) {
      return quickSelect(nums, start, right, k);
    }
    if (start + k - 1 >= left) {
      return quickSelect(nums, left, end, k - (left - start));
    }
    return nums[right + 1];
  }

}

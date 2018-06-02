package org.likexin.twopointer;

public class PartitionArray {

  /**
   * partition 就是快排里的 partition，只是边界条件要重新确认。
   *
   * 1. 快排里是将 <= pivot 的都扔到左边，将 >= pivot 的都扔到右边，对应程序里的 nums[left] < k 和 nums[right] > k。这里是为了避免 stack overflow。
   *
   * 2. 而这里需要将 < pivot 的扔到左边，>= pivot 的扔到右边，对应程序里的 nums[left] < k 和 nums[right] >= k。
   */
  public int partitionArray(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      while (left <= right && nums[left] < k) {
        left++;
      }
      while (left <= right && nums[right] >= k) {
        right--;
      }

      if (left <= right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left--;
        right++;
      }
    }
    return left;
  }

}

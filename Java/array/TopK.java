package org.likexin.array;

public class TopK {

  /**
   * @param nums: an integer array
   * @param k: An integer
   * @return: the top k largest numbers in array
   */
  public int[] topk(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    quickSort(nums, 0, nums.length - 1);

    int[] topK = new int[k];
    for (int i = 0; i < topK.length; i++) {
      topK[i] = nums[i];
    }
    return topK;
  }

  private void quickSort(int[] nums, int start, int end) {
    if (start >= end) {
      return;
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

        left++; right--;
      }
    }

    quickSort(nums, left, end);
    quickSort(nums, start, right);
  }

}

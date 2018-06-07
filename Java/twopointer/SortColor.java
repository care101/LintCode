package org.likexin.twopointer;

public class SortColor {

  /**
   * 双指针法，第一个 for 先把 2 都扔到右边，处理的方式就是 i 遍历到的数如果是 2 就与 end 位置上的数交换，end--向前移动一位。
   * 第二个 for 在左半边把 0, 1 分开，处理的方式同上。
   */
  public void sortColor(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int start = 0, end = nums.length - 1;

    for (int i = 0; i <= end; i++) {
      while (nums[end] == 2) {
        end--;
      }
      if (i <= end && nums[i] == 2) {
        nums[i] = nums[end];
        nums[end--] = 2;
      }
    }

    for (int i = end; i >= start; i--) {
      while (nums[start] == 0) {
        start++;
      }
      if (i >= start && nums[i] == 0) {
        nums[i] = nums[start];
        nums[start++] = 0;
      }
    }
  }

  /**
   * 三指针法：总的思路和双指针法差不多，指针这里的两根指针分别指向头和尾，还有一根指针用来遍历整个数组。当遍历到的数等于 0，那么就和 start 指针交换；遍历到的数等于 2，就和 end 指针交换；遍历到的数等于 1 就不做什么。
   */
  public void sortColor2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int start = 0, i = 0, end = nums.length - 1 ;

    while (i <= end) {
      if (nums[i] == 0) {
        swap(nums, start, i);
        start++;
        i++;
      } else if (nums[i] == 1) {
        i++;
      } else {
        swap(nums, end, i);
        end--;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}

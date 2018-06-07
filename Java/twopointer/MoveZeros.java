package org.likexin.twopointer;

public class MoveZeros {

  /**
   * 两根指针 p1, p2 一前一后，如果两根指针都为 0，p2向前走一步；如果 p1 为 0，p2 不为 0，那么交换。注意当 p2 为 0，p1 不为 0 时不需要交换，因为 0 本来就在靠后的位置，不需要交换到前面来。
   */
  public void moveZeros(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int p1 = 0, p2 = 1;
    while (p2 < nums.length) {
      if (nums[p1] == 0 && nums[p2] == 0) {
        p2++;
      } else if (nums[p1] == 0) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
        p1++;
        p2++;
      } else {
        p1++;
        p2++;
      }
    }
  }

}

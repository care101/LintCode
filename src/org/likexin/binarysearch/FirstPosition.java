package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/problem/first-position-of-target
 *
 * @author Shingo Lee
 */
public class FirstPosition {

  public static void main(String[] args) {
    int[] nums = {3, 3, 3, 3, 3, 3, 3};
    System.out.println(new FirstPosition().firstPosition(nums, 3));
  }

  /**
   * 与LastPosition相似，只是在中间元素与target相等与最后判断start与end的情况时与LastPosition的处理相反。
   *
   * @param nums   目标数组(已排好序)
   * @param target 目标元素
   * @return 目标元素在目标数组中第一次出现的位置
   */
  public int firstPosition(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        end = mid;
      } else if (nums[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (nums[start] == target) {
      return start;
    }
    if (nums[end] == target) {
      return end;
    }
    return -1;
  }

}

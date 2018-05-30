package org.likexin.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Deduplication {

  /**
   * 法一：将数组放入HashSet中过滤，并记得最后篡改原数组。耗费O(n)的时间复杂度与O(n)的空间复杂度。
   */
  public int deduplication(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!set.contains(nums[i])) {
        set.add(nums[i]);
      }
    }

    int result = 0;
    Iterator ii = set.iterator();
    while (ii.hasNext()) {
      nums[result++] = (int) ii.next();
    }
    return result;
  }

  /**
   * 法二：双指针法，先将数组排序，快指针走得快遍历整个数组，慢指针走得慢，指向不重复的最后一个数。
   * 当发现快指针和慢指针不相同时，将快指针的值赋给慢指针，并且慢指针++。
   */
  public int deduplication2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Arrays.sort(nums);
    int len = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != nums[len]) {
        nums[++len] = nums[i];
      }
    }
    return len + 1;
  }
}

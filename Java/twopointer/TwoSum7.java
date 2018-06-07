package org.likexin.twopointer;

import java.util.HashMap;

public class TwoSum7 {

  /**
   * 使用HashMap
   */
  public int[] twoSum7(int[] nums, int target) {
    int[] results = new int[2];
    if (nums == null || nums.length == 0) {
      return results;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i] + target)) {
        results[0] = Math.min((map.get(nums[i] + target) + 1), i + 1);
        results[1] = Math.max((map.get(nums[i] + target) + 1), i + 1);
        return results;
      }
      else if (map.containsKey(nums[i] - target)) {
        results[0] = Math.min((map.get(nums[i] - target) + 1), i + 1);
        results[1] = Math.max((map.get(nums[i] - target) + 1), i + 1);
        return results;
      }
      else {
        map.put(nums[i], i);
      }
    }
    return results;
  }
}

package org.likexin.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/subsets
 *
 * @author Shingo Lee
 */
public class Subsets {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> results = new Subsets().subsets(nums);
    System.out.println(results);
  }

  /**
   * 一般来说，题目要求找所有可能的结果，优先考虑使用深度优先搜索。
   *
   * @param nums 目标数组
   * @return 所有子集
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    if (nums == null) {
      return results;
    }
    if (nums.length == 0) {
      results.add(new ArrayList<>());
      return results;
    }

    helper(nums, 0, list, results);
    return results;
  }

  private void helper(int[] nums, int offset, List<Integer> subset, List<List<Integer>> results) {
    results.add(new ArrayList<>(subset));
    for (int i = offset; i < nums.length; i++) {
      subset.add(nums[i]);
      helper(nums, i + 1, subset, results);
      subset.remove(subset.size() - 1);
    }
  }

}

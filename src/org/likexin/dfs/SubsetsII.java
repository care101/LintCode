package org.likexin.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/subsets-ii
 *
 * @author Shingo Lee
 */
public class SubsetsII {

    /**
     * 这题与 subsets 这题相比，多了两点：1.对数组进行排序; 2.后面如果遇到nums中相邻两数相等的话则不添加到subsets中。
     *
     * @param nums 目标数组
     * @return 所有不重复子集
     */
    public List<List<Integer>> subsetsII(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);
        helper(nums, 0, list, results);
        return results;
    }

    private void helper(int[] nums, int offset, List<Integer> subset, List<List<Integer>> results) {
        results.add(new ArrayList<>(subset));
        for (int i = offset; i < nums.length; i++) {
            // 判断 i != offset 是为了判断当前这个数有没有被挑选过。当当前这个数没有被挑选过并且它和前一个数相等，那么就continue掉。
            if (i != offset && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i  + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new SubsetsII().subsetsII(nums));
    }
}

package org.likexin.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/subarray-sum/
 *
 * @author Shingo Lee
 */
public class SubarraySum {

    /**
     * 可以这样理解，如果[0,a]相加等于sum，[0,b]相加也等于sum，那么[a,b]相加应该等于0。
     * 所以用一个map来记录sum与位置i的关系，当map中出现重复sum，表示找到了[a,b]。
     *
     * @param nums 一个有正有负的数组
     * @return 相加等于零的子序列的起始位置和终止位置
     */
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }
            map.put(sum, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1};
        System.out.println(new SubarraySum().subarraySum(nums));
    }

}

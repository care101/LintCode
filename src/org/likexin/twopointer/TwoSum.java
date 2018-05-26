package org.likexin.twopointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 使用HashMap
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];
        if (numbers == null || numbers.length == 0) {
            return results;
        }

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                results[0] = map.get(target - numbers[i]);
                results[1] = i;
                return results;
            }
            map.put(numbers[i], i);
        }

        return results;
    }
}

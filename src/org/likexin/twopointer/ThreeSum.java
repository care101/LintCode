package org.likexin.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] numbers) {
    List<List<Integer>> results = new ArrayList<>();
    if (numbers == null || numbers.length == 0) {
      return results;
    }

    Arrays.sort(numbers);

    for (int i = 0; i < numbers.length; i++) {
      // 判断重复
      if (i > 0 && numbers[i] == numbers[i - 1]) {
        continue;
      }

      int left = i + 1;
      int right = numbers.length - 1;
      int target = -numbers[i];

      twoSum(numbers, left, right, target, results);
    }

    return results;
  }

  private void twoSum(int[] numbers,
                      int left,
                      int right,
                      int target,
                      List<List<Integer>> results) {

    int begin = left;
    while (left < right) {
      // 判断重复
      if (left > begin && numbers[left] == numbers[left - 1]) {
        left++;
        continue;
      }

      if (numbers[left] + numbers[right] < target) {
        left++;
      } else if (numbers[left] + numbers[right] > target) {
        right--;
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(-target);
        list.add(numbers[left]);
        list.add(numbers[right]);
        results.add(list);
        left++;
        right--;
      }
    }
  }

}

package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/
 *
 * @author Shingo Lee
 */
public class SearchBigSortedArray {

    /**
     * 这道题最主要的是，这是一个很大的数组，因此要确定end的值为多少，这里用了倍增法来找边界。找到了边界后，这题就变为了FirstPosition了。
     *
     * @param reader 获取大数组里的值的对象
     * @param target 目标元素
     * @return 目标元素在排好序的大数组中第一次出现的对象
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader == null) {
            return -1;
        }
        // 倍增找边界
        int end = 1;
        while (end > 0) {
            if (reader.get(end) >= target) {
                break;
            }
            end *= 2;
        }
        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                end = mid;
            } else if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }

}

class ArrayReader {
    public int get(int k) {
        int[] nums = {1,2,3,4,5,6};
        return nums[k];
    }
}

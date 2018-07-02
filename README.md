# LintCode

LintCode/LeetCode algorithm written by Java or python or something else.

## Binary Search

| #   |  Problem  |  Solution  |  Keywords  |
| --- | --------- | :--------: | :--------: |
|1|[Classical Binary Search](https://www.lintcode.com/problem/classical-binary-search/)|[Java](Java/binarysearch/ClassicalBinarySearch.java)|  |
|2|[Maximum Number in Mountain Sequence](http://www.lintcode.com/en/problem/maximum-number-in-mountain-sequence/)|[Java](Java/binarysearch/MountainSequence.java)| |
|3|[Last Position of Target](http://www.lintcode.com/en/problem/maximum-number-in-mountain-sequence/)|[Java](Java/binarysearch/LastPosition.java)| |
|4|[K Closest Numbers In Sorted Array](http://www.lintcode.com/en/problem/k-closest-numbers-in-sorted-array/)|[Java](Java/binarysearch/KClosestNumber.java)| |
|5|[Search in a Big Sorted Array](http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/)|[Java](Java/binarysearch/SearchBigSortedArray.java)|倍增法|
|6|[Find Minimum in Rotated Sorted Array](http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/)|[Java](Java/binarysearch/FindMin.java)||
|7|[Find Peak Element](http://www.lintcode.com/en/problem/find-peak-element/)|[Java](Java/binarysearch/FindPeak.java)||
|8|[First Bad Version](http://www.lintcode.com/en/problem/search-a-2d-matrix/)|[Java](Java/binarysearch/FindFirstBadVersion.java)||
|9|[Search in Rotated Sorted Array](http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/)|[Java](Java/binarysearch/Search.java)||
|10|[Recover Rotated Sorted Array](https://www.lintcode.com/problem/recover-rotated-sorted-array/description)|[Java](Java/binarysearch/RecoverRotatedSortedArray.java)||
|11|[Pow(x, n)](https://www.lintcode.com/problem/powx-n/description)|[Java](Java/binarysearch/MyPow.java)|快速幂算法|
|12|[Fast Power](https://www.lintcode.com/problem/fast-power/description)||**TODO**|
|13|**[二分法总结](Note/binarysearch.md)**||**[Summary](Note/binarysearch.md)**|

## Two pointer

| #   |  Problem  |  Solution  |  Keywords  |
| --- | --------- | :--------: | :--------: |
|1|[Two Sum](https://www.lintcode.com/problem/two-sum/description)|[Java](Java/twopointer/TwoSum.java)||
|2|[Valid Palindrome](https://www.lintcode.com/problem/valid-palindrome/description)|[Java](Java/twopointer/IsPalindrome.java)||
|3|[Valid Palindrome II](https://www.lintcode.com/problem/valid-palindrome-ii/description)|[Java](Java/twopointer/IsPalindromeII.java)||
|4|[deduplication](https://www.lintcode.com/problem/remove-duplicate-numbers-in-array/description)|[Java](Java/twopointer/Deduplication.java)||
|5|[Window Sum](https://www.lintcode.com/problem/window-sum/description)|[Java](Java/twopointer/WinSum.java)||
|6|[Two Sum - Difference equals to target](https://www.lintcode.com/problem/two-sum-difference-equals-to-target/description)|[Java](Java/twopointer/TwoSum7.java)||
|7|[Linked List Cycle](https://www.lintcode.com/problem/linked-list-cycle/note)|[Java](Java/twopointer/HasCycle.java)||
|8|[Quick Sort](https://www.lintcode.com/problem/sort-integers-ii/description)|[Java](Java/twopointer/QuickSort.java)|快速排序|
|9|[Merge Sort](https://www.lintcode.com/problem/sort-integers-ii/description)|[Java](Java/twopointer/MergeSort.java)|归并排序|
|10|[Kth Largest Element](https://www.lintcode.com/problem/kth-largest-element/description)|[Java](Java/twopointer/QuickSelect.java)|Top K|
|11|[Sort Colors](https://www.lintcode.com/problem/sort-colors/description)|[Java](Java/twopointer/SortColor.java)|三指针|
|12|[Move Zeros](https://www.lintcode.com/problem/move-zeroes/description)|[Java](Java/twopointer/MoveZeros.java)||
|13|[Partition Array](https://www.lintcode.com/problem/partition-array/description)|[Java](Java/twopointer/MoveZeros.java)||
|14|[3 Sum](https://www.lintcode.com/problem/3sum/description)|[Java](Java/twopointer/ThreeSum.java)||
|15|**[双指针算法总结](Note/two-pointer.md)**||**[Summary](Note/two-pointer.md)**|

## BFS

| #   |  Problem  |  Solution  |  Keywords  |
| --- | --------- | :--------: | :--------: |
|1|[Binary Tree Level Order Traversal](https://www.lintcode.com/problem/binary-tree-level-order-traversal/description)|[Java](Java/bfs/LevelOrder.java), [Python](Python/bfs/LevelOrder.py)||
|2|[Number of Islands](https://www.lintcode.com/problem/number-of-islands/description)|[Java](Java/bfs/NumIslands.java), [Python](Python/bfs/NumIslands.py)||
|3|[Topological Sorting](https://www.lintcode.com/problem/topological-sorting/description)|[Java](Java/bfs/TopSorting.java)|拓扑排序|
|4|[Word Ladder](https://www.lintcode.com/problem/word-ladder/description)|[Java](Java/bfs/WordLadder.java)|BFS+HashSet|
|5|**[BFS 算法总结](Note/bfs.md)**||**[Summary](Note/bfs.md)**|

## DFS

| #   |  Problem  |  Solution  |  Keywords  |
| --- | --------- | :--------: | :--------: |
|1|[Maximum Depth of Binary Tree](https://www.lintcode.com/problem/maximum-depth-of-binary-tree/description)|[Java](Java/dfs/MaxDepth.java), [Python](Python/dfs/MaxDepth.py), [JavaScript](JavaScript/dfs/MaxDepth.js)|遍历/分治|
|2|[Balanced Binary Tree](https://www.lintcode.com/problem/balanced-binary-tree/description)|[Java](Java/dfs/IsBalanced.java)|分治法|
|3|[Validate Binary Search Tree](https://www.lintcode.com/problem/validate-binary-search-tree/description)|[Java](Java/dfs/ValidBST.java), [JavaScript](JavaScript/dfs/ValidBST.js)|遍历/分治|
|4|[Closest Binary Search Tree Value](https://www.lintcode.com/problem/closest-binary-search-tree-value/description)|[Java](Java/dfs/ClosestValue.java), [JavaScript](JavaScript/dfs/ClosestValue.js)|二分|
|5|[Minimum Subtree](https://www.lintcode.com/problem/minimum-subtree/description)|[Java](Java/dfs/MinSubtree.java)|遍历+分治|
|6|[Triangle](https://www.lintcode.com/problem/triangle/description)|[Java](Java/dfs/Triangle.java)|分治+记忆搜索|
|7|**[DFS 算法总结](Note/dfs.md)**||**[Summary](Note/dfs.md)**|

## Array

| #   |  Problem  |  Solution  |  Keywords  |
| --- | --------- | :--------: | :--------: |
|1|[Maximum Subarray](https://www.lintcode.com/problem/maximum-subarray/description)|[Java](Java/array/MaxSubarray.java), [JavaScript](JavaScript/array/MaxSubarray.js), [Python](Python/array/MaxSubarray.py)|前缀和|
|2|[Median of two Sorted Arrays](https://www.lintcode.com/problem/median-of-two-sorted-arrays/description)|[Python](Python/array/MedianOfSortedArray.py)||
|3|[Implement Stack by Two Queues](https://www.lintcode.com/problem/implement-stack-by-two-queues/description)|[Java](Java/array/Stack.java)||
|4|**[Array 算法总结](Note/array.md)**||**[Summary](Note/array.md)**|

## String

| #   |  Problem  |  Solution  |  Keywords  |
| --- | --------- | :--------: | :--------: |
|1|[First Unique Character in a String](https://www.lintcode.com/problem/first-unique-character-in-a-string/description)|[Java](Java/string/UniqueChar.java),[Python](Python/string/UniqueChar.py)||
|2|**[String 算法总结](Note/string.md)**||**[Summary](Note/string.md)**|

## DP

| #   |  Problem  |  Solution  |  Keywords  |
| --- | --------- | :--------: | :--------: |
|1|[Minimum Path Sum](https://www.lintcode.com/problem/minimum-path-sum/description)|[Java](Java/dp/MinPathSum.java), [Python](Python/dp/MinimumPathSum.py)||
|2|[Unique Paths](https://www.lintcode.com/problem/unique-paths/description)|[Java](Java/dp/UniquePaths.java), [Python](Python/dp/UniquePaths.py)||
|3|**[Dynamic Programming 算法总结](Note/dp/dp.md)**||**[Summary](Note/dp/dp.md)**|
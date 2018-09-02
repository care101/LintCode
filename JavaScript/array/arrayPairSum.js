/**
 * 
 * 排序之后取偶数下标的值相加。注意 js 中的排序。
 * 
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function(nums) {
  if (nums === null || nums.length === 0) {
    return 0;
  }
  nums.sort(function(a, b) {
    return a - b;
  });
  let sum = 0;
  for (let i = 0; i < nums.length; i += 2) {
    sum += nums[i];
  }
  return sum;
};
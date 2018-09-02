/**
 * 
 * 打擂台
 * 
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
  if (nums === null || nums.length === 0) {
    return 0;
  }
  let max = 0;
  let sum = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === 1) {
      sum++;
    } else {
      max = max > sum ? max : sum;
      sum = 0;
    }
  }
  return max > sum ? max : sum;
};
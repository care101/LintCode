/**
 * @param nums: A list of integers
 * @return: A integer indicate the sum of max subarray
 */
const maxSubArray = function (nums) {
  if (nums === null) {
    return 0;
  }
  
  let prefixSum = 0, sum = 0, max = Number.MIN_SAFE_INTEGER;
  for (let i = 0; i < nums.length; i++) {
    prefixSum += nums[i];
    max = Math.max(max, prefixSum - sum);
    sum = Math.min(prefixSum, sum);
  }
  return max;
}
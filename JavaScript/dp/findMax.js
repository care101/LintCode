/**
 * 給定一個數組，從中選擇一堆不相鄰的數，使得相加和最大。
 */
const findMax = function(arr) {
  if (arr === null || arr.length === 0) {
    return 0;
  }
  if (arr.length === 1) {
    return arr[0];
  }
  if (arr.length === 2) {
    return Math.max(arr[0], arr[1]);
  }

  let dp = [];
  dp[0] = arr[0];
  dp[1] = Math.max(arr[0], arr[1]);

  for (let i = 2; i < arr.length; i++) {
    dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
  }
  return dp[dp.length - 1];
};
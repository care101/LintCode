/**
 * Time: O(n)
 * Space: O(n)
 * 
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  let count = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === 0) {
      count++;
    }
  }
  
  let newNums = [];
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== 0) {
      newNums.push(nums[i]);
    }
  }
  
  while (count > 0) {
    newNums.push(0);
    count--;
  }
  
  for (let i = 0; i < newNums.length; i++) {
    nums[i] = newNums[i];
  }
};

/**
 * Time: O(n)
 * Space: O(1)
 * 
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  let lastNoneZeros = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== 0) {
      nums[lastNoneZeros++] = nums[i];
    }
  }
  for (let i = lastNoneZeros; i < nums.length; i++) {
    nums[i] = 0;
  }
};
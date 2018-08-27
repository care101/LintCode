/**
 * 1. Sort
 * 
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  nums.sort();
  return nums[Math.floor(nums.length / 2)];
};


/**
 * 2. HashMap
 * 
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  let map = new Map();
  for (let i = 0; i < nums.length; i++) {
    if (!map.get(nums[i])) {
      map.set(nums[i], 1);
    } else {
      map.set(nums[i], map.get(nums[i]) + 1);
    }
  }
  
  for (let [key, value] of map) {
    if (value >= nums.length / 2) {
      return key;
    }
  }
};
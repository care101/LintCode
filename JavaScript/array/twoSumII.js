/**
 * HashMap
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
  if (numbers === null || numbers.length === 0) {
    return null;
  }
  let res = [];
  let map = new Map();
  for (let i = 0; i < numbers.length; i++) {
    if (!map.has(target - numbers[i])) {
      map.set(numbers[i], i);
    } else {
      res[0] = (i > map.get(target- numbers[i]) ? map.get(target- numbers[i]) : i) + 1;
      res[1] = (i < map.get(target- numbers[i]) ? map.get(target- numbers[i]) : i) + 1;
      return res;
    }
  }
  return res;
};
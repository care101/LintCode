/**
 * 將右上角或者左下角作為起點(start)來找。假如以右上角作為起點，那麼需要考慮三種情況：
 *  - 如果 target > start: 則橫坐標加一；
 *  - 如果 target < start: 則縱坐標減一；
 *  - 如果 target = start: 則返回 true。
 * 
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
  if (matrix === null || matrix.length === 0) {
    return false;
  }
  var row = matrix.length;
  var col = matrix[0].length;
  
  var i = 0;
  var j = col - 1;
  
  while (i <= row - 1 && j >= 0) {
    if (matrix[i][j] < target) {
      i = i + 1;
    } else if (matrix[i][j] > target) {
      j = j - 1;
    } else {
      return true;
    }
  }
  return false;
};
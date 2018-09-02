/**
 * @param {number[]} A
 * @return {boolean}
 */
var isMonotonic = function(A) {
  let flag = 0;
  
  for (let i = 0; i < A.length - 1; i++) {
    if (flag === 0) {
      if (A[i] < A[i + 1]) {
        flag = 1;
      } else if (A[i] > A[i + 1]) {
        flag = -1;
      }
    }
    if (flag === 1 && A[i] > A[i + 1]) {
      return false;
    }
    if (flag === -1 && A[i] < A[i + 1]) {
      return false;
    }
  }
  return true;
};
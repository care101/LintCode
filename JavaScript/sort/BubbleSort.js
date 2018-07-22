/**
 * 两两比较，将较大的放在后面。
 * 
 * @param A: an integer array
 * @return: 
 */
const sortIntegers = function (A) {
  if (A === null || A.length === 0) {
    return;
  }
  
  for (let i = 1; i < A.length - 1; i++) {
    for (let j = 0; j < i; j++) {
      if (A[i] > A[j]) {
        let temp = A[i];
        A[i] = A[j];
        A[j] = temp;
      }
    }
  }
}
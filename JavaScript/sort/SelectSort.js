/**
 * 每次循环，选择 [i, A.length - 1] 中最小的值，如果比 A[i] 小，则交换。
 * 
 * @param A: an integer array
 * @return: 
 */
const sortIntegers = function (A) {
  if (A === null || A.length === 0) {
    return;
  }
  
  for (let i = 0; i < A.length - 1; i++) {
    let min = minIndex(A, i + 1);
    if (A[i] > A[min]) {
      let temp = A[i];
      A[i] = A[min];
      A[min] = temp;
    }
  }
}

const minIndex = function(A, start) {
  let min = start;
  for (let i = start; i < A.length - 1; i++) {
    if (A[min] > A[i + 1]) {
      min = i + 1;
    }
  }
  return min;
}
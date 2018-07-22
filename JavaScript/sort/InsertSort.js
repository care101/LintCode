/**
 * 第 i 个数选择合适的位置插入 [0, i - 1] 有序序列中。
 * 
 * @param A: an integer array
 * @return: 
 */
const sortIntegers = function (A) {
  if (A === null || A.length === 0) {
    return;
  }
  
  for (let i = 1; i < A.length; i++) {
    for (let j = i - 1; j >= 0; j--) {
      if (A[j + 1] < A[j]) {
        let temp = A[j];
        A[j] = A[j + 1];
        A[j + 1] = temp;
      }
    }
  }
}
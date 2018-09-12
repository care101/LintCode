/**
 * binary search
 * @param {number[]} A
 * @return {number}
 */
var peakIndexInMountainArray = function(A) {
  if (A.length < 3) {
    return -1;
  }
  let start = 0, end = A.length - 1;
  while (start + 1 < end) {
    let mid = Math.round(start + (end - start) / 2);
    if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
      return mid;
    } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
      start = mid;
    } else {
      end = mid;
    }
  }
  return -1;
};
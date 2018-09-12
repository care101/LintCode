/**
 * @param {number[][]} A
 * @return {number[][]}
 */
var flipAndInvertImage = function(A) {
  if (A === null || A.length === 0 || A[0].length === 0) {
    return null;
  }
  let res = A.map(arr => {
    return arr.reverse().map(e => {
      return Number(!e);
    });
  })
  return res;
};
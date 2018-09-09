/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
  let index = 0;
  for (let c of S) {
    if (J.includes(c)) {
      index++;
    }
  }
  return index;
};
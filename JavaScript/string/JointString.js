/**
 * 拼接字符串，返回字典序最小的那一个。
 *
 * 比如：
 *  s = "b", t = "ba" => res = "bab"
 *
 *  s = "cba", t = "efg" => res = "abcefg"
 *
 * @param s
 * @param t
 * @returns {*}
 */
const jointString = function (s, t) {
  if (s === null && t === null) {
      return null;
  }
  s.split('').sort().join('');
  t.split('').sort().join('');
  let newS = s.concat(t);
  let newT = t.concat(s);
  let res;
  if (newS > newT) {
    res[0] = t;
    res[1] = s;
  } else {
    res[0] = s;
    res[1] = t;
  }
  return res;
};
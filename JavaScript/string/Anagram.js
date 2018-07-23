/**
 * 法一：将两个数组排序后再比较是否相等
 * 
 * @param s: The first string
 * @param t: The second string
 * @return: true or false
 */
const anagram = function (s, t) {
  return s.split('').sort().join('') === t.split('').sort().join('');
}

/**
 * 法二：用类似于哈希表的东西来保存字符出现的次数
 * 
 * @param s: The first string
 * @param t: The second string
 * @return: true or false
 */
const anagram = function (s, t) {
  if (s.length !== t.length) {
    return false;
  }
  let map = {};
  for (let i = 0; i < s.length; i++) {
    if (map[s[i]] === undefined) {
      map[s[i]] = 1;
    } else {
      map[s[i]]++;
    }
  }
  for (let i = 0; i < t.length; i++) {
    if (!map[t[i]]) {
      return false;
    }
    map[t[i]]--;
  }
  return true;
};
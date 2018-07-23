/**
 * 注意除去空格的部分使用了 filter 函数。比如：'ds   dhd'  ===> 'dhd ds'
 * 
 * @param {string} str
 * @returns {string}
 */
var reverseWords = function(str) {
  return str.split(' ').filter(s => s).reverse().join(' ');
};
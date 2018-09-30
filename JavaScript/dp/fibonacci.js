/**
 * Fibonacci 數列定義：`0 1 1 2 3 5 8 13 ...`，即從第三個數起，第 n 個數的值為前兩個數的和。寫一段程序求第 n 個數的值。
 * 遞推公式：F(n) = F(n - 1) + F(n - 2)
 */
const fibonacci = function(n) {
  if (n <= 1) {
    return n;
  }

  let arr = [];
  arr[0] = 0;
  arr[1] = 1;
  
  for (let i = 2; i <= n; i++) {
    arr[i] = arr[i - 1] + arr[i - 2];
  }
  return arr[n];
}
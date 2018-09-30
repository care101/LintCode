/**
 * 給定一個非負數組，以及一個整數目標值 target。判斷數組中是否存在一堆數字加起來等於 target 的情況。
 * 
 * 1. 設計一個二維數組 dp，行(row)代表 arr 的每一位數，列(col)代表 0-target 的值。
 * 2. 初始化該二維數組 dp：
 *  - 第一列全為 true。代表當 target === 0 時，肯定可以拼湊出 target，那就是什麼都不選。
 *  - 第一行全為 false。代表當 i === 0 時(已遍歷完畢)，依然不能拼湊出 target。但是當 target === arr[i] 的這一位應該是 true。
 * 3. 二維數組中的每一位都有兩種選擇，一種是不選自己 dp[i][j]，另一種是選擇自己。
 *  - 當不選自己時，此時的最優解為：dp[i][j] = dp[i - 1][j];
 *  - 當選擇自己時，此時的最優解為：dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
 * 
 * (PS: 不懂的話可以看 Note/dp/dp2.md)
 */
const specificSum = function(arr, target) {
  if (arr === null || arr.length === 0) {
    return false;
  }

  // 創建二維數組
  let dp = new Array();
  for (let i = 0; i < arr.length; i++) {
    dp[i] = new Array();
    for (let j = 0; j < target + 1; j++) {
      dp[i][j] = false;
    }
  }

  for (let i = 0; i < arr.length; i++) {
    dp[i][0] = true;
  }
  for (let i = 0; i < target + 1; i++) {
    dp[0][i] = false;
  }
  dp[0][arr[3]] = true;

  for (let i = 1; i < arr.length; i++) {
    for (let j = 1; j < target + 1; j++) {
      if (arr[i] > j) {
        dp[i][j] = dp[i - 1][j];
      } else {
        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
      }
    }
  }
  return dp[arr.length - 1][target];
}
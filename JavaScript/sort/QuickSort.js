/**
 * 平均时间复杂度：O(nlongn)，最坏情况：已经排好序的数组。
 * 
 * 过程：找到一个基准点，将小于该基准点的数放到基准点左边，大于基准点的数放到基准点右边。再对左右两边数组递归找基准点并比较的过程。
 * @param {arr} arr 
 */
function quickSort(arr) {
  if (arr.length < 2) {
    return arr;
  }
  return quick(arr, 0, arr.length - 1);
}

function quick(arr, left, right) {
  let index = partition(arr, left, right);
  if (left < index - 1) {
    quick(arr, left, index - 1);
  }
  if (index < right) {
    quick(arr, index, right);
  }
  return arr;
}

function partition(arr, left, right) {
  let pivot = arr[Math.floor((right + left) / 2)],
          i = left,
          j = right;
  while(i <= j) {
    // 使 i 指向第一个(从左至右)大于 pivot 的数
    while(arr[i] < pivot) {
      i++;
    }
    // 使 j 指向第一个(从右至左)小于 pivot 的数
    while(arr[j] > pivot) {
      j--;
    }
    if (i <= j) {
      swap(arr, i, j);
      i++;
      j--;
    }
  }
  return i;
}

function swap(arr, start, end) {
  let temp = arr[start];
  arr[start] = arr[end];
  arr[end] = temp;
}
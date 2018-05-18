# BinarySearch总结

## 模版

``` java
while (start + 1 < end) {
    int mid = start + (end - start) / 2;
    if (...) {
        ...
    } else {
        ...
    }
}

if (start停留的位置是否满足要求) {
    ...
}
if (end停留的位置是否满足要求) {
    ...
}
```

## 时间复杂度

O(logN)

## 注意点

1. 二分法针对有序数组，或者是部分有序的数组，比如说先升后降或先降后升的数组。

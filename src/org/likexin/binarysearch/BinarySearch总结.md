# BinarySearch总结

## 模版
```
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

## 注意点
1. 二分法针对有序数组

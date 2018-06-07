package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/smallest-rectangle-enclosing-black-pixels/
 *
 * @author Shingo Lee
 */
public class MinArea {

  /**
   * 主要利用题中说的所有的黑色像素都是联通的，那么上下左右边界都可以通过二分法来找到。
   * 比如说找上边界，即确定最上边元素的横坐标。以0和x为start和end找，如果遇到有一行没有一个1，那么说明这行之上都不可能再有1了(因为1是联通的),所以start就该往下走继续找。这样就确定了start与end如何走。
   *
   * @param image 由0和1组成的二维数组
   * @param x     目标黑像素横坐标
   * @param y     目标黑像素素纵坐标
   * @return 与目标黑像素相连的矩形面积
   */
  public int minArea(char[][] image, int x, int y) {
    if (image == null || image.length == 0 || image[0].length == 0) {
      return 0;
    }

    int lenRow = image.length;
    int lenCol = image[0].length;

    int left = findLeft(image, 0, y);
    int right = findRight(image, y, lenCol - 1);
    int top = findTop(image, 0, x);
    int bottom = findBottom(image, x, lenRow - 1);

    return (right - left + 1) * (bottom - top + 1);
  }

  private int findLeft(char[][] image, int start, int end) {
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (isEmptyColumn(image, mid)) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (isEmptyColumn(image, start)) {
      return end;
    }
    return start;
  }

  private int findRight(char[][] image, int start, int end) {
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (isEmptyColumn(image, mid)) {
        end = mid;
      } else {
        start = mid;
      }
    }
    if (isEmptyColumn(image, end)) {
      return start;
    }
    return end;
  }

  private int findTop(char[][] image, int start, int end) {
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (isEmptyRow(image, mid)) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (isEmptyRow(image, start)) {
      return end;
    }
    return start;
  }

  private int findBottom(char[][] image, int start, int end) {
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (isEmptyRow(image, mid)) {
        end = mid;
      } else {
        start = mid;
      }
    }
    if (isEmptyRow(image, end)) {
      return start;
    }
    return end;
  }

  private boolean isEmptyColumn(char[][] image, int col) {
    for (int i = 0; i < image.length; i++) {
      if (image[i][col] == '1') {
        return false;
      }
    }
    return true;
  }

  private boolean isEmptyRow(char[][] image, int row) {
    for (int i = 0; i < image[0].length; i++) {
      if (image[row][i] == '1') {
        return false;
      }
    }
    return true;
  }

}

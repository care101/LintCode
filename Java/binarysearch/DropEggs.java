package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/drop-eggs/
 *
 * @author Shingo Lee
 */
public class DropEggs {

  public static void main(String[] args) {
    System.out.println(new DropEggs().dropEggs(100));
  }

  /**
   * 参考：http://www.cnblogs.com/grandyang/p/4762756.html
   *
   * @param n n层楼
   * @return 鸡蛋扔下去不会碎的最小楼层
   */
  public int dropEggs(int n) {
    Long res = 0L;
    for (int i = 0; ; i++) {
      res += i;
      if (res >= n) {
        return i;
      }
    }
  }

}

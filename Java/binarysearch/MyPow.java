package org.likexin.binarysearch;

public class MyPow {

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (x == 0) {
      return 0;
    }
    if (x == 1) {
      return n;
    }

    if (n % 2 == 0) {
      double temp = myPow(x, n / 2);
      return temp * temp;
    }
    if (n > 0) {
      double temp = myPow(x, n / 2);
      return temp * temp * x;
    } else {
      double temp = myPow(x, n / 2);
      return temp * temp / x;
    }
  }

}

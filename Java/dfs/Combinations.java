package org.likexin.dfs;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    dfs(results, list, n, k, 1);
    return results;
  }

  private void dfs(List<List<Integer>> results, List<Integer> list, int n, int k, int start) {
    if (list.size() == k) {
      results.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i <= n; i++) {
      list.add(i);
      dfs(results, list, n, k, i + 1);
      list.remove(list.size() - 1);
    }
  }

}

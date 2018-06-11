package org.likexin.bfs;

import java.util.*;

public class TopSorting {

  public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    ArrayList<DirectedGraphNode> result = new ArrayList<>();
    Map<DirectedGraphNode, Integer> map = new HashMap<>();

    // 统计入度
    for (DirectedGraphNode node : graph) {
      for (DirectedGraphNode neighbor : node.neighbors) {
        if (map.containsKey(neighbor)) {
          map.put(neighbor, map.get(neighbor) + 1);
        } else {
          map.put(neighbor, 1);
        }
      }
    }

    Queue<DirectedGraphNode> queue = new LinkedList<>();

    // 将所有入度为 0 的点放入队列
    for (DirectedGraphNode node : graph) {
      if (!map.containsKey(node)) {
        queue.offer(node);
        result.add(node);
      }
    }

    // 将队列中的点一个一个弹出，每弹出一个点就访问它的相邻点，并把这些点的入度减 1。
    while (!queue.isEmpty()) {
      DirectedGraphNode node = queue.poll();
      for (DirectedGraphNode n : node.neighbors) {
        map.put(n, map.get(n) - 1);
        if (map.get(n) == 0) {
          result.add(n);
          queue.offer(n);
        }
      }
    }
    return result;
  }

}

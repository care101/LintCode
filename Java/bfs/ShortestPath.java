package org.likexin.bfs;

import java.util.*;

public class ShortestPath {

  class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
  }

  /**
   * 双向宽搜
   *
   * @param graph: a list of Undirected graph node
   * @param A: nodeA
   * @param B: nodeB
   * @return:  the length of the shortest path
   */
  public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
    if (graph == null || A == null || B == null) {
      return 0;
    }
    if (A == B) {
      return 1;
    }

    Queue<UndirectedGraphNode> startQueue = new LinkedList<>();
    Queue<UndirectedGraphNode> endQueue = new LinkedList<>();
    startQueue.offer(A);
    endQueue.offer(B);
    Set<UndirectedGraphNode> startSet = new HashSet<>();
    Set<UndirectedGraphNode> endSet = new HashSet<>();
    startSet.add(A);
    endSet.add(B);

    int step = 0;

    while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
      int startSize = startQueue.size();
      int endSize = endQueue.size();
      step++;
      for (int i = 0; i < startSize; i++) {
        UndirectedGraphNode node = startQueue.poll();
        for (UndirectedGraphNode neighbor : node.neighbors) {
          if (startSet.contains(neighbor)) {
            continue;
          } else if (endSet.contains(neighbor)) {
            return step;
          } else {
            startQueue.offer(neighbor);
            startSet.add(neighbor);
          }
        }
      }
      step++;
      for (int i = 0; i < endSize; i++) {
        UndirectedGraphNode node = endQueue.poll();
        for (UndirectedGraphNode neighbor : node.neighbors) {
          if (endSet.contains(neighbor)) {
            continue;
          } else if (startSet.contains(neighbor)) {
            return step;
          } else {
            endQueue.offer(neighbor);
            endSet.add(neighbor);
          }
        }
      }
    }
    return -1;
  }
}

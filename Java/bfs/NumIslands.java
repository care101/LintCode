package org.likexin.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {

  /**
   * 为什么不推荐 DFS：因为最坏情况全是1，那么递归的深度是nm的，直接stack overflow了。
   *
   * PS：能用BFS就不要用DFS
   *
   * TODO
   *  1.重复入栈
   *  2.没有coordinate类的话如何实现，有它的好处是什么
   *  3.magic number的由来
   */
  public int numIslands(boolean[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int row = grid.length;
    int col = grid[0].length;
    int count = 0;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j]) {
          markByBFS(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private void markByBFS(boolean[][] grid, int x, int y) {
    // magic number
    int[] directionX = {0, 0, -1, 1};
    int[] directionY = {-1, 1, 0, 0};

    Queue<Coordinate> queue = new LinkedList<>();
    Coordinate coordinate = new Coordinate(x, y);
    queue.offer(coordinate);

    while (!queue.isEmpty()) {
      Coordinate coor = queue.poll();
      grid[coor.x][coor.y] = false;

      for (int i = 0; i < 4; i++) {
        Coordinate adj = new Coordinate(coor.x + directionX[i], coor.y + directionY[i]);

        if (!inBound(adj, grid)) {
          continue;
        }

        if (grid[adj.x][adj.y]) {
          grid[adj.x][adj.y] = false;
          queue.offer(adj);
        }
      }
    }
  }

  private boolean inBound(Coordinate coor, boolean[][] grid) {
    return (coor.x >= 0 && coor.x < grid.length) && (coor.y >= 0 && coor.y < grid[0].length);
  }

}

class Coordinate {
  int x;
  int y;
  Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

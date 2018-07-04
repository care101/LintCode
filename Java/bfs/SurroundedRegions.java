package org.likexin.bfs;

import java.util.*;

public class SurroundedRegions {

  class Coordinate {
    int x;
    int y;
    Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  /**
   * 先找到连通域，如果发现连通域有边界点，则标记 F；否则标记 X。最后再将所有 F 标记为 O。
   *
   * @param board: board a 2D board containing 'X' and 'O'
   * @return: nothing
   */
  public void surroundedRegions(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') {
          markByBFS(board, i, j);
        }
      }
    }
    markO(board);
  }

  private void markByBFS(char[][] board, int x, int y) {
    int[] dirX = {1, -1, 0, 0};
    int[] dirY = {0, 0, 1, -1};

    Coordinate coordinate = new Coordinate(x, y);
    Queue<Coordinate> queue = new LinkedList<>();
    Set<Coordinate> set = new HashSet<>();
    queue.offer(coordinate);
    set.add(coordinate);

    board[coordinate.x][coordinate.y] = 'T';

    while (!queue.isEmpty()) {
      Coordinate coor = queue.poll();
      for (int i = 0; i < 4; i++) {
        int newX = coor.x + dirX[i];
        int newY = coor.y + dirY[i];
        if (inBound(board, newX, newY)) {
          Coordinate adj = new Coordinate(newX, newY);
          if (board[newX][newY] == 'O') {
            set.add(adj);
            queue.offer(adj);
            board[newX][newY] = 'T';
          }
        }
      }
    }
    // 如果连通域没有边界点
    if (!checkSet(set, board)) {
      markX(board, set);
    } else {
      markF(board, set);
    }
  }

  private boolean checkSet(Set<Coordinate> set, char[][] board) {
    Iterator<Coordinate> ii = set.iterator();
    while (ii.hasNext()) {
      Coordinate c = ii.next();
      if (isBorder(board, c.x, c.y)) {
        return true;
      }
    }
    return false;
  }

  private void markF(char[][] board, Set<Coordinate> set) {
    Iterator<Coordinate> ii = set.iterator();
    while (ii.hasNext()) {
      Coordinate c = ii.next();
      board[c.x][c.y] = 'O';
    }
  }

  private void markX(char[][] board, Set<Coordinate> set) {
    Iterator<Coordinate> ii = set.iterator();
    while (ii.hasNext()) {
      Coordinate c = ii.next();
      board[c.x][c.y] = 'X';
    }
  }

  private void markO(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'F') {
          board[i][j] == 'O';
        }
      }
    }
  }

  private boolean inBound(char[][] board, int i, int j) {
    return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
  }

  private boolean isBorder(char[][] board, int i, int j) {
    return i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1;
  }

  public void print(char[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println(" ");
    }
    System.out.println(" ");
  }

  public static void main(String[] args) {
    char[][] board = {
            {'X', 'O', 'O', 'O', 'O'},
            {'X', 'O', 'X', 'O', 'O'},
            {'X', 'X', 'O', 'X', 'X'},
            {'X', 'X', 'O', 'O', 'O'},
    };
    new SurroundedRegions().surroundedRegions(board);
    new SurroundedRegions().print(board);
  }
}

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
   * TODO: 70%
   * @param board
   */
  public void surroundedRegions(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    for (int i = 1; i < board.length - 1; i++) {
      for (int j = 1; j < board[0].length - 1; j++) {
        if (board[i][j] == 'O') {
          markByBFS(board, i, j);
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'F') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void markByBFS(char[][] board, int x, int y) {
    int[] dirX = {1, -1, 0, 0};
    int[] dirY = {0, 0, 1, -1};

    Coordinate coordinate = new Coordinate(x, y);
    Queue<Coordinate> queue = new LinkedList<>();
    queue.offer(coordinate);

    while (!queue.isEmpty()) {
      int count = 0;
      boolean flag = false;
      Coordinate coor = queue.poll();
      board[coor.x][coor.y] = 'F';

      for (int i = 0; i < 4; i++) {
        int newX = coor.x + dirX[i];
        int newY = coor.y + dirY[i];
        if (inBound(board, newX, newY)) {
          Coordinate adj = new Coordinate(newX, newY);
          if (board[adj.x][adj.y] == 'O') {
            if (isBorder(board, adj.x, adj.y)) {
              flag = true;
            } else {
              queue.offer(adj);
            }
          }
          if (board[adj.x][adj.y] == 'F') {
            count++;
          }
        }
      }
      if (!flag && count < 2) {
        board[coor.x][coor.y] = 'X';
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
            {'X', 'X', 'X', 'O', 'O'},
            {'X', 'X', 'O', 'X', 'X'},
            {'X', 'X', 'O', 'O', 'O'},
    };
    new SurroundedRegions().surroundedRegions(board);
    new SurroundedRegions().print(board);
  }
}

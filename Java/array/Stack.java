package org.likexin.array;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {

  Queue<Integer> q1 = new LinkedList<>();
  Queue<Integer> q2 = new LinkedList<>();

  public void swapQueue() {
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;
  }

  public void push(int x) {
    q1.offer(x);
  }

  /*
   * @return: nothing
   */
  public void pop() {
    while (q1.size() != 1) {
      q2.offer(q1.poll());
    }
    q1.poll();
    swapQueue();
  }

  /*
   * @return: An integer
   */
  public int top() {
    while (q1.size() != 1) {
      q2.offer(q1.poll());
    }
    int item = q1.poll();
    swapQueue();
    q1.offer(item);
    return item;
  }

  /*
   * @return: True if the stack is empty
   */
  public boolean isEmpty() {
    return q1.isEmpty();
  }

}

package org.likexin.bfs;

import java.util.*;

public class WordLadder {

  public int ladderLength(String start, String end, Set<String> dict) {
    if (dict == null) {
      return 0;
    }
    if (start.equals(end)) {
      return 1;
    }

    dict.add(start);
    dict.add(end);

    Queue<String> queue = new LinkedList<>();
    Set<String> hash = new HashSet<>();
    queue.offer(start);
    hash.add(start);

    int length = 0;
    while (!queue.isEmpty()) {
      length++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        for (String nextWord : getNextWord(word, dict)) {
          if (hash.contains(nextWord)) {
            continue;
          }

          if (nextWord.equals(end)) {
            return length;
          }

          queue.offer(nextWord);
          hash.add(nextWord);
        }
      }
    }
    return 0;
  }

  private List<String> getNextWord(String word, Set<String> dict) {
    List<String> list = new ArrayList<>();
    for (char c = 'a'; c < 'z'; c++) {
      for (int i = 0; i < word.length(); i++) {
        char[] chars = word.toCharArray();
        chars[i] = c;
        String temp = new String(chars);

        if (dict.contains(temp)) {
          list.add(temp);
        }
      }
    }
    return list;
  }
}

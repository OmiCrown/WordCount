package org.kudryavtsev;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


class WordsMap {

    Map<String, Integer> getWordsMap(List<String> wordsList) {
        Map<String, Integer> map = new TreeMap<>();

        for (String word : wordsList) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            }
            else {
                int amount = map.get(word);
                map.put(word, amount + 1);
            }
        }
        return map;
    }
}

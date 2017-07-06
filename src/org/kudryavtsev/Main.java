package org.kudryavtsev;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    if (e1.getKey().equals(e2.getKey())) {
                        return res;
                    } else {
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    public static void main(String[] args) {
        if (args.length < 2 ){
            System.out.println("Run application with correct parameters!");
        }

        String fileName = args[0];
        int count  = Integer.valueOf(args[1]);
        String wordsFile = "";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                wordsFile = wordsFile + line.toLowerCase() + " ";
            }
            wordsFile = wordsFile.replaceAll("[.,]", " ");
            wordsFile = wordsFile.replaceAll("( )+", " ");

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> wordsList = new ArrayList<>(Arrays.asList(wordsFile.split(" ")));
        SortedSet<Map.Entry<String, Integer>> entries = entriesSortedByValues(getWordsMap(wordsList));

        Object[] array = entries.toArray();

        for(int i = array.length - 1; i > array.length - 1 - count; i--){
            System.out.println(array[i]);
        }

    }

    private static Map<String, Integer> getWordsMap(List<String> wordsList) {
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

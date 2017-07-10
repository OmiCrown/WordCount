package org.kudryavtsev;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    if (e1.getKey().equals(e2.getKey())) {
                        return res;
                    } else {
                        return res != 0 ? res : -1;
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
        String wordsString = "";
        WordsMap wordsMap = new WordsMap();

//        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                wordsString = wordsString + line.toLowerCase() + " ";
//            }
//            wordsString = wordsString.replaceAll("[.,]( )+", " ");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Stream<String> finalStream;
//        List<String> list = new ArrayList<>();

        try (Stream<String> fileLinesAsStream = Files.lines(Paths.get(fileName))) {
            wordsString = fileLinesAsStream
                    .map(x -> x.toLowerCase().replaceAll("[.,]", "").trim() + " ")
//                    .map(x -> x.replaceAll("^ +", "").replaceAll("\\s+$", " "))
//                    .map(x -> x.replaceAll("\\s+$", " "))
                    .collect(Collectors.joining(""))
//                    .collect(Collectors.toList())
//                    .collect(reducing("", Account::getNumber, String::concat))
            ;
//            finalStream.forEach(System.out::println);


//            List<Person> list = Arrays.asList(
//                    new Person("John", "Smith"),
//                    new Person("Anna", "Martinez"),
//                    new Person("Paul", "Watson ")
//            );
//
//            String joinedFirstNames = list.stream()
//                    .map(Person::getFirstName)
//                    .collect(Collectors.joining(", ")); // "John, Anna, Paul"


//List<String> accounts = new ArrayList<>(;)
//            String meganumber = accounts.stream()
//                    .collect(reducing("", String::concat));

//            finalStream = fileLinesAsStream
//                    .map(x -> x)
//                    .collect()

//                    myFinalList = myListToParse.stream()
//                            .filter(elt -> elt != null)
//                            .map(elt -> doSomething(elt))
//                            .collect(Collectors.toList());

        }catch (IOException e) {
            e.printStackTrace();
        }



//        accountList.stream()
//                .filter(a -> a.getSum() > 10_000_000)
//                .forEach(a -> a.setLocked(true));

//        Map<String, Long> numberToBalanceMap = accounts.stream()
//                .collect(Collectors.toMap(Account::getNumber, Account::getBalance));
        System.out.println(wordsString);

        List<String> wordsList = new ArrayList<>(Arrays.asList(wordsString.replaceAll("[ ]+", " ").split(" ")));
        SortedSet<Map.Entry<String, Integer>> entries = entriesSortedByValues(wordsMap.getWordsMap(wordsList));

        Object[] array = entries.toArray();

        for(int i = array.length - 1; i > array.length - 1 - count; i--){
            System.out.println(array[i]);
        }
//        System.out.println(wordsFileJ8);

    }

}

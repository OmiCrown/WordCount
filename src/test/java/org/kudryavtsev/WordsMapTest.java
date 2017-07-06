package org.kudryavtsev;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Omicrown on 06.07.2017.
 */
public class WordsMapTest {
    private WordsMap wordsMap;

    @Before
    public void setUp() throws Exception {
        wordsMap = new WordsMap();
    }


    @Test
    public void shouldWordsMapReturn2lines() throws Exception {

        List<String> wordsList = new ArrayList<>(Arrays.asList("mary", "john", "mary"));
        Map map = new TreeMap();
        map.put("john", 1);
        map.put("mary", 2);
        assertEquals(wordsMap.getWordsMap(wordsList), map);
    }

}
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {


    @Test
    void everyStatementTest() {
        // list.size = 0 for first exception
        List<String> EmptyList = Collections.emptyList();

        IllegalArgumentException ex;
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(EmptyList));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

        // list.size = 3 for second exception
       List<String> listOfThree = new ArrayList<String>();
       listOfThree.add("0");
       listOfThree.add("#");
       listOfThree.add("0");
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(listOfThree));
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));

        // valid input of list for all another statements
        List<String> trueList = new ArrayList<String>();
        trueList.add("1");
        trueList.add("#");
        trueList.add("2");
        trueList.add("0");
        trueList.add("3");
        trueList.add("#");
        trueList.add("1");
        trueList.add("#");
        trueList.add("#");

        // result list to compare if everything is okay with function, here exceptions won't be executed
        List<String> inputList = new ArrayList<String>();
        inputList.add("0");
        inputList.add("#");
        inputList.add("0");
        inputList.add("0");
        inputList.add("0");
        inputList.add("#");
        inputList.add("0");
        inputList.add("#");
        inputList.add("#");

        assertEquals(trueList, SILab2.function(inputList));
    }

    @Test
    void testEveryPath(){
        // 1 -> 2 -> 34
        List<String> EmptyList = Collections.emptyList();
        IllegalArgumentException ex;
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(EmptyList));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));
        // 1 -> 3 -> 4,5,6 -> 7 -> 34
        List<String> listOfThree = new ArrayList<String>();
        listOfThree.add("0");
        listOfThree.add("#");
        listOfThree.add("0");
        listOfThree.add("0");
        listOfThree.add("0");
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(listOfThree));
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));

        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 32 -> 33 -> 34 - can't happen
        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 28 -> 29 -> 30,31 -> 32 -> 33 -> 34
        // valid input of list for all another statements
        List<String> trueList = new ArrayList<String>();
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");

        // result list to compare if everything is okay with function, here exceptions won't be executed
        List<String> inputList = new ArrayList<String>();
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        assertEquals(trueList, SILab2.function(inputList));

        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16,17,18,19
        // valid input of list for all another statements
        trueList = new ArrayList<String>();
        trueList.add("1");
        trueList.add("#");
        trueList.add("2");
        trueList.add("0");
        trueList.add("3");
        trueList.add("#");
        trueList.add("1");
        trueList.add("#");
        trueList.add("#");

        // result list to compare if everything is okay with function, here exceptions won't be executed
        inputList = new ArrayList<String>();
        inputList.add("0");
        inputList.add("#");
        inputList.add("0");
        inputList.add("0");
        inputList.add("0");
        inputList.add("#");
        inputList.add("0");
        inputList.add("#");
        inputList.add("#");

        assertEquals(trueList, SILab2.function(inputList));
        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 14 -> 16,17,18,19 -> 20 - same as test above because we
        // have list of 0#0 00# 0## and if we proceed for all values in that list we will pass all paths.

        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 20 -> 21 -> 22 -> 23
        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 20 -> 21 -> 23 -> 24 -> 25 -> 26
        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 20 -> 21 -> 23 -> 24 -> 26 -> 27 -> 28 -> 29 -> 30,31 -> 32 -> 10.3 -> 10.2

    }

}
package src.test;

import src.gb.arraylist.GBArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GBArrayListTest {

    @Test
    void getTest(){
        GBArrayList<String> strings = new GBArrayList<>();
        strings.add("1");
        assertEquals("1", strings.get(0));

    }
    @Test
    void getNegativeTest(){
        GBArrayList<String> strings = new GBArrayList<>();
        strings.add("1");
        assertNotEquals("2", strings.get(0));

    }
}
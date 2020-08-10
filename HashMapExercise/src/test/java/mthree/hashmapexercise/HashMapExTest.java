/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.hashmapexercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author utkua
 */
public class HashMapExTest {
    
    HashMapEx<String,String> hashy = new HashMapEx<String,String>();
    
    public HashMapExTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        hashy = new HashMapEx();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of putEntry and getEntry methods, of class HashMapEx.
     */
    @Test
    public void testPutGetEntry() {
        String sj = "sj";
        String js = "js";
        hashy.putEntry(sj, js);
        hashy.putEntry("xx", "xs");
        hashy.putEntry("xe", "xz");
        hashy.putEntry("mm", "ml");
        hashy.putEntry("md", "mo");
        hashy.putEntry("ms", "mr");
        hashy.putEntry("mq", "mnd");
        hashy.putEntry("mp", "ssc");
        String got = hashy.getEntry(sj).getValue();
        assertEquals(got, js);
    }

    /**
     * Test of getSize method, of class HashMapEx.
     */
    @Test
    public void testGetSize() {
        int size = hashy.getSize();
        assertEquals(0, size);
        
        hashy.putEntry("js", "ps");
        hashy.putEntry("jss", "ps");
        hashy.putEntry("jsss", "ps");
        
        size = hashy.getSize();
        assertEquals(3, size);
    }

    /**
     * Test of isEmpty method, of class HashMapEx.
     */
    @Test
    public void testIsEmpty() {
        boolean isEmpty = hashy.isEmpty();
        assertTrue(isEmpty);
        
        hashy.putEntry("js", "ps");
        isEmpty = hashy.isEmpty();
        assertFalse(isEmpty);
    }

    /**
     * Test of removeEntry method, of class HashMapEx.
     */
    @Test
    public void testRemoveEntry() {
        hashy.putEntry("js", "ps");
        hashy.putEntry("jss", "ps");
        hashy.putEntry("jsss", "ps");
        
        assertTrue(hashy.containsKey("jss"));
        
        hashy.removeEntry("jss");
        assertFalse(hashy.containsKey("jss"));
    }

    /**
     * Test of containsKey method, of class HashMapEx.
     */
    @Test
    public void testContainsKey() {
        hashy.putEntry("pt", "jt");
        boolean shouldBeTrue = hashy.containsKey("pt");
        assertTrue(shouldBeTrue);
        boolean shouldBeFalse = hashy.containsKey("tp");
        assertFalse(shouldBeFalse);
    }

    /**
     * Test of containsValue method, of class HashMapEx.
     */
    @Test
    public void testContainsValue() {
        hashy.putEntry("pt", "jt");
        boolean shouldBeTrue = hashy.containsValue("jt");
        assertTrue(shouldBeTrue);
        boolean shouldBeFalse = hashy.containsValue("tp");
        assertFalse(shouldBeFalse);
    }
    
}

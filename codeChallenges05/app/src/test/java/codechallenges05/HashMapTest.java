package codechallenges05;

import hashMap.HashMap;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

    private HashMap<String, Integer> hashMap;



    @Test
    public void testSetAndGet() {
        hashMap = new HashMap<>(16);
        hashMap.set("key1", 42);
        assertEquals(Integer.valueOf(42), hashMap.get("key1"));
    }

    @Test
    public void testNullForNonExistentKey() {
        hashMap = new HashMap<>(16);
        assertNull(hashMap.get("nonExistentKey"));
    }

    @Test
    public void testKeys() {
        hashMap = new HashMap<>(16);
        hashMap.set("key1", 1);
        hashMap.set("key2", 2);
        hashMap.set("key3", 3);
        assertEquals(3, hashMap.keys().size());
        assertTrue(hashMap.keys().contains("key1"));
        assertTrue(hashMap.keys().contains("key2"));
        assertTrue(hashMap.keys().contains("key3"));
    }

    @Test
    public void testCollisionHandling() {
        hashMap = new HashMap<>(16);
        // Force a collision by setting two keys with the same hash
        hashMap.set("key1", 1);
        hashMap.set("key17", 17); // This will collide with key1

        assertEquals(Integer.valueOf(1), hashMap.get("key1"));
        assertEquals(Integer.valueOf(17), hashMap.get("key17"));
    }

    @Test
    public void testHashInRange() {
        hashMap = new HashMap<>(16);
        // Test that the hash function returns values within the valid range
        for (int i = 0; i < 100; i++) {
            int hash = hashMap.hash("key" + i);
            assertTrue(hash >= 0 && hash < 16); // Assuming size is 16
        }
    }

    @Test
    public void testLeftJoin() {
        HashMap<String, String> synonyms = new HashMap<>(16);
        synonyms.set("happy", "joyful");
        synonyms.set("sad", "unhappy");
        synonyms.set("big", "large");

        HashMap<String, String> antonyms = new HashMap<>(16);
        antonyms.set("happy", "sad");
        antonyms.set("big", "small");
        antonyms.set("fast", "slow");

        List<List<String>> expectedResult = Arrays.asList(
                Arrays.asList("happy", "joyful", "sad"),
                Arrays.asList("sad", "unhappy", null),
                Arrays.asList("big", "large", "small"));

        List<List<String>> result = HashMap.leftJoin(synonyms, antonyms);

        assertEquals(expectedResult.size(), result.size(), "Result size should match expected size");

        for (List<String> expectedRow : expectedResult) {
            assertTrue(result.contains(expectedRow), "Result should contain expected row: " + expectedRow);
        }
    }
}

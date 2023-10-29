package codechallenges05;

import hashMap.HashMap;
import org.junit.jupiter.api.Test;
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
}

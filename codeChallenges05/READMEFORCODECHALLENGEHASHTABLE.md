# Challenge HashMap
## Problem Domain
In this problem domain, we are tasked with creating classes and methods for handling HashMap data structure.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc30.jpg "/>
### - Initial HashMap  Method:
**1- set**
- Arguments: key, value
- Returns: nothing
This method should hash the key, and set the key and value pair in the table, handling collisions as needed.
Should a given key already exist, replace its value from the value argument given to this method.
  
**2-get**
- Arguments: key
- Returns: Value associated with that key in the table

**3-has**
- Arguments: key
- Returns: Boolean, indicating if the key exists in the table already.

**4-keys**

- Returns: Collection of keys

**5-hash**

- Arguments: key
- Returns: Index in the collection for that key

## - Algorithms:

1. **Initialization**: To create a HashMap, you specify its initial capacity (the number of buckets) and optionally a load factor (a threshold for resizing). In Java, you can use the `HashMap` class, and it initializes itself with some default values if you don't specify them.

2. **Hashing**: When you want to store a key-value pair in the HashMap, the key is first hashed to determine the index (bucket) where the pair will be stored. This is done to enable fast retrieval of values later. Java's `hashCode` method is used to generate a hash code for the key.

3. **Collision Handling**: In the hashing process, it's possible for different keys to produce the same hash code (a collision). HashMaps handle this situation by storing multiple key-value pairs in the same bucket. A linked list or a more advanced data structure is used to manage these collisions.

4. **Storing Key-Value Pairs**: The key-value pair is then placed in the appropriate bucket. If there's already a pair with the same key in that bucket, it may replace the existing value (if you're using `put`), or it may be handled in a way specified by the specific implementation (e.g., in Java, it updates the value).

5. **Retrieving Values**: When you want to retrieve a value by its key, the key is hashed to find the corresponding bucket. Then, a search is conducted within that bucket's linked list (or whatever data structure is used) to find the specific key-value pair you're looking for.

6. **Resizing**: As the number of key-value pairs in the HashMap grows, the load factor comes into play. If the load factor is exceeded, the HashMap may automatically resize itself to maintain efficiency. This process involves creating a new, larger array of buckets, rehashing all the existing key-value pairs into the new buckets, and discarding the old array.

7. **Removing Key-Value Pairs**: You can remove key-value pairs from the HashMap by specifying the key you want to remove. This will involve a similar process to retrieving values, but instead of returning the value, it removes the pair.

8. **Iterating Through Keys or Entries**: HashMaps provide methods for iterating through all keys, values, or key-value pairs stored in the map. In Java, you can use methods like `keySet()`, `values()`, or `entrySet()` to access this data.

9. **Efficiency**: The primary advantage of a HashMap is its efficiency in key-value retrieval. It provides constant-time (O(1)) access in the average case. However, in the worst case (due to collisions and resizing), it can degrade to O(n), but this is rare if the HashMap is properly configured.

10. **Choosing the Right Key Type**: It's essential to choose the appropriate key type. In Java, keys must have well-defined `equals()` and `hashCode()` methods to work correctly in a HashMap.


## Solution

public class HashMap<K, V> {
ArrayList<LinkedList<HashMapPair<K, V>>> bucketArrayList;
int size;

    public HashMap(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("HashMap size must be 1 or greater!");
        }

        this.size = size;
        this.bucketArrayList = new ArrayList<>(size);

        // Initialize buckets
        for (int i = 0; i < this.size; i++) {
            bucketArrayList.add(i, new LinkedList<>());
        }
    }


    public void set(K key, V value) {
        int index = hash(key);
        LinkedList<HashMapPair<K, V>> bucket = bucketArrayList.get(index);

        // Check if the key already exists in the bucket, and if so, update the value
        for (HashMapPair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);
                return;
            }
        }


        bucket.add(new HashMapPair<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<HashMapPair<K, V>> bucket = bucketArrayList.get(index);


        for (HashMapPair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }

        return null;
    }

    public boolean contains(K key) {
        int index = hash(key);
        LinkedList<HashMapPair<K, V>> bucket = bucketArrayList.get(index);

        // Check if the key exists in the bucket
        for (HashMapPair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    public List<K> keys() {
        List<K> keyList = new ArrayList<>();

        // Collect all keys from the buckets
        for (LinkedList<HashMapPair<K, V>> bucket : bucketArrayList) {
            for (HashMapPair<K, V> pair : bucket) {
                keyList.add(pair.getKey());
            }
        }

        return keyList;
    }


    public int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }
}

package hashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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


    public static List<List<String>> leftJoin(HashMap<String, String> synonyms, HashMap<String, String> antonyms) {
        List<List<String>> results = new ArrayList<>();

        for (String key : synonyms.keys()) {
            List<String> row = new ArrayList<>();
            row.add(key);
            String synonym = synonyms.get(key);
            if (synonym != null) {
                row.add(synonym);
            } else {row.add(null);}
            String antonym = antonyms.get(key);
            if (antonym != null) {
                row.add(antonym);
            } else {row.add(null);
            }
            results.add(row);
        }

        return results;
    }

}



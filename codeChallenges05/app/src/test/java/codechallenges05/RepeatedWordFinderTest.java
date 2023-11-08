package codechallenges05;

import hashMap.RepeatedWordFinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RepeatedWordFinderTest {
    @Test
    public void testFindFirstRepeatedWord() {

        RepeatedWordFinder repeatedWordFinder=new RepeatedWordFinder();
        // Test cases with repeated words
        assertEquals("a", repeatedWordFinder.findFirstRepeatedWord("Once upon a time, there was a brave princess who..."));
        assertEquals("it", repeatedWordFinder.findFirstRepeatedWord("It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity..."));
        assertEquals("summer", repeatedWordFinder.findFirstRepeatedWord("It was a queer, sultry summer , the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York..."));

        // Test cases with no repeated words
        assertNull(repeatedWordFinder.findFirstRepeatedWord("This is a test sentence with no repeated words."));
        assertNull(repeatedWordFinder.findFirstRepeatedWord("SingleWord"));
        assertNull(repeatedWordFinder.findFirstRepeatedWord(""));
    }
}

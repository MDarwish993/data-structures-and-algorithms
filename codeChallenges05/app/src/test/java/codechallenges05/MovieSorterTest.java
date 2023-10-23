package codechallenges05;

import codeChallenge28.Movie;
import codeChallenge28.MovieSorter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieSorterTest {

    @Test
    void testSortByMostRecentYear() {
        MovieSorter movieSorter = new MovieSorter();
        List<Movie> movies = Arrays.asList(
                new Movie("The Shawshank Redemption", 1994, Arrays.asList("Drama")),
                new Movie("Forrest Gump", 1994, Arrays.asList("Drama", "Romance")),
                new Movie("A Beautiful Mind", 2001, Arrays.asList("Drama", "Biography")),
                new Movie("Avatar", 2009, Arrays.asList("Action", "Adventure", "Science Fiction"))
        );

        List<Movie> sortedMovies = movieSorter.sortByMostRecentYear(movies);

        // Ensure the movies are sorted by most recent year first
        assertEquals(2009, sortedMovies.get(0).getYear());
        assertEquals(2001, sortedMovies.get(1).getYear());
        assertEquals(1994, sortedMovies.get(2).getYear());
        assertEquals(1994, sortedMovies.get(3).getYear());
    }


}

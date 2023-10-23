package codeChallenge28;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieSorter {
    public List<Movie> sortByMostRecentYear(List<Movie> movies) {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getYear).reversed())
                .collect(Collectors.toList());
    }

    public List<Movie> sortAlphabeticallyByTitle(List<Movie> movies) {
        return movies.stream()
                .sorted(Comparator.comparing(this::getSortableTitle))
                .collect(Collectors.toList());
    }

    private String getSortableTitle(Movie movie) {
        String title = movie.getTitle();
        String[] ignoredWords = {"A ", "An ", "The "};

        for (String word : ignoredWords) {
            if (title.startsWith(word)) {
                title = title.substring(word.length());
                break;
            }
        }
        return title;
    }

}

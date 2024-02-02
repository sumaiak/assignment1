package Exercise6;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise6 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "George Orwell", 1949, 328, 4.6));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180, 4.3));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 279, 4.4));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 234, 4.0));
        books.add(new Book("To the Lighthouse", "Virginia Woolf", 1927, 218, 4.2));
        books.add(new Book("One Hundred Years of Solitude", "Gabriel García Márquez", 1967, 417, 4.8));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932, 311, 4.1));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 1178, 4.7));
        books.add(new Book("The Handmaid's Tale", "Margaret Atwood", 1985, 311, 4.4));
        books.add(new Book("No pride", "Jane Austen", 1813, 279, 3.0));
        books.add(new Book("Hurry", "J.D. Salinger", 1951, 234, 3.5));


        //calculating average
        OptionalDouble s = books.stream().mapToDouble(Book::getRating).average();
        System.out.println(s);
        //Filter and display books published after a specific year.

        books.stream().filter(n -> n.getPublicationYear() > 1927).sorted(Comparator.comparingInt(Book::getPublicationYear)).// Sort by publication year

                forEach(System.out::println);
        //sorting books by rating
        List<Book> sortedBooks = books.stream()
                .sorted(Comparator.comparing(Book::getRating))
                .collect(Collectors.toList());
        sortedBooks.forEach(System.out::println);

        System.out.println("book with highest rating is:");

        //Find and display the title of the book with the highest rating.

        books.stream().max(Comparator.comparing(Book::getRating)).ifPresent(System.out::println);
        //Group books by author and calculate the average rating for each author's books.
        Map<String, Double> groupAuthorAndAverage = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.averagingDouble(Book::getRating)));

        groupAuthorAndAverage.forEach((author, average) ->
                System.out.println(author + ", Average Rating: " + average));

        //Calculate the total number of pages for all books (assuming each book has a fixed number of pages).
        int totalPages = books.stream().mapToInt(Book::getPages).sum();
        System.out.println("total pages are: " + totalPages);
        // Use terminal operations like collect, forEach, or reduce to collect and display the results of your Stream operations.

        //Use terminal operations like collect, forEach, or reduce to collect and display the results of your Stream operations.
        int totalPAges = books.stream()
                .mapToInt(Book::getPages)
                .reduce(0, (a, b) -> a + b);


    }
}
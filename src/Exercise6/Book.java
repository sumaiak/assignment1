package Exercise6;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private double rating;

    // Constructor
    public Book(String title, String author, int publicationYear, int pages, double rating) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.rating = rating;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Exercise6.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                ", rating=" + rating +
                '}';
    }
}

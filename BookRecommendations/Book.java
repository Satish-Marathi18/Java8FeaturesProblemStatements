package BookRecommendations;

public class Book {
    String title;
    String author;
    String genre;
    double rating;
    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public double getRating() {
        return rating;
    }
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", genre=" + genre + ", rating=" + rating + "]";
    }

    
}

package BookRecommendations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    public static List<Book> filterBooks(List<Book> books) {
       return books.stream()
        .filter(book -> book.getRating() > 4.0 && "Science Fiction".equals(book.getGenre()))
        .collect(Collectors.toList());
    }

    public static List<BookRecommendation> transform(List<Book> books){
        return books.stream()
                    .map((book -> new BookRecommendation(book.getTitle(), book.getRating())))
                    .toList();
    }

    public static List<Book> sortBooksByRatings(List<Book> books) {
        return books.stream()
        .sorted(Comparator.comparingDouble(Book::getRating))
        .toList();
    }

    public static List<List<Book>> paginatedResult(List<Book> books) {
    List<List<Book>> paginatedList = new ArrayList<>();
        List<Book> recommedations = sortBooksByRatings(books);
        for(int i=0; i<recommedations.size(); i+=2) {
            paginatedList.add(recommedations.subList(i, Math.min(i+2, recommedations.size())));
        }
        return paginatedList;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 4.8));
        books.add(new Book("1984", "George Orwell", "Dystopian", 4.7));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Science Fiction", 4.4));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Romance", 4.5));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Science Fiction", 4.2));

        List<Book> filterdBooks = filterBooks(books);
        for(Book book : filterdBooks) {
            System.out.println(book);
        }
        System.out.println();
        
        List<BookRecommendation> bookRecommendations = transform(books);
        for(BookRecommendation book : bookRecommendations){
            System.out.println(book);
        }

        System.out.println();

        List<Book> sortBooksByRatings = sortBooksByRatings(books);
        for(Book b : sortBooksByRatings) {
            System.out.println(b);
        }
        System.out.println();
        List<List<Book>> paginatedResult = paginatedResult(books);
        for(List<Book> page : paginatedResult){
           System.out.println("Page:");
            for(Book b : page) {
                System.out.println(b);
            }
        }
    }
}

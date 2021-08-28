package main.java;

//import lombok.AllArgsConstructor;
//import lombok.Data;

import java.util.List;
import java.util.Optional;

public class Java8Test {

  //  @Data
    public static class Book{
        String title;
        String author;
        int price;

        public Book(String title, String author, int price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Book> list = List.of(
                new Book("a1", "aa1", 1),
                new Book("a2", "aa2", 2),
                new Book("a3", "aa3", 3),
                new Book("a4", "aa4", 4),
                new Book("a5", "aa5", 5),
                new Book("a6", "aa6", 6)
                );

        Optional<Book> book = list.stream().filter(m -> m.price > 4).findFirst();
        System.out.println(book.toString());
        int price = list.stream().filter(m -> m.price < 4).findFirst().get().price;
        System.out.println(price);
    }
}

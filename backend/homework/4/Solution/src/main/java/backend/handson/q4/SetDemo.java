package backend.handson.q4;

import backend.handson.LogBack;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {


    public static void treeSetDemo(Comparator<Book> comparator) {
        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book5 = new Book("The Last Lecture", "Randy Pausch", 2008);

        Set<Book> books = new TreeSet<>(comparator);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);


        for (Book book : books) {
            String formattedString = String.format("Book [title=%s, author=%s, year=%d]",book.getTitle(),book.getAuthor(),book.getYear());
            LogBack.outputLogger(formattedString,"INFO");
        }

    }

    public static void main(String[] args) {
        LogBack.outputLogger("\nBooks in Normal Order","INFO");
        treeSetDemo(null);
        LogBack.outputLogger("\nBooks in Ascending Order","INFO");
        treeSetDemo(new PubDateAscComparator());
        LogBack.outputLogger("\nBooks in Descending Order","INFO");
        treeSetDemo(new PubDateDescComparator());
    }

}

package LMS;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    // Helper method to simulate user input
    private void simulateUserInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @Test
    void testSearchForBooksByTitle() throws IOException {
        // Create the library and sample books
        Library library = new Library();
        ArrayList<Book> booksInLibrary = new ArrayList<>();
        Book book1 = new Book(1, "The Great Gatsby", "Fiction", "F. Scott Fitzgerald", false);
        Book book2 = new Book(2, "Moby Dick", "Fiction", "Herman Melville", false);
        booksInLibrary.add(book1);
        booksInLibrary.add(book2);

        // Set the booksInLibrary field directly for testing purposes
        library.addBookinLibrary(book1);
        library.addBookinLibrary(book2);

        // Simulate user input for title search
        String simulatedInput = "1\nThe Great Gatsby\n"; // '1' for title search and the title "The Great Gatsby"
        simulateUserInput(simulatedInput);

        // Call the search method
        ArrayList<Book> result = library.searchForBooks();

        // Assert: Check that the correct book is found
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("The Great Gatsby", result.get(0).getTitle());
    }

    @Test
    void testSearchForBooksBySubject() throws IOException {
        // Create the library and sample books
        Library library = new Library();
        ArrayList<Book> booksInLibrary = new ArrayList<>();
        Book book1 = new Book(1, "The Great Gatsby", "Fiction", "F. Scott Fitzgerald", false);
        Book book2 = new Book(2, "Moby Dick", "Journal", "Herman Melville", false);
        booksInLibrary.add(book1);
        booksInLibrary.add(book2);

        // Set the booksInLibrary field directly for testing purposes
        library.addBookinLibrary(book1);
        library.addBookinLibrary(book2);

        // Simulate user input for subject search
        String simulatedInput = "2\nFiction\n"; // '2' for subject search and the subject "Fiction"
        simulateUserInput(simulatedInput);

        // Call the search method
        ArrayList<Book> result = library.searchForBooks();

        // Assert: Check that the correct book is found
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("The Great Gatsby", result.get(0).getTitle());
    }

    @Test
    void testSearchForBooksNoMatch() throws IOException {
        // Create the library and sample books
        Library library = new Library();
        ArrayList<Book> booksInLibrary = new ArrayList<>();
        Book book1 = new Book(1, "The Great Gatsby", "Fiction", "F. Scott Fitzgerald", false);
        Book book2 = new Book(2, "Moby Dick", "Fiction", "Herman Melville", false);
        booksInLibrary.add(book1);
        booksInLibrary.add(book2);

        // Set the booksInLibrary field directly for testing purposes
        library.addBookinLibrary(book1);
        library.addBookinLibrary(book2);

        // Simulate user input for title search with no matching books
        String simulatedInput = "1\nNonexistent Book\n"; // Search for a non-existent book
        simulateUserInput(simulatedInput);

        // Call the search method
        ArrayList<Book> result = library.searchForBooks();

        // Assert: Check that no books are returned
        assertNull(result);
    }

    @Test
    void testSearchForBooksByAuthor() throws IOException {
        // Create the library and sample books
        Library library = new Library();
        ArrayList<Book> booksInLibrary = new ArrayList<>();
        Book book1 = new Book(1, "The Great Gatsby", "Fiction", "F. Scott Fitzgerald", false);
        Book book2 = new Book(2, "Moby Dick", "Fiction", "Herman Melville", false);
        booksInLibrary.add(book1);
        booksInLibrary.add(book2);

        // Set the booksInLibrary field directly for testing purposes
        library.addBookinLibrary(book1);
        library.addBookinLibrary(book2);

        // Simulate user input for author search
        String simulatedInput = "3\nHerman Melville\n"; // '3' for author search and the author "Herman Melville"
        simulateUserInput(simulatedInput);

        // Call the search method
        ArrayList<Book> result = library.searchForBooks();

        // Assert: Check that the correct book is found
        assertEquals(1, result.size());
        assertEquals("Herman Melville", result.get(0).getAuthor());
    }
}

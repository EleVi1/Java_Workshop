import fr.epita.assistants.myebook.Book;
import fr.epita.assistants.myebook.EBook;
import fr.epita.assistants.myebook.EBookReader;

public class Main {
    EBook eBook = new EBook("Harry Potter");
    eBook.writeCurrentPage("This story is about a young wizard..");
    Book printedBook = eBook.print();
    assertEquals("This story is about a young wizard..", printedBook.readCurrentPage());
    EBookReader eBookReader = new EBookReader();
    eBookReader.openEbook(printedBook.scan());
    assertEquals("This story is about a young wizard..", eBookReader.readCurrentPage());
}

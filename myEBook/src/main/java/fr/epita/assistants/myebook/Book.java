package fr.epita.assistants.myebook;

import java.util.List;

public class Book implements IPaginated, IReadable {

    public List<String> livre;
    public String title;
    public int index_page = 0;

    // Instantiate a book with a certain title and page contents.
    // Only the EBook class should be able to call the Book constructor since it
    // is the only one able to print it, hence it must not be public.
    Book(String name, List<String> pages) {
        title = name;
        livre = pages;
    }

    // Get the name of the book.
    public String getName()
    {
        return title;
    }

    // Create an EBook from the book.
    public EBook scan()
    {
        return new EBook(title);
    }
    @Override
    public void openToPage(int page) {
        if (page >= 0 && page < getPageCount()) {
            index_page = page;
        }
    }

    @Override
    public int getCurrentPage() {
        return index_page;
    }

    @Override
    public int getPageCount() {
        return livre.size();
    }

    @Override
    public String readCurrentPage() {
        return livre.get(index_page);
    }
}

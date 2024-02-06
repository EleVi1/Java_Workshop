package fr.epita.assistants.myebook;

import java.util.List;

public class Book implements IPaginated, IReadable {

    public List<String> pages;
    public String title;
    public int index_page = 0;

    // Instantiate a book with a certain title and page contents.
    // Only the EBook class should be able to call the Book constructor since it
    // is the only one able to print it, hence it must not be public.
    Book(String name, List<String> pages) {
        title = name;
        this.pages = pages;
    }

    // Get the name of the book.
    public String getName()
    {
        return title;
    }

    // Create an EBook from the book.
    public EBook scan()
    {
        EBook ebook = new EBook(title);
        ebook.openToPage(0);
        ebook.writeCurrentPage(pages.get(0));
        for (int i = 1; i < getPageCount(); i++)
        {
            ebook.addPage();
            ebook.openToPage(i);
            ebook.writeCurrentPage(pages.get(i));
        }

        return ebook;
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
        return pages.size();
    }

    @Override
    public String readCurrentPage() {
        if (index_page >= 0 && index_page < getPageCount()) {
            return pages.get(index_page);
        }
        return null;
    }
}

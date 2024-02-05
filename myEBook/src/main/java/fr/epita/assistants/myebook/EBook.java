package fr.epita.assistants.myebook;

import java.util.List;

public class EBook implements IPaginated, IEditable {

    String title;
    List<String> pages;
    double version;
    int current_page;
    public EBook(String name) {
        title = name;
        version = 1.0;
        pages = null;
        addPage();
    }

    // Get the name of the book.
    public String getName() {
        return title;
    }

    // Create a book from the EBook.
    // The instantiated book is a version of the ebook, and can no longer be modified
    public Book print() {
        return new Book(title, pages);
    }

    @Override
    public void writeCurrentPage(String pageText) {
        pages.set(current_page, pageText);
    }

    @Override
    public void addPage() {
        pages.add("");
    }

    @Override
    public void deletePage() {
        pages.remove(current_page);
        if (getPageCount() == 0)
        {
            addPage();
        }
    }

    @Override
    public void openToPage(int page) {
        if (page >= 0 && page < getPageCount()) {
            current_page = page;
        }
    }

    @Override
    public int getCurrentPage() {
        return current_page;
    }

    @Override
    public int getPageCount() {
        return pages.size();
    }
}

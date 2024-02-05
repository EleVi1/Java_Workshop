package fr.epita.assistants.myebook;

import java.util.List;

public class EBookReader implements IUpdatable, IPaginated {

    double version;
    int current_page = 0;
    List<String> pages;
    // Instantiate a new ebook reader with firmware 1.0
    public EBookReader() {
        version =  1.0;
    }

    // Load an ebook into the reader.
    public void openEbook(EBook ebook) {
        pages = ebook.pages;
    }

    @Override
    public double getVersion() {
        return version;
    }

    @Override
    public void update(double version) {
        if (version > this.version)
        {
            this.version = version;
        }
    }

    @Override
    public void openToPage(int page) {
        current_page = page;
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

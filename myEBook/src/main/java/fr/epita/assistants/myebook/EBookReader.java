package fr.epita.assistants.myebook;

import java.util.List;

public class EBookReader implements IUpdatable, IPaginated, IReadable {

    double version;
    EBook ebook;
    int current_page = 0;
    // Instantiate a new ebook reader with firmware 1.0
    public EBookReader() {
        version =  1.0;
        ebook = null;
    }

    // Load an ebook into the reader.
    public void openEbook(EBook ebook) {
        this.ebook = ebook;
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

        if (ebook == null)
        {
            return -1;
        }
        return ebook.getCurrentPage();
    }

    @Override
    public int getPageCount() {

        if (ebook == null) {
            return -1;
        }
        else
        {
            return ebook.getPageCount();
        }
    }

    @Override
    public String readCurrentPage() {
        if (ebook == null) {
            return null;
        }
        return ebook.pages.get(current_page);
    }
}

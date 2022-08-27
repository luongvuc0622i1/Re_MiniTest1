package model;

import java.io.Serializable;
import java.util.Scanner;

public class ProgrammingBook extends Book implements Serializable {
    private String language;
    private Book book;

    public ProgrammingBook() {
    }

    public ProgrammingBook(int bookCode, String name, int price, String author, String language) {
        super(bookCode, name, price, author);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", language='" + language + '\'' +
                '}';
    }
}

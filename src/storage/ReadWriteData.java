package storage;

import model.Book;

import java.util.List;

public interface ReadWriteData {
    List<Book> readData();
    void writeData(List<Book> books);
}
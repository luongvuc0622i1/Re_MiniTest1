package storage;

import model.Book;

import java.util.List;

public class TestRead {
    public static void main(String[] args) {
        ReadWriteData readWriteData = ReadWriteFile.getInstance();
        List<Book> books = readWriteData.readData();
        for (int i=0 ; i < books.size() ; i++) {
            System.out.println(books.get(i));
        }
    }
}

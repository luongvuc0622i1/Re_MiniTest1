package storage;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements ReadWriteData {
    private static ReadWriteFile instance=null;

    private ReadWriteFile() {
    }

    public static ReadWriteFile getInstance(){
        if (instance == null) instance = new ReadWriteFile();
        return instance;
    }

    @Override
    public void writeData(List<Book> bookList) {
        try {
            FileOutputStream fos = new FileOutputStream("bookList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Book> readData() {
        List<Book> bookList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("bookList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            bookList = (List<Book>) obj;
            return bookList;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

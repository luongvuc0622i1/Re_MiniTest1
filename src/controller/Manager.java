package controller;

import model.Book;
import model.FictionBook;
import model.ProgrammingBook;
import storage.ReadWriteData;
import storage.ReadWriteFile;
import storage.ReadWriteFileExcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    public static List<Book> inputDataBook(int amountProgramming, int amountFiction) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < amountProgramming; i++) {
            ProgrammingBook book = new ProgrammingBook();
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập vào thông tin quyển sách chuyên ngành " + (i+1));
            System.out.printf("Nhập vào mã sách: ");
            book.setBookCode(input.nextInt());
            System.out.printf("Nhập vào tên sách: ");
            input.nextLine();
            book.setName(input.nextLine());
            System.out.printf("Nhập vào giá sách: ");
            book.setPrice(input.nextInt());
            System.out.printf("Nhập vào tác giả sách: ");
            input.nextLine();
            book.setAuthor(input.nextLine());
            System.out.printf("Nhập vào ngôn ngữ sách: ");
            book.setLanguage(input.next());
            books.add(book);
        }
        for (int i = 0; i < amountFiction; i++) {
            FictionBook book = new FictionBook();
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập vào thông tin quyển sách viễn tưởng " + (i+1));
            System.out.printf("Nhập vào mã sách: ");
            book.setBookCode(input.nextInt());
            System.out.printf("Nhập vào tên sách: ");
            input.nextLine();
            book.setName(input.nextLine());
            System.out.printf("Nhập vào giá sách: ");
            book.setPrice(input.nextInt());
            System.out.printf("Nhập vào tác giả sách: ");
            input.nextLine();
            book.setAuthor(input.nextLine());
            System.out.printf("Nhập vào thể loại sách: ");
            book.setCategory(input.nextLine());
            books.add(book);
        }
        return books;
    }

    private ReadWriteData readWriteData = ReadWriteFile.getInstance();
    public List<Book> bookList = readWriteData.readData();

    //Phương thức sửa
    public void editBookByIndex(int index, Book book){
        bookList.set(index, book);
        readWriteData.writeData(bookList);
    }

    //Phương thức thêm
    public void addNewBook(Book book){
        bookList.add(book);
        readWriteData.writeData(bookList);
    }

    //Phương thức hiển thị
    public void display() {
        List<Book> books = readWriteData.readData();
        for (int i=0 ; i < books.size() ; i++) {
            System.out.println(books.get(i));
        }
    }

    //Phương thức tính tổng tiền của 10 cuốn sách
    public static int getSumTotalPrice(List<Book> books){
        int sum=0;
        for (int i = 0; i < books.size(); i++) {
            sum+=books.get(i).getPrice();
        }
        return sum;
    }

    //Phương thức đếm số sách ProgrammingBook có language là "Java"
    public static int countJava(List<Book> books){
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) instanceof ProgrammingBook){
                String language = ((ProgrammingBook)books.get(i)).getLanguage();
                if (language.equals("Java")) {
                    count++;
                }
            }
        }
        return count;
    }

    //Phương thức đếm số sách FictionBook có category là "Viễn tưởng 1"
    public static int countCategory(List<Book> books) {
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) instanceof FictionBook){
                String category = ((FictionBook)books.get(i)).getCategory();
                if (category.equals("Viễn tưởng 1")) {
                    count++;
                }
            }
        }
        return count;
    }

    //Phương thức đếm số sách FictionBook có giá dưới 100
    public static int countFiction(List<Book> books) {
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) instanceof FictionBook){
                int price = ((FictionBook)books.get(i)).getPrice();
                if (price < 100) {
                    count++;
                }
            }
        }
        return count;
    }
}

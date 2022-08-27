package controller;

import model.Book;
import model.ProgrammingBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    public static List<Book> inputDataProgrammingBook(int amount) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            ProgrammingBook book = new ProgrammingBook();
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập vào thông tin quyển sách " + (i+1));
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
        return books;
    }


}

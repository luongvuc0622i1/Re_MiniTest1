package views;

import controller.Manager;
import model.Book;

import java.util.List;
import java.util.Scanner;

import static controller.Manager.inputDataProgrammingBook;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số lượng sách chuyên môn: ");
        int amount = scanner.nextInt();
        List<Book> books = inputDataProgrammingBook(amount);
        for (Book b : books) {
            System.out.println(b);
        }

    }
}

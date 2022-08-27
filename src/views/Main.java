package views;

import controller.Manager;
import model.Book;
import storage.ReadWriteData;
import storage.ReadWriteFile;
import storage.ReadWriteFileExcel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static controller.Manager.*;

public class Main {
    public static void main(String[] args) {
        ReadWriteData readWriteData = ReadWriteFile.getInstance();
        Manager manager = new Manager();
        List<Book> books = new ArrayList<>();
        try {
            Scanner can = new Scanner(System.in);
            System.out.println("Nhập số lượng sách chuyên ngành: ");
            int amountProgramming = can.nextInt();
            System.out.println("Nhập số lượng sách viễn tưởng: ");
            int amountFiction = can.nextInt();
            books = inputDataBook(amountProgramming, amountFiction);
        } catch (InputMismatchException e) {
            System.err.println("Nhập sai cú pháp rồi!");
        } finally {
            readWriteData.writeData(books);
            //Yêu cầu 0: hiển thị mảng vừa nhập
            manager.display();
            //Yêu cầu 1: tính tổng tiền của 10 cuốn sách
            int sumTenBook = getSumTotalPrice(books);
            System.out.println("Tổng tiền của 10 cuốn sách vừa nhập là: " + sumTenBook);
            //Yêu cầu 2: đếm số sách ProgrammingBook có language là "Java"
            int countJava = countJava(books);
            System.out.println("Số lượng sách Java là: " + countJava);
            //Yêu cầu 3: đếm số sách FictionBook có category là "Viễn tưởng 1"
            int countCategory = countCategory(books);
            System.out.println("Số lượng sách Viễn tưởng 1 là: " + countCategory);
            //Yêu cầu 4: đếm số sách FictionBook có giá là dưới 100
            int countFiction = countFiction(books);
            System.out.println("Số lượng sách FictionBook có giá dưới 100 là: " + countFiction);
        }
    }
}

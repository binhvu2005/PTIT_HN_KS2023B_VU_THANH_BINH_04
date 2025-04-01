package ra.presentation;

import ra.entity.Customer;
import static ra.bussiness.CustomerBusiness.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerApplication {
    public static List<Customer> CustomerList = new ArrayList<>();
    public static final int MAX_CUSTOMERS = 100;
    public static void main(String[] args) {
        int choice;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("----------------------------Customer Menu----------------------------");
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Thoát chương trình");
            System.out.println("----------------------------------------------------------------");
            System.out.print("lựa chọn của bạn là : ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayCustomers();
                    break;
                case 2:
                    addNewCustomer(sc);
                    break;
                case 3:
                    editCustomer(sc);
                    break;
                case 4:
                    deleteCustomer(sc);
                    break;
                case 5:
                    searchCustomer(sc);
                    break;
                case 6:
                    sortCustomer(sc);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }


}

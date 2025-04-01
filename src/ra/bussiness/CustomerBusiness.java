package ra.bussiness;

import ra.entity.Customer;
import ra.validate.validate;

import java.util.Scanner;

import static ra.presentation.CustomerApplication.*;

public class CustomerBusiness {
    // in ra danh sách khách hàng
    public static void displayCustomers() {
        System.out.println("Danh sách khách hàng:");
        if (CustomerList.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (Customer customer : CustomerList) {
                customer.displayData();
            }
        }
    }
    // thêm mới khách hàng

    public static void addNewCustomer(Scanner sc) {
        if (CustomerList.size() == MAX_CUSTOMERS) {
            System.out.println("Không thể thêm mới khách hàng nữa. Danh sách đã đầy.");
            return;
        }
        System.out.print("Nhập số lượng khách hàng cần thêm: ");
        int numCustomers = validate.validatePositiveInteger(sc, "");
        if (CustomerList.size() + numCustomers > MAX_CUSTOMERS) {
            System.out.println("Số lượng khách hàng vượt quá giới hạn. Chỉ có thể thêm tối đa " + (MAX_CUSTOMERS - CustomerList.size()) + " khách hàng.");
            numCustomers = MAX_CUSTOMERS - CustomerList.size();
        }
        for (int i = 0; i < numCustomers; i++) {
            System.out.println("Nhập thông tin cho khách hàng thứ " + (i + 1) + ":");
            Customer newCustomer = new Customer();
            newCustomer.setCustomerId(validate.generateCustomerId());
            newCustomer.setFirstName(validate.validateString(sc, "Nhập tên khách hàng: ", 50));
            newCustomer.setLastName(validate.validateString(sc, "Nhập họ khách hàng: ", 30));
            newCustomer.setEmail(validate.validateEmail(sc, "Nhập email khách hàng : "));
            newCustomer.setPhoneNumber(validate.validatePhoneNumber(sc, "Nhập số điện thoại: "));
            newCustomer.setAddress(validate.validateString(sc, "Nhập địa chỉ: ", 255));
            newCustomer.setGender(validate.validateBoolean(sc," Nhập giới tính (true-nam/false- nữ): "));
            newCustomer.setDateOfBirth(validate.validateDateOfBirth(sc, "Nhập ngày sinh (dd/MM/yyyy): "));
            newCustomer.setCustomerType(validate.validateString(sc, "Nhập loại khách hàng: ", 50));
            CustomerList.add(newCustomer);
            System.out.println("Thêm khách hàng thành công.");
        }
    }
    // sửa thông tin khách hàng
    private static Customer findCustomerById(String customerId) {
        for (Customer customer : CustomerList) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    public static void editCustomer(Scanner sc) {
        System.out.print("Nhập mã khách hàng cần chỉnh sửa: ");
        String customerId = sc.nextLine();
        Customer customerToEdit = findCustomerById(customerId);
        if (customerToEdit == null) {
            System.out.println("Không tìm thấy khách hàng.");
            return;
        }
        customerToEdit.displayData();
        System.out.println("Chọn thuộc tính cần sửa:");
        System.out.println("1. Tên khách hàng");
        System.out.println("2. Họ khách hàng");
        System.out.println("3. Email");
        System.out.println("4. Số điện thoại");
        System.out.println("5. Địa chỉ");
        System.out.println("6. Giới tính");
        System.out.println("7. Ngày sinh");
        System.out.println("8. Loại khách hàng");
        System.out.print("Lựa chọn của bạn: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                customerToEdit.setFirstName(validate.validateString(sc, "Nhập tên khách hàng mới: ", 50));
                break;
            case 2:
                customerToEdit.getLastName(validate.validateString(sc, "Nhập họ khách hàng mới: ", 30));
                break;
            case 3:
                customerToEdit.setEmail(validate.validateEmail(sc, "Nhập email mới: "));
                break;
            case 4:
                customerToEdit.setPhoneNumber(validate.validatePhoneNumber(sc, "Nhập số điện thoại mới: "));
                break;
            case 5:
                customerToEdit.setAddress(validate.validateString(sc, "Nhập địa chỉ mới: ", 255));
                break;
            case 6:
                customerToEdit.setGender(validate.validateBoolean(sc," Nhập giới tính mới (true-nam/false- nữ): "));
                break;
            case 7:
                customerToEdit.setDateOfBirth(validate.validateDateOfBirth(sc, "Nhập ngày sinh mới (dd/MM/yyyy): "));
                break;
            case 8:
                customerToEdit.setCustomerType(validate.validateString(sc, "Nhập loại khách hàng mới: ", 50));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
        System.out.println("Chỉnh sửa thông tin khách hàng thành công.");
    }
// xóa khách hàng
    public static void deleteCustomer(Scanner sc) {
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String customerId = sc.nextLine();
        Customer customerToDelete = findCustomerById(customerId);
        if (customerToDelete == null) {
            System.out.println("Không tìm thấy khách hàng.");
            return;
        }
        customerToDelete.displayData();
        System.out.print("Bạn có chắc chắn muốn xóa khách hàng này? (y/n): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            CustomerList.remove(customerToDelete);
            System.out.println("Xóa khách hàng thành công.");
        } else {
            System.out.println("Hủy bỏ thao tác xóa.");
        }
    }
    //tìm kiếm khách hàng Hiển thị menu tìm kiếm theo tiêu chí
    public static void searchCustomer(Scanner sc) {
        System.out.println("Chọn tiêu chí tìm kiếm:");
        System.out.println("1. Tìm theo mã khách hàng");
        System.out.println("2. Tìm theo tên khách hàng");
        System.out.println("3. Tìm theo số điện thoại");
        System.out.print("Lựa chọn của bạn: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Nhập mã khách hàng cần tìm: ");
                String customerId = sc.nextLine();
                Customer customerById = findCustomerById(customerId);
                if (customerById != null) {
                    customerById.displayData();
                } else {
                    System.out.println("Không tìm thấy khách hàng.");
                }
                break;
            case 2:
                System.out.print("Nhập tên khách hàng cần tìm: ");
                String customerName = sc.nextLine();
                for (Customer customer : CustomerList) {
                    if (customer.getFirstName().equalsIgnoreCase(customerName)) {
                        customer.displayData();
                    }
                }
                break;
            case 3:
                System.out.print("Nhập số điện thoại cần tìm: ");
                String phoneNumber = sc.nextLine();
                for (Customer customer : CustomerList) {
                    if (customer.getPhoneNumber().equals(phoneNumber)) {
                        customer.displayData();
                    }
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }
    // sắp xếp khách hàng sắp xếp theo tiêu chí Sắp xếp theo tên tăng
    public static void sortCustomer(Scanner sc) {
        System.out.println("Chọn tiêu chí sắp xếp:");
        System.out.println("1. Sắp xếp theo tên khách hàng (tăng dần)");
        System.out.println("2. Sắp xếp theo tên khách hàng (giảm dần)");
        System.out.print("Lựa chọn của bạn: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                CustomerList.sort((c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));
                break;
            case 2:
                CustomerList.sort((c1, c2) -> c2.getFirstName().compareToIgnoreCase(c1.getFirstName()));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
        System.out.println("Danh sách khách hàng đã được sắp xếp.");
        displayCustomers();
    }
}

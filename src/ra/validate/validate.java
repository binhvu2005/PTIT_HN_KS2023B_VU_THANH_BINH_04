package ra.validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class validate {
    private static Set<String> usedCustonmerIds = new HashSet<>();
    private static int CustonmerIdCounter = 1;

    // Phương thức tạo mã sách tự động
    public static String generateCustomerId() {
        String CustomerId;
        do {
            CustomerId = String.format("C%04d", CustonmerIdCounter++);
        } while (usedCustonmerIds.contains(CustomerId));
        usedCustonmerIds.add(CustomerId);
        return CustomerId;
    }
    // Phương thức xác thực chuỗi không được để trống và giới hạn độ dài
    public static String validateString(Scanner sc,String message, int maxLength) {
        String input;
        do {
            System.out.print(message);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Chuỗi không được để trống. Vui lòng nhập lại.");
            } else if (input.length() > maxLength) {
                System.out.println("Chuỗi không được vượt quá " + maxLength + " ký tự. Vui lòng nhập lại.");
            }
        } while (input.isEmpty() || input.length() > maxLength);
        return input;
    }
    //số điện thoại, không để trống, không trùng lặp, định dạng sốđiện thoại ViViệt Nam số đầu tiên là 0, sau đó là 3,5,7,8,9 còn lại là 8 số
    public static String validatePhoneNumber(Scanner sc,String message) {
        String phoneNumber;
        do {
            System.out.print(message);
            phoneNumber = sc.nextLine().trim();
            if (phoneNumber.isEmpty()) {
                System.out.println("Số điện thoại không được để trống. Vui lòng nhập lại.");
            } else if (!phoneNumber.matches("0[35789]\\d{8}")) {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }
        } while (phoneNumber.isEmpty() || !phoneNumber.matches("0[35789]\\d{8}"));
        return phoneNumber;
    }
    //địa chỉ email, không trùng lặp,  định dạng gmail
    public static String validateEmail(Scanner scanner,String message) {
        String email;
        do {
            System.out.print(message);
            email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Email không được để trống. Vui lòng nhập lại.");
            } else if (!email.matches("[a-zA-Z0-9._%+-]+@gmail\\.com")) {
                System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
            }
        } while (email.isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@gmail\\.com"));
        return email;
    }
    //customerTyType - String - loại khách hàng (ví dụ: cá nhân, doanh nghiệp), không để trống
    public static String validateCustomerType(Scanner scanner,String message) {
        String customerType;
        do {
            System.out.print(message);
            customerType = scanner.nextLine().trim();
            if (customerType.isEmpty()) {
                System.out.println("Loại khách hàng không được để trống. Vui lòng nhập lại.");
            }
        } while (customerType.isEmpty());
        return customerType;
    }
    // định dạng ngày sinh, không để trống, định dạng dd/MM/yyyy
    public static String validateDateOfBirth(Scanner sc, String message) {
        String dateOfBirth;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate currentDate = LocalDate.now();
        do {
            System.out.print(message);
            dateOfBirth = sc.nextLine().trim();
            if (dateOfBirth.isEmpty()) {
                System.out.println("Ngày sinh không được để trống. Vui lòng nhập lại.");
            } else {
                try {
                    LocalDate parsedDate = LocalDate.parse(dateOfBirth, formatter);
                    if (parsedDate.isAfter(currentDate)) {
                        System.out.println("Ngày sinh không được lớn hơn ngày hiện tại. Vui lòng nhập lại.");
                    } else {
                        return dateOfBirth;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yyyy.");
                }
            }
        } while (true);
    }

    public static int validatePositiveInteger(Scanner sc, String s) {
        int number;
        do {
            System.out.print(s);
            while (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập một số nguyên dương.");
                sc.next();
                System.out.print(s);
            }
            number = sc.nextInt();
            if (number <= 0) {
                System.out.println("Vui lòng nhập số nguyên dương.");
            }
        } while (number <= 0);
        sc.nextLine();
        return number;
    }
    public static boolean validateBoolean(Scanner sc, String s) {
       do {
           System.out.print(s);
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("true")) {
                return true;
            } else if (input.equalsIgnoreCase("false")) {
                return false;
            } else {
                System.out.println("Vui lòng nhập 'true' hoặc 'false'.");
            }
        } while (true);
       }
}


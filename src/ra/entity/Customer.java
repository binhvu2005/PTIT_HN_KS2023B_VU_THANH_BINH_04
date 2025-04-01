package ra.entity;

import java.util.Scanner;

public class Customer implements IApp {
    private String customerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer(String customerId, String firstName, String lastName, String dateOfBirth, boolean gender, String address, String phoneNumber, String email, String customerType) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
    }
    public Customer(){
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void getLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập mã khách hàng: ");
        this.customerId = sc.nextLine();
        System.out.println("Nhập họ khách hàng: ");
        this.firstName = sc.nextLine();
        System.out.println("Nhập tên khách hàng: ");
        this.lastName = sc.nextLine();
        System.out.println("Nhập ngày sinh khách hàng: ");
        this.dateOfBirth = sc.nextLine();
        System.out.println("nhập giới tính khách hàng: ");
        this.gender = sc.nextBoolean();
        System.out.println("Nhập địa chỉ khách hàng: ");
        this.address = sc.nextLine();
        System.out.println("Nhập số điện thoại khách hàng: ");
        this.phoneNumber = sc.nextLine();
        System.out.println("Nhập email khách hàng: ");
        this.email = sc.nextLine();
        System.out.println("Nhập loại khách hàng: ");
        this.customerType = sc.nextLine();
        sc.nextLine();
    }

    @Override
    public void displayData() {
        System.out.println("Thông tin khách hàng:");
        System.out.println("Mã khách hàng: " + customerId);
        System.out.println("Họ khách hàng: " + firstName);
        System.out.println("Tên khách hàng: " + lastName);
        System.out.println("Ngày sinh khách hàng: " + dateOfBirth);
        System.out.println("Giới tính khách hàng: "+ gender);
        System.out.println("Địa chỉ khách hàng: " + address);
        System.out.println("Số điện thoại khách hàng: " + phoneNumber);
        System.out.println("Email khách hàng: " + email);
        System.out.println("Loại khách hàng: " + customerType);
        System.out.println("====================================");
    }
}

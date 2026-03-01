/**
 * Project: Retail Store Database Project
 * Purpose Details: Customer model class with properties and behaviors
 * Course: IST 242
 * Author: Alyssa Thompson
 * Date Developed: 02/28/2026
 * Last Date Changed: 03/01/2026
 * Rev: 1.0
 */

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Customer(){}

    public Customer(int customerId, String firstname, String lastname, String email, String phone){
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getCustomerId(){return customerId;}
    public void setCustomerId(int customerId){this.customerId = customerId;}

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

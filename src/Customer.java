/**
 * Project: Retail Store Database Project
 * Purpose Details: Customer model class with properties and behaviors
 * Course: IST 242
 * Author: Alyssa Thompson
 * Date Developed: 02/28/2026
 * Last Date Changed: 03/01/2026
 * Rev: 3.0
 */

public class Customer {
    /**
     * Customer ID.
     */
    private int customerId;

    /**
     * Customer First Name.
     */
    private String firstName;

    /**
     * Customer Last Name.
     */
    private String lastName;

    /**
     * Customer email.
     */
    private String email;

    /**
     * Customer phone number.
     */
    private String phone;

    /**
     * Default constructor.
     */
    public Customer(){}

    /**
     * Parameterized constructor.
     *
     * @param customerId Customer ID
     * @param firstname First name
     * @param lastname Last name
     * @param email Email address
     * @param phone Phone number
     */

    public Customer(int customerId, String firstname, String lastname, String email, String phone){
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    /** @return customer ID */
    public int getCustomerId(){return customerId;}

    /** @param customerId sets customer ID */
    public void setCustomerId(int customerId){this.customerId = customerId;}

    /** @return customer firstname */
    public String getFirstName(){return firstName;}

    /** @param firstName sets firstname */
    public void setFirstName(String firstName){this.firstName = firstName;}

    /** @return customer lastname */
    public String getLastName(){return lastName;}

    /** @param lastName sets firstname */
    public void setLastName(String lastName){this.lastName = lastName;}

    /** @return customer email */
    public String getEmail(){return email;}

    /** @param email sets email */
    public void setEmail(String email){this.email = email;}

    /** @return customer phone number */
    public String getPhone(){return phone;}

    /** @param phone sets phone */
    public void setPhone(String phone){this.phone = phone;}


    /**
     * Returns formatted customer information.
     *
     * @return formatted string
     */
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

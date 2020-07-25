import java.util.Scanner;

public class Email {
    private String fistName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLenth = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // Constructor to receive the first name and last name
    public Email(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department

        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLenth);
        System.out.println("Your password is : " +this.password);

        // Combine elements to generate email
        email = fistName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New worker" + fistName + ". Department Codes:\n1 for Sales\n2 for Development \n3 for Accounting \n0 for none\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return ""; }
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + fistName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}


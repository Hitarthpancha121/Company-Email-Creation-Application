package com.EmailApplication;

import com.sun.jdi.request.ThreadStartRequest;

import java.util.Locale;
import java.util.Scanner;

public class Email{

    // Declaring the Fields used in the application
       private  String firstName;
       private String lastName;
       private  String Password;
       private String Department;
       private int MailBoxCapacity=500;
       private String AlternateEmail="admin001@gmail.com";
       private int DefaultPasswordLength=10;
       private String email;
       private String CompanySuffix="hitZZcompany.com";


       // creating constructor to receive first name and last name
    public Email(){

        // this keyword is used to refer the current object which is Instance variable

        Scanner ss=new Scanner(System.in);
        System.out.println(". . . EMAIL GENERATOR APPLICATION . . . ");
        System.out.print("Enter the First Name: ");
        this.firstName=ss.nextLine();

        System.out.print("Enter the Last Name: ");
        this.lastName=ss.nextLine();

        // call a method asking for the department and return the department
        this.Department=setDepartment();

        // call the method that return random password
        this.Password=GenratePassword(DefaultPasswordLength);
        System.out.println("Your Password is: "+Password);

        // combine elements to generate an Email
        email=firstName.toLowerCase(Locale.ROOT)+"."+lastName.toLowerCase(Locale.ROOT)+"@"+Department+"."+CompanySuffix;


    }
       // Ask for the department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES\n 1) For Sales\n 2) For Accounting\n 3) For Development Team\n 4) For None\n Enter Department Code: ");
        Scanner sc=new Scanner(System.in);
        int dep_Choice= sc.nextInt();
        if(dep_Choice==1){
            return "Sales";
        }
        else if(dep_Choice==2){
            return "Accounting";
        }
        else if(dep_Choice==3){
            return "Devlopement";
        }
        else {
            return " ";
        }
    }
       // generate a random password
    private String GenratePassword(int length){
        String passwordSET="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[]pass=new char[length];
        for(int i=0;i<length;i++){
           int rand= (int) (Math.random() * passwordSET.length());
           pass[i]=passwordSET.charAt(rand);
        }
        return new String(pass);

    }
       // set the mailbox capacity
    public void SetMailBoxCapacity(int capacity){
        this.MailBoxCapacity=capacity;

    }
       // set alternative email
    public void SetAlternateemail(String altEmail){
        this.AlternateEmail=altEmail;
    }
    // change the password
    public void changePass(String paaass){
        this.Password=paaass;
    }

    public int GetMailBoxCapacity(){
        return MailBoxCapacity;
    }
    public String GetAltEmail(){
        return AlternateEmail;
    }
    public String GetPass(){
        return Password;
    }

    public String ShowInfo(){
        return "DISPLAY NAME: "+firstName+" "+lastName+
                "\nCOMPANY E-MAIL: "+email+
                "\nMAILBOX CAPACITY: "+MailBoxCapacity+"mb";
    }

    }

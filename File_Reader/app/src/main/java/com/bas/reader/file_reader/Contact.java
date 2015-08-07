package com.bas.reader.file_reader;

import java.util.ArrayList;

/**
 * Created by sadhi on 6-8-2015.
 */
public class Contact {

    protected String firstName, lastName;
    protected String age;
    protected Address adres;
    protected PhoneNumber phone;
    protected PhoneNumber fax;

    public Contact(String s)
    {
        String s1[] = s.split("\r\n     ");
        String tmp;
        for(int i = 0; i<s1.length; i++)
        {
            tmp = s1[i].split(":")[0];
            switch (tmp)
            {
                case "firstName":
                    firstName = s1[i].split(": ")[1];
                    break;
                case "lastName":
                    lastName = s1[i].split(": ")[1];
                    break;
                case "age":
                    age = s1[i].split(": ")[1];
                    break;
                case "address":
                    String street = s1[i+2].split(": ")[1];
                    String city = s1[i+3].split(": ")[1];
                    String state = s1[i+4].split(": ")[1];
                    String post = s1[i+5].split(": ")[1];
                    adres = new Address(street, city, state, post);
                    i+=5;
                    break;
                case "phoneNumber":
                    if(s1[i+3].split(":")[1].contains("fax"))
                        fax = new PhoneNumber("fax", s1[i+3].split(": ")[1]);
                    else if(s1[i+3].split(":")[1].contains("home"))
                        phone = new PhoneNumber("home", s1[i+3].split(": ")[1]);
                    break;
                case "      type":
                    if(s1[i].split(":")[1].contains("fax"))
                        fax = new PhoneNumber("fax", s1[i+1].split(": ")[1]);
                    else if(s1[i].split(":")[1].contains("home"))
                        phone = new PhoneNumber("home", s1[i+1].split(": ")[1]);
                    break;
            }
        }
//        firstName = s1[0].split(": ")[1];
//        lastName = s1[1].split(": ")[1];
//        age = s1[2].split(": ")[1];

//        adres = new Address(s1[3].split(":")[2], s1[4].split(": ")[1], s1[5].split(": ")[1], s1[6].split(": ")[1]);

//        phone = new PhoneNumber(s1[7].split(": ")[1], s1[8].split(": ")[1]);
//        fax = new PhoneNumber(s1[9].split(": ")[1], s1[10].split(": ")[1]);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getAdres() {
        return "" + adres.getStreet() + ", "
                + adres.getCity() + ", "
                + adres.getState() + ", "
                + adres.getPostal();
    }

    public String getNumber() {
        return phone.getNumber();
    }

    public String getFax() {
        return fax.getNumber();
    }

    private class Address
    {
        protected String street;
        protected String city;
        protected String state;
        protected String postal;

        public Address(String str, String c, String st, String p)
        {
            this.street = str;
            this.city = c;
            this.state = st;
            this.postal = p;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getPostal() {
            return postal;
        }
    }

    private class PhoneNumber
    {
        protected String type;
        protected String number;

        public PhoneNumber(String t, String n)
        {
            this.type = t;
            this.number = n;
        }

        public String getNumber() {
            return number;
        }

        public String getType() {
            return type;
        }
    }
}

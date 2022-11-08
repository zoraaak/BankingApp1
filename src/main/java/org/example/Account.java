package org.example;

public class Account {
    private String firstName;
    private String lastName;
    private String pesel;
    private String login;
    private int pin;
    private String accountNumber;
    private double balance;

    Account(String firstName, String lastName, String pesel, String login, int pin, String accountNumber,
            double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.login = login;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    // zwraca login
    public String getLogin() {
        return login;
    }

    // zwraca pin
    public int getPin() {
        return pin;
    }

    // zwraca pierwsze imie klienta
    public String getFirstName() {
        return firstName;
    }

    // zwraca nazwisko klienta
    public String getLastName() {
        return lastName;
    }

    // zwraca pesel klienta
    public String getPesel() {
        return pesel;
    }

    // zwraca numer konta klienta
    public String getAccountNumber() {
        return accountNumber;
    }

    // zwraca stan konta klienta
    public double getBalance() {
        return balance;
    }

    // dodaje podana kwotę (amount) do stanu konta klienta
    public void addBalance(double amount) {
        this.balance = balance + amount;
    }

    // odejmuje podaną kwotę (amount) od stanu konta klienta
    public void subtractBalance(double amount) {
        this.balance = balance - amount;
    }

}
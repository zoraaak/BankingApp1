package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account account1=new Account("Jan","Mariuszek","123456789", "AdAd","12345678900",1000000,1234);
        Scanner sc=new Scanner(System.in);

        System.out.println("Witam w naszym banku SDA Futres");
        System.out.println("Użytkowniku wpisz login");
        String login=sc.next();
        System.out.println("podaj kod PIN");
        int pin=sc.nextInt();



    }

}
package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // tworzymy nowego klienta
        Account account1 = new Account("Jan", "Kowalski", "874545211111", "jkowalski", 1234, "1234567890", 1000.00);

        // tworzymy skaner do przyjmowania danych od uzytkownika aplikacji
        Scanner sc = new Scanner(System.in);

        // powitanie
        System.out.println("Witamy w naszym banku! ");

        // tworzymy zmienna do sprawdzenia poprawnosci loginu
        boolean isLoginValid = false;
        // robimy petle do-while w przypadku wpisania zlego loginu - petla odpali sie co najmniej 1 raz
        do {
            // prosimy o wpisanie loginu
            System.out.println("Wpisz login: ");
            // pobieramy login od uzytkownika i zapisujemy w zmiennej 'login'
            String login = sc.next();

            // sprawdzamy czy wpisany login zgadza sie z loginem utworzonego klienta - account1
            if (login.equals(account1.getLogin())) {
                // jeśli login się zgadza, wyświetlamy komunikat i zmienna do sprawdzenia loginow zmienia sie na TRUE
                System.out.println("Poprawny login\n");
                isLoginValid = true;
            }
            else {
                // jesli login sie nie zgadza wyswietla sie komunikat i petla wraca na poczatek - mozemy wpisac
                // login ponownie
                System.out.println("Niepoprawny login");
            }
            // petla bedzie KONTYNUOWANA, czyli wroci do poczatku, jesli login bedzie nieprawidlowy - czyli false,
            // zapis na dole jest tożsamy
        } while (!isLoginValid);

        // robimy zmienna do sprawdzenia poprawnosci pinu
        boolean isPinValid = false;
        // dodajemy zmienna z liczba prob wpisania pinu
        int pinAttempt = 3;
        // robimy petle do-while, zeby odpalila sie przynajmniej raz
        do {
            // prosimy o podanie pinu
            System.out.println(("Wpisz pin: "));
            // pobieramy pin wpisany przez uzytkownika jako zmienna 'pin'
            int pin = sc.nextInt();
            // sprawdzamy czy pin jest poprawny
            if (pin == account1.getPin()) {
                // jesli pin poprawny, wyswietlamy komunikat i zmieniamy zmienna walidacji pinu na TRUE,
                // wiec petla sie konczy - warunek po while na dole petli jest nieprawdziwy
                System.out.println("Poprawny pin\n");
                isPinValid = true;
            }
            // jesli pin jest niepoprawny
            else {
                // zmniejszamy liczbe mozliwych prob wpisania pinu o 1 mniej
                pinAttempt--;
                // jesli nadal mamy jakies proby wpisania pinu do wykorzystania to podajemy liczbe pozostalych prob i
                // petla wraca do poczatku, mozna wpisac pin ponownie
                if (pinAttempt > 0) {
                    System.out.println("Niepoprawny pin, pozostało " + pinAttempt + " prób");
                }
                // jesli nie mamy juz prob do wpisania pinu aplikacja sie wylacza
                if (pinAttempt == 0) {
                    System.out.println("Wykorzystałeś limit prób, do widzenia!");
                    System.exit(0);
                }
            }
            // warunkiem KONTYNUACJI petli jest isPinValid = false, zapis ponizej jest tożsamy,
            // czyli jesli pin jest poprawny (true), petla sie zakonczy
        } while (!isPinValid);

        // definiujemy zmienna do wyboru w menu, na razie bez przypisanej wartosci
        int choice;
        do {
            // wyswietla sie menu
            System.out.println("MENU");
            System.out.println("1. Wpłata środków \n2. Wypłata środków \n3. Sprawdź saldo \n4. Weź kredyt \n5. Wyjdź");
            System.out.println("Twój wybór: ");
            // dokonujemy wyboru, przypisujemy jakas wartosc do wczesniej zdefiniowanej zmiennej 'choice'
            choice = sc.nextInt();

            // switch sprawdza nasz wybor i w zaleznosci od tego co wybierzemy odpala inne linie kodu
            switch (choice) {
                case 1:
                    System.out.println("Stan Twojego konta wynosi " + account1.getBalance() + " zł");
                    System.out.println("Podaj kwotę, którą chcesz wpłacić: ");
                    // defniujemy zmienna depoAmount, gdzie podajemy kwote ktora chcemy wplacic
                    double depoAmount = sc.nextDouble();
                    // odpalamy metode addBalance, ktora zmienia stan konta o podana wyzej kwote - dodaje
                    account1.addBalance(depoAmount);
                    System.out.println("Operacja wykonana poprawnie");
                    System.out.println("Twój stan konta wynosi " + account1.getBalance() + " zł\n");
                    break;
                case 2:
                    System.out.println("Stan Twojego konta wynosi " + account1.getBalance() + " zł");
                    System.out.println("Podaj kwotę do wypłaty: ");
                    // defniujemy zmienna withdrawAmount, gdzie podajemy kwote ktora chcemy wyplacic
                    double withdrawAmount = sc.nextDouble();
                    // odpalamy metode subtractBalance, ktora zmienia stan konta o podana wyzej kwote - zmniejsza
                    account1.subtractBalance(withdrawAmount);
                    System.out.println("Operacja wykonana poprawnie");
                    System.out.println("Twój stan konta wynosi " + account1.getBalance() + " zł\n");
                    break;
                case 3:
                    // wyswietla stan konta
                    System.out.println("Stan Twojego konta wynosi " + account1.getBalance() + " zł\n");
                    break;
                case 4:
                    System.out.println("Podaj kwotę kredytu, o którą chciałbyś się ubiegać: ");
                    // defniujemy ile chcemy kredytu
                    double creditAmount = sc.nextDouble();
                    // jesli kwota o ktora sie ubiegamy jest wyzsza od 1/10 stanu konta to aplikacja nie udziela kredytu
                    if (creditAmount > (account1.getBalance() / 10)) {
                        System.out.println("Nie stać Cię na tak wysoki kredyt. Maksymalna kwota jaką możemy Ci zaproponować" +
                                " to " + (account1.getBalance() / 10) + " zł, biedaku\n");
                    }
                    // jesli stac nas na kredyt, kwota kredytu jest dodawana do stanu konta
                    else {
                        account1.addBalance(creditAmount);
                        System.out.println("Przyznano kredyt, aktualny stan Twojego konta wynosi " + account1.getBalance()
                                + " zł\n");
                    }
                    break;
                case 5:
                    System.out.println("Dziękujemy za korzystanie z usług naszego banku, zapraszamy ponownie! ");
                    System.exit(0);
            }
            //tak dlugo jak choice NIE JEST równy 5, petla bedzie sie odpalac
        } while (choice != 5);
    }
}
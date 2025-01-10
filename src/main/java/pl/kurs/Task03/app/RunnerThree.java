package pl.kurs.Task03.app;

import pl.kurs.Task03.exceptions.InvalidPeselException;

import static pl.kurs.Task03.services.TaskThreeService.findDateOfBornFromPesel;
import static pl.kurs.Task03.services.TaskThreeService.getListOf5BiggestElements;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RunnerThree {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println("Imię ma " + name.length() + " znaków.");
        }


        System.out.println("Podaj swój pesel");
        String pesel = scanner.next();
        try {
            LocalDate dateOfBornFromPesel = findDateOfBornFromPesel(pesel);
            System.out.println("Urodziłeś się " + dateOfBornFromPesel);
        } catch (InvalidPeselException e) {
            e.printStackTrace();
        }
        scanner.close();

        List<Integer> integerList = List.of(-2, 0, 5, 10, 25, 123, -1, 0, 200);
        System.out.println(getListOf5BiggestElements(integerList));

    }


}



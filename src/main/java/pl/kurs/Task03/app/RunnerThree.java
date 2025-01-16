package pl.kurs.Task03.app;

import static pl.kurs.Task03.services.TaskThreeService.getListOf5BiggestElements;
import static pl.kurs.Task03.services.TaskThreeService.lengthOfName;
import static pl.kurs.Task03.services.TaskThreeService.dateOfBornFromPesel;
import java.util.*;

public class RunnerThree {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię");
        String name = scanner.nextLine().trim();
        System.out.println("Imię ma " + lengthOfName(name) + " znaków.");


        System.out.println("Podaj swój pesel");
        String pesel = scanner.nextLine().trim();
        System.out.println("Urodziłeś się " + dateOfBornFromPesel(pesel));
        scanner.close();

        List<Integer> integerList = Arrays.asList(-124, 0, 5, 10, 1, 3, 125, null);
        List<Integer> integerList2 = Arrays.asList(-124, 0, 5, null, null);
        System.out.println(getListOf5BiggestElements(integerList2));

    }




}



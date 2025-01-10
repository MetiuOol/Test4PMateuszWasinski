package pl.kurs.Task03.services;

import pl.kurs.Task03.exceptions.InvalidPeselException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskThreeService {

    public TaskThreeService() {
    }

    public static LocalDate findDateOfBornFromPesel(String pesel) throws InvalidPeselException {
        LocalDate dateOfBorn;
        if (pesel.length() != 11) {
            throw new InvalidPeselException("Podaj poprawny pesel");
        }

        int rok = Integer.parseInt(pesel.substring(0, 2));
        int miesiac = Integer.parseInt(pesel.substring(2, 4));
        int dzien = Integer.parseInt(pesel.substring(4, 6));

        if (miesiac > 20) {
            dateOfBorn = LocalDate.of(2000 + rok, miesiac - 20, dzien);
        } else {
            dateOfBorn = LocalDate.of(1900 + rok, miesiac, dzien);
        }
        return dateOfBorn;
    }

    public static List<Integer> getListOf5BiggestElements(List<Integer> integerList) {
        if (integerList == null || integerList.size() < 5) {
            return new ArrayList<>();
        }
        return integerList.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }



}

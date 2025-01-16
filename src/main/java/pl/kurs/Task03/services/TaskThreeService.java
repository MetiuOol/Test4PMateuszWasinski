package pl.kurs.Task03.services;

import pl.kurs.Task03.exceptions.InvalidPeselException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskThreeService {

    public TaskThreeService() {
    }

    public static int lengthOfName(String name) {
        return Optional.ofNullable(name.isBlank() ? null : name)
                .map(String::length)
                .orElse(0);
    }

    public static LocalDate dateOfBornFromPesel(String pesel) {
        return Optional.ofNullable(pesel.isBlank() ? null : pesel)
                .filter(x -> x.matches("\\d{11}"))
                .map(TaskThreeService::findDateOfBornFromPesel)
                .orElseThrow(() -> new InvalidPeselException("Nieprawidłowy pesel"));
    }

    public static LocalDate findDateOfBornFromPesel(String pesel) throws InvalidPeselException {
        LocalDate dateOfBorn;
        if (pesel.length() != 11) {
            throw new InvalidPeselException("Podaj poprawny pesel");
        }

        int year = Integer.parseInt(pesel.substring(0, 2));
        int month = Integer.parseInt(pesel.substring(2, 4));
        int day = Integer.parseInt(pesel.substring(4, 6));

        if (month > 20) {
            dateOfBorn = LocalDate.of(2000 + year, month - 20, day);
        } else {
            dateOfBorn = LocalDate.of(1900 + year, month, day);
        }
        return dateOfBorn;
    }

    public static List<Integer> getListOf5BiggestElements(List<Integer> integerList) {
        return Optional.ofNullable(integerList)
                .map(x -> x.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()))
                .filter(x -> x.size() >= 5)
                .map(x -> x.stream()
                        .sorted(Comparator.comparing(Integer::intValue).reversed())
                        .limit(5)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

    }


}

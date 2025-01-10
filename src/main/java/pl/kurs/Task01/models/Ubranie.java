package pl.kurs.Task01.models;

import java.util.Comparator;
import java.util.Objects;

public class Ubranie implements Comparable<Ubranie> {
    private String name;
    private Size size;
    private double prize;
    private static Kryterium aktualneKryterium = Kryterium.ROZMIAR;
    ;

    public Ubranie(String name, Size size, double prize) {
        this.name = name;
        this.size = size;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public double getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubranie ubranie = (Ubranie) o;
        return Double.compare(ubranie.prize, prize) == 0 && Objects.equals(name, ubranie.name) && size == ubranie.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, prize);
    }


    @Override
    public String toString() {
        return "Ubranie{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", prize=" + prize +
                '}';
    }

    public static void ustalKryteriumSortowania(Kryterium kryterium) {
        aktualneKryterium = kryterium;
    }

    @Override
    public int compareTo(Ubranie o) {
        return switch (aktualneKryterium) {
            case WARTOSC -> Double.compare(this.prize, o.prize);
            case ROZMIAR -> this.size.compareTo(o.size);
        };
    }
}

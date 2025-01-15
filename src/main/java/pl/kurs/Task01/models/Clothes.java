package pl.kurs.Task01.models;

import java.util.Objects;

public class Clothes implements Comparable<Clothes> {
    private String name;
    private Size size;
    private double prize;
    private static Criterion currentCriterion = Criterion.SIZE;
    ;

    public Clothes(String name, Size size, double prize) {
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
        Clothes clothes = (Clothes) o;
        return Double.compare(clothes.prize, prize) == 0 && Objects.equals(name, clothes.name) && size == clothes.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, prize);
    }


    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", prize=" + prize +
                '}';
    }

    public static void setSortingCriterion(Criterion criterion) {
        currentCriterion = criterion;
    }

    @Override
    public int compareTo(Clothes o) {
        return switch (currentCriterion) {
            case VALUE -> Double.compare(this.prize, o.prize);
            case SIZE -> this.size.compareTo(o.size);
        };
    }
}

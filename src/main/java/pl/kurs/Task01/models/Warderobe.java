package pl.kurs.Task01.models;

import java.util.*;

public class Warderobe implements Iterable<Clothes> {
    private final List<Clothes> warderobe;
    private Clothes clothes;

    public Warderobe() {
        this.warderobe = new ArrayList<>();
    }

    public List<Clothes> getClothes() {
        return this.warderobe;
    }

    public void addClothes(Clothes... clothes){
        warderobe.addAll(Arrays.asList(clothes));
    }


    @Override
    public Iterator<Clothes> iterator() {
        return warderobe.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warderobe ubranies = (Warderobe) o;
        return Objects.equals(warderobe, ubranies.warderobe) && Objects.equals(clothes, ubranies.clothes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warderobe, clothes);
    }



}

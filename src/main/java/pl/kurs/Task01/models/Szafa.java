package pl.kurs.Task01.models;

import java.util.*;

public class Szafa implements Iterable<Ubranie> {
    private final List<Ubranie> szafa;
    private Ubranie ubranie;

    public Szafa() {
        this.szafa = new ArrayList<>();
    }

    public List<Ubranie> getUbrania() {
        return this.szafa;
    }

    public void dodajUbranie(Ubranie... ubrania){
        szafa.addAll(Arrays.asList(ubrania));
    }


    @Override
    public Iterator<Ubranie> iterator() {
        return szafa.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Szafa ubranies = (Szafa) o;
        return Objects.equals(szafa, ubranies.szafa) && Objects.equals(ubranie, ubranies.ubranie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(szafa, ubranie);
    }



}

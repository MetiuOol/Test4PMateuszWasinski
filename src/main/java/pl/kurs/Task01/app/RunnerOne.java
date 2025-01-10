package pl.kurs.Task01.app;

import pl.kurs.Task01.models.Kryterium;
import pl.kurs.Task01.models.Size;
import pl.kurs.Task01.models.Szafa;
import pl.kurs.Task01.models.Ubranie;

import java.util.Collections;


public class RunnerOne {
    public static void main(String[] args) {
        Szafa szafa = new Szafa();

        szafa.dodajUbranie(
                new Ubranie("Koszula", Size.XL, 150.00),
                new Ubranie("Majtki", Size.M, 30.0),
                new Ubranie("Spodnie", Size.L, 200));

        for (Ubranie u: szafa){
            System.out.println(u);
        }

        Ubranie max = Collections.max(szafa.getUbrania());
        System.out.println(max);
        Ubranie.ustalKryteriumSortowania(Kryterium.WARTOSC);
        Ubranie najdrozsze = Collections.max(szafa.getUbrania());
        System.out.println(najdrozsze);
        Ubranie.ustalKryteriumSortowania(Kryterium.ROZMIAR);
        System.out.println(max);

    }



}

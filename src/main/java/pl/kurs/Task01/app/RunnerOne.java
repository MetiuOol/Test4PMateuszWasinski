package pl.kurs.Task01.app;

import pl.kurs.Task01.models.Criterion;
import pl.kurs.Task01.models.Size;
import pl.kurs.Task01.models.Warderobe;
import pl.kurs.Task01.models.Clothes;

import java.util.Collections;


public class RunnerOne {
    public static void main(String[] args) {
        Warderobe warderobe = new Warderobe();

        warderobe.addClothes(
                new Clothes("Koszula", Size.XL, 150.00),
                new Clothes("Majtki", Size.M, 30.0),
                new Clothes("Spodnie", Size.L, 200));

        for (Clothes u: warderobe){
            System.out.println(u);
        }

        Clothes max = Collections.max(warderobe.getClothes());
        System.out.println(max);
        Clothes.setSortingCriterion(Criterion.VALUE);
        Clothes expensive = Collections.max(warderobe.getClothes());
        System.out.println(expensive);
        Clothes.setSortingCriterion(Criterion.SIZE);
        System.out.println(max);

    }



}

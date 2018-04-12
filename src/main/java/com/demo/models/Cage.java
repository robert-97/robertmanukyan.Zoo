package com.demo.models;

/**
 * Created by robert.manukyan on 11.04.2018.
 */
public class Cage {
    private int cageNumber ;
    private Animal[] animals ;

    public Animal[] getAnimalas() {
        return animals;
    }

    public void setAnimalas(Animal[] animals) {
        this.animals = animals;
    }

    public Cage(int cageNumber) {
        this.cageNumber = cageNumber;
    }

    public int getCageNumber() {
        return cageNumber;
    }

    public void setCageNumber(int cageNumber) {

        this.cageNumber = cageNumber;
    }
}

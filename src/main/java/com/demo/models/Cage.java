package com.demo.models;

/**
 * Created by robert.manukyan on 11.04.2018.
 */
public class Cage {
    private int cageNumber;
    private int cageNumberID;


    public Cage(int cageNumberID, int cageNumber) {

        this.cageNumber = cageNumber;
        this.cageNumberID = cageNumberID;
    }

    public void setCageNumberID(int cageNumberID) {
        this.cageNumberID = cageNumberID;
    }

    public int getCageNumberID() {

        return cageNumberID;
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

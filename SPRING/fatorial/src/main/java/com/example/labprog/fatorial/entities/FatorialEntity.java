package com.example.labprog.fatorial.entities;

public class FatorialEntity {

    int number;
    double fatNumber;

    public FatorialEntity(int number) {
        this.number = number;
        this.fatNumber = calc(number);
    }

    public double getFatNumber() {
        return fatNumber;
    }

    public void setFatNumber(double fatNumber) {
        this.fatNumber = fatNumber;
    }        

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    double calc(int number) {
        double fatorial = 1;
        for (int i = 1; i <= number; i++) {
            fatorial *= i;
        }
        return fatorial;
    }
}


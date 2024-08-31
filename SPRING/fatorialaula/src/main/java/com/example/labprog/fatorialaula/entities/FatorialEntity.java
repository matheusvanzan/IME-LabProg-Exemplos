package com.example.labprog.fatorialaula.entities;

public class FatorialEntity {

    Integer number;
    Integer fatorialNumber;

    public FatorialEntity(Integer number) {
        this.number = number;
        this.fatorialNumber = fat(number);
    }

    private Integer fat(Integer number) {
        Integer factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFatorialNumber() {
        return fatorialNumber;
    }

    public void setFatorialNumber(Integer fatorialNumber) {
        this.fatorialNumber = fatorialNumber;
    }

}

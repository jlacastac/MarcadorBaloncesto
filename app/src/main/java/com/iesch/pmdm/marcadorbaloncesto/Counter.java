package com.iesch.pmdm.marcadorbaloncesto;

public class Counter {

    private int number;

    public Counter(int start) {
        number = start;
    }

    public void add(int number) {
        this.number += number;
    }

    public void sub(int number) {
        this.number -= number;
    }

    public int getNumber() {
        return number;
    }

    public void reset() {
        number = 0;
    }
}

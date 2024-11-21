package com.monk;

import java.util.concurrent.ThreadLocalRandom;

public class Data implements Cloneable {

    private int number1;
    private int number2;
    private long number3;
    private long number4;
    private float number5;
    private float number6;
    private double number7;
    private double number8;

    public Data() {
        number1 = ThreadLocalRandom.current().nextInt();
        number2 = ThreadLocalRandom.current().nextInt();
        number3 = ThreadLocalRandom.current().nextLong();
        number4 = ThreadLocalRandom.current().nextLong();
        number5 = ThreadLocalRandom.current().nextInt();
        number6 = ThreadLocalRandom.current().nextInt();
        number7 = ThreadLocalRandom.current().nextDouble();
        number8 = ThreadLocalRandom.current().nextDouble();
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public long getNumber3() {
        return number3;
    }

    public void setNumber3(long number3) {
        this.number3 = number3;
    }

    public long getNumber4() {
        return number4;
    }

    public void setNumber4(long number4) {
        this.number4 = number4;
    }

    public float getNumber5() {
        return number5;
    }

    public void setNumber5(float number5) {
        this.number5 = number5;
    }

    public float getNumber6() {
        return number6;
    }

    public void setNumber6(float number6) {
        this.number6 = number6;
    }

    public double getNumber7() {
        return number7;
    }

    public void setNumber7(double number7) {
        this.number7 = number7;
    }

    public double getNumber8() {
        return number8;
    }

    public void setNumber8(double number8) {
        this.number8 = number8;
    }

}

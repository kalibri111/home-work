package com.sbrf.reboot.calculator;
import com.sbrf.reboot.Main;

import java.util.*;

public class Calculator {
    public int getAddition(int first, int second) {
        return first + second;
    }


    public int getSubtraction(int first, int second) {
        return first - second;
    }

    public int getMultiplication(int first, int second) {
        return first * second;
    }

    public int getDivision(int first, int second) {
        return first / second;
    }

    public double getSin(double angle) {
        return Math.sin(angle);
    }

    public double getCos(double angle) {
        return Math.cos(angle);
    }

    public double getTan(double angle) {
        return Math.tan(angle);
    }
}

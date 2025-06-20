package com.mycompany.property.management.controller;

public class CalculatorMain {

    public static void main (String[] args){
        calculatorController cc = new calculatorController();
        Double result = cc.add(4.5, 8.5);
          System.out.print(result);
    }

}

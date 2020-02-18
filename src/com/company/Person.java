package com.company;

public class Person {

    private String name;
    private String symbol;

    //constructor
    public Person(String name, String symbol) {
        this.name = name;
        this.symbol=symbol;
    }
    //Getter for name
    public String getName() {
        return name;
    }
    //Getter for symbol
    public String getSymbol()
    {
        return symbol;
    }

}

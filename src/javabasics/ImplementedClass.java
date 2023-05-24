package javabasics;

public class ImplementedClass implements WorkwithInterface{


    public static void main(String[] args) {
        //Create interface object for this class to run the methods

        WorkwithInterface obj = new ImplementedClass(); // Creating object to call methods implemented from interface
        obj.redSignal();
        obj.yellowSignal();
        obj.greenSignal();

        ImplementedClass obj1 = new ImplementedClass(); //Creating obj to call method created only for this class
        obj1.greenSignal();
        obj1.pedestrainRule();
    }

    public void pedestrainRule(){

        System.out.println("Red light with man symbol should STOP walking/crossing the road");
        System.out.println("green light with man symbol should Start walking/crossing the road");

    }
    @Override
    public void redSignal() {
        System.out.println("Red light - STOP");
    }

    @Override
    public void greenSignal() {
        System.out.println("Green light - GO");

    }

    @Override
    public void yellowSignal() {
        System.out.println("Yellow light - Wait");

    }
}

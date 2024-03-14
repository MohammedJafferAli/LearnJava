package oops.inhertanceconcept;

/*
* Super keyword work with variables, methods and constructor
*super.variable name will get the parent class variable
* super.methodName() will get call the parent class method
* super() will call the parent class constructor
*
* */

class Vehicle
{

    int maxspeed = 120;
}
class SuperBike extends Vehicle{

    int maxspeed = 180;

    void checkTheSpeed()
    {
        System.out.println("Max speed of the superbike is "+ maxspeed);
        System.out.println("Max speed in indian highway is "+ super.maxspeed);
    }
}

public class SuperKeywordVariable {
    public static void main(String[] args) {
        SuperBike apache = new SuperBike();
        apache.checkTheSpeed();
    }
}

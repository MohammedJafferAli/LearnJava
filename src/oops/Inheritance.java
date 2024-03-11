package oops;

public class Inheritance {

    public static void main(String[] args) {


        //To inherit the Parent class methods in child class use extends keyword
        //Create a child class obj to call the methods and properties in both child and parent class

        ChildClass cObj = new ChildClass();
        cObj.sumMethod(10,15);
        cObj.subMethod(20, 40);
        cObj.mulMethod(10, 10);

        ParentClass pObj = new ParentClass();
        pObj.subMethod(10,5);
        pObj.sumMethod(80,2);
    }
}

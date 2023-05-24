package javabasics;

public class WorkWithClasses {

    public static void main(String[] args) {

        System.out.println("I am in child class");

        ParentClass obj = new ParentClass();// new key allocates a memory for object to call methods from Parent class
        obj.validateTitle("HomePage");//Calling void type method

        String title = obj.printTitle("LoginPage");
        System.out.println(title); // Calling method with a return type as String

    }

}

package oops.inhertanceconcept;

/* Rules to use the inheritance
* 1. Child class can inherit the properties of parent class (variables and methods)
* 2. Create object for the child class,in order to call both parent and child class stuff
* 3. Types of inheritance - Single, Multi-level, Hierarchy and Multiple (not possible using class, but with the interface
* 4. Single - one parent, one child
* 5. Multi-level - GrandParent, Parent and Child
* 6. Hierarchy - One pareny multiple childen
* 7. Multiple - one childern will have properties of two parent classes
*
* */

class Parent{

    int age;
    String name;
    String surname;
    void eatingWithSpoon()
    {
        System.out.println(" I eat food with spoon ");
    }

}
class Child extends Parent{
    void favoriteSubject(String subject)
    {
        System.out.print(subject);
    }
}

public class SingleInheritance { //There should be one only public class allowed in one class
    public static void main(String[] args) {

    //Create an object for the child class so extended class properties can be used in the main
        Child child1 = new Child();
        child1.age = 12;
        Parent parent = new Parent();
        parent.age = 36;
        child1.name = "Anil Kumar";
        parent.name = "Mukesh Kumar";
        child1.surname = parent.name;

        System.out.println("I am "+ child1.name + " son of "+ parent.name + " And I am "+ child1.age + " years old.");
        System.out.print("My favourite subject is ");
        child1.favoriteSubject("Maths");

    }

}

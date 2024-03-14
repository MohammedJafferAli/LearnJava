package oops.inhertanceconcept;


class Animal {

    String colour;

    void setColour(String color)
    {
        colour = color;
        System.out.println(colour);
    }
  final void legs(int nooflegs)
    {
        System.out.println(nooflegs);
    }

}
class Lion extends Animal{

    void legs(int nooflegs)
    {
        System.out.println(nooflegs * 2);
    }
}

public class FinalKeyMethod {

    public static void main(String[] args) {

    }
}

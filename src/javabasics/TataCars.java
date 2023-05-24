package javabasics;

public class TataCars extends ParentCarClass{


    public void musicSystem(){
        System.out.println("Harman Audio system with 5 speakers");
    }

    public void carColor(){
        System.out.println(color);
    }

    public static void main(String[] args) {

        TataCars arian = new TataCars();
        arian.carColor();
        arian.musicSystem();
        arian.fuelType("Petrol");
    }

}

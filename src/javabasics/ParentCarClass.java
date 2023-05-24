package javabasics;

public class ParentCarClass {

    String color = "RED";
    public void gearSystem(String gearBox){
        System.out.println("Create a car using "+ gearBox+ "type");
    }
    public void breakingSystem(String breakType){
        System.out.println("Create a car using "+ breakType+ "type");
    }

    public void fuelType(String fuel){
        System.out.println("Create a car using "+ fuel+ "type");
    }

}

package oops;

public class Encapsulation {

    //In Java classes support the encapsulation -
    //To Achieve this use private access modifier on variables and use public getter and setter methods to get thev values


    private int num ;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

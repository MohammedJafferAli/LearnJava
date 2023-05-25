package oops;

public class NestedLoops {

    public static void main(String[] args) {


        for (int loop1=0;loop1<10;loop1++){

            for (int loop2=0;loop2<3;loop2++){

                System.out.println("For every Outerloop "+loop1+" execute innner loop "+ loop2);

            }
        }
    }
}

package javabasics;

public class SingleDArray {

    public static void main(String[] args) {


        //Two ways to create a single D array

        int array[] = new int[4];
        array[0]= 10;
        array[1]=20;
        array[2]=30;
        array[3]= 33;

        //print specific index
        System.out.println(array[2]);


        int array2[] = {1,5,6,10,12};

        //print all the element in the array

        for (int i=0;i<array.length;i++){

            System.out.println(array[i]);
        }
        for (int i=0;i<array2.length;i++){

            System.out.println(array2[i]);
        }
    }
}

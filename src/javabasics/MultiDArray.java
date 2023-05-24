package javabasics;

public class MultiDArray {


    public static void main(String[] args) {



        int array[][] = new int[2][2];
        array[0][0]= 10;
        array[0][1]= 30;
        array[1][0]= 16;
        array[1][1]= 17;
        //print particular index
        //System.out.println(array[1][1]);

        //Alternate approach

        int array1[][] = {{1,2,4},{4,5,6}};

        for (int i =0;i<array1.length;i++){//Loop all the rows in matrix
            for(int j=0;j<array1[i].length;j++){ //loop all the elements in the row

                System.out.print(array1[i][j]+" ");
            }
            System.out.println(" ");

        }

    }
}

package numberpattern;

public class Numberpyramid1 {
    /*
    * 1
    * 2 3
    * 4 5 6
    * 7 8 9 10
    *
    * */
    public static void main(String[] args) {

        int temp =1;

        for (int i = 1;i<=4;i++){
            for (int j=0;j<i;j++){  //Alternate approach j=1;j<=i
                System.out.print(temp);
                System.out.print("\t");
                temp++;
            }System.out.println("");
        }

    }
}

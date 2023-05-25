package numberpattern;

/*
* 1
* 1 2
* 1 2 3
* 1 2 3 4
* */

public class NumPryamid2 {
    public static void main(String[] args) {

        for (int i =1; i<=4;i++){
            for(int j = 1; j<=i;j++){
                System.out.print(j);
                System.out.print("\t");
            }System.out.println("");
        }



        /*
        * 3
        * 6 9
        * 12 15 18
        * */
        int temp =3;
        for(int i =1;i<=3;i++){
            for(int j=1;j<=i;j++){
                System.out.print(temp);
                System.out.print("\t");
                temp += 3;
            }System.out.println("");
        }
    }
}

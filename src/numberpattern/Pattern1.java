package numberpattern;

/*
* 1 2 3 4
* 5 6 7
* 8 9
* 10
* */
public class Pattern1 {
    public static void main(String[] args) {
        int k = 1;

        for(int i= 0; i<4;i++){ //Define how many outer loop has to execute ex.4 times

            for(int j=0;j<4-i;j++){ //define how many inner loop has to execute ex.4 times ... after every outer loop completion the size should reduce by 1 or
                //reduce i times from the first iteration
                System.out.print(k); // to print 1 to 10 use temp variable and increment it...
                System.out.print("\t"); // spacing
                k++;
            } System.out.println(""); //new line after every inner loop execute
        }




    }
}

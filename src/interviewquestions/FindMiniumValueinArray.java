package interviewquestions;

public class FindMiniumValueinArray {

    /*Goal: Find the minium value from the given array
    * 4 5 9
    * 6 2 3
    * 1 8 7
    * */
    public static void main(String[] args) {

        // initialise the array using array literal
        int givenArray[][] = {{4 , 5 , 9},{6, 2, 3},{1, 8, 7}};
        int minValue = givenArray[0][0]; // Assume the first value is the minimum value

        for (int row = 0;row<3;row++)
        {
            for(int column=0;column<3;column++)
            {
                if(givenArray[row][column]<minValue)
                {
                    minValue = givenArray[row][column];
                }
            }
        }
        System.out.println(minValue); //Assume it found "1" in the 3rd iteration but loop will run till the last element
    }
}

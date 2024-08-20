package interviewquestions;

public class FindMaxValueColumn {

    /*Goal: Get the minimum value from the array then find largest value in the same column
     4 5 9
     6 2 3
     1 8 7
     */
    public static void main(String[] args) {

        int givenArray[][] = {{4 , 5 , 9},{6, 2, 3},{1, 8, 7}}; // change the minium values in the array and try again {{4 , 5 , 9},{6, 12, 3},{11, 8, 7}};
        int minValue = givenArray[0][0]; // Assume the first value is the minimum value
        int maxColValue = 0;
        int minValColum =0;

        for (int row = 0;row<3;row++)
        {
            for(int column=0;column<3;column++)
            {
                if(givenArray[row][column]<minValue)
                {
                    minValue = givenArray[row][column];
                    minValColum = column;

                }
            }
        }
        for (int row = 0;row<3;row++)
        {
            if(givenArray[row][minValColum]>maxColValue)
            {
                maxColValue= givenArray[row][minValColum];
            }
        }
        System.out.println("Minimum value in the given array is "+minValue);
        System.out.println("Largest number found in the column of minimum value is "+maxColValue);
    }
}

package javabasics;

public class StaticDemo {


    static String varEmployer;
    String empName;
    int empID;

    /* Rules to use the static stuff in the java program
    * 1. static keyword should be used in front of the variables and methods.
    * 2. main is also the static method. JVM always look for void main(String args[])
    * 3. Static method(s) can access onlythe static stuff (methods and variables)
    * 4. Static method can also access the non-static stuff by creating object
    * 5. non-static method can access both static and non-static
    * 6. in order to use the static out side of the class then use syntax ClassName.staticStuff
    *
    * */

    static void printEmployer(String varEmployer)

    {
        System.out.println(varEmployer);
    }

    void printEmployeeDetails(String empName, int empID)
    {
        this.empName = empName;
      this.empID = empID;

      System.out.println(empID);
      System.out.println(empName);
    }

    public static void main(String[] args) {

        printEmployer("TechMahindra"); //#3
        StaticDemo sd = new StaticDemo();
        sd.printEmployeeDetails("Mohammed JafferAli",581700);


    }
}

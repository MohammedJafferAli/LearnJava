package javabasics;

public class ParentClass {

    public void validateTitle(String pageName){

        System.out.println(pageName + " title verified successfully.");
    }

    public String printTitle(String pageName){

        //driver.getTItle();
        return "Title of the page should be "+pageName;
    }


}

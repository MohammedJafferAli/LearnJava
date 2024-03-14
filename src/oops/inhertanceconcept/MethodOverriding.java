package oops.inhertanceconcept;

/* Rules to use the method overriding
1. Method overriding is possible only when a class inherit other class
2. Possible in all the inheritance method
3. Method definition should be as same as the parent class method
4. Implementation should be different
5. Method over loading is also possible with inherited but considered as polymorphism
6. If the method is called by child class object then chile class method will be executed
7. else parent class method will be executed
*
* */


class Login
{
    void signIn(String location, String pagename)
    {
        System.out.println(" Click on login from " + location);
        System.out.println(" I should redirect to "+ pagename);

    }

}
class Signup extends Login{

    void signIn(String location, String pagename)
    {
        System.out.println(" I can sign up from "+ pagename + " page "+" by click on "+ location);


    }

}
public class MethodOverriding {
    public static void main(String[] args) {

        //Create a child class obj to call method
        Signup signup = new Signup();
        signup.signIn("Already have account", "Sign-up");
        //To call parent class method create paren class object
        Login loginobj = new Login();
        loginobj.signIn("global nav header", "Log-in");

    }
}

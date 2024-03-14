package oops.inhertanceconcept;



class People
{
    void basicNeeds()
    {
        System.out.println("Basic needs of people are Oxygen and Water");
    }
}
class UrbanPeople extends People{

    void basicNeeds()
    {
        System.out.println("Urban people need few extra things to live");
    }
    void checkTheNeeds()
    {
        super.basicNeeds();
        basicNeeds();
    }

}
public class SuperKeyMethods {
    public static void main(String[] args) {

        UrbanPeople erodian = new UrbanPeople();
        erodian.checkTheNeeds();

    }
}

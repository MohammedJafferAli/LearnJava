package oops.inhertanceconcept;

/*final*/ class Sun
{
    void noOfPlanet(){
        System.out.println(8);
    }
    void radiation()
    {
        System.out.println("Sun's radiation level is ,350W per square metre ");
    }
}

class earth extends Sun{

    void noOfMoon(int count)
    {
        System.out.println("No of Moons revolving the earth is "+ count);
    }
}
public class FinalKeyClass {
}

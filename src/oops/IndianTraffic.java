package oops;

public class IndianTraffic implements CentralTraffic{
    @Override
    public void goGreen() {
        System.out.println("Go Green implementation");
    }

    @Override
    public void redStop() {
        System.out.println("Red Stop implmentation");

    }

    @Override
    public void flashYellow() {
        System.out.println("Flashing yellow implmentation");
    }
    public void drivingSide(){

        System.out.println("Drive on the left lane");
    }


    public static void main(String[] args) {

        CentralTraffic rule = new IndianTraffic();
        rule.redStop();
        rule.goGreen();
        rule.flashYellow();

        IndianTraffic ind = new IndianTraffic();
        ind.drivingSide();

    }
}

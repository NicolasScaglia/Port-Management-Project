import PaqI01.Container;
import PaqI01.Hub;
import PaqI01.Port;

public class Main {
    public static void main(String[] args) {
        Hub hub1 = new Hub();
        Hub hub2 = new Hub();
        Hub hub3 = new Hub();
        Port mainPort = new Port(hub1,hub2,hub3);
        int selectedHub = 0;
        Container lot = new Container();
        lot.setInspected(true);
        lot.setCountryOfOrigin("Spain");
        lot.setID(13231);
        lot.setWeight(31);
        lot.setPriorityLevel(1);
        lot.setReceiverCompany("Aidaade");
        lot.setSenderCompany("GIA");
        lot.setContentDescription("It is to my knowledge it has tuna");
        mainPort.completePort[selectedHub].addContainer(lot);
        System.out.println(mainPort.completePort[selectedHub].HubToString());

    }
}
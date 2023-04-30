package PaqI01;

import java.util.Objects;

public class Port {
    //A port with 3 different hubs
    public Hub[] completePort = new Hub[3];
    public Port(Hub hub1, Hub hub2, Hub hub3){
        // Given hubs to the port constructor
        completePort[0] = hub1;
        completePort[1] = hub2;
        completePort[2] = hub3;
    }
    public void checkAvailable(Container container){
        // Depending on the result of the addContainer function of each hub, it goes to the next
        if(completePort[0].addContainer(container) == -1){
            if(completePort[1].addContainer(container) == -1){
                if(completePort[2].addContainer(container) == -1){
                    System.out.println("Port is full");
                }
            }
        }
    }
    public int containerCount(String country){
        // It searches for all the containers with said country in all the Hubs and makes a count
        int count = 0;
        for(int t = 0; t < 3 ; t++){
            for(int i = 0; i < Hub.COLUMNS; i++){
                for(int j = 0; j < Hub.ROWS; j++){
                    if(completePort[t].dimensions[j][i] != null){
                        if(country.equals(completePort[t].dimensions[j][i].countryOfOrigin)){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

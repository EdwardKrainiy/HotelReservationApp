package UI.menues.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientMenuOutput {

    final static Logger log = LogManager.getLogger(ClientMenuOutput.class);

    public void menu(){
        System.out.println("");
        System.out.println("1. Check profile.");
        System.out.println("2. Make a request.");
        System.out.println("3. Exit.");
        log.info("Client menu output.");
    }
}

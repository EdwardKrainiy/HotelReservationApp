package UI.menues.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CommonMenuSelectingUI{

    final static Logger log = LogManager.getLogger(CommonMenuSelectingUI.class);

    public int menuSelecting(){
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number.");
        while (!sc.hasNextInt()) {
            System.out.println("Incorrect value, try again!");
            sc.nextLine();
            log.info("Incorrect value of menu number, retry...");
        }
        n = sc.nextInt();
        log.info("Number of menu was inputed.");
        return n;
    }
}

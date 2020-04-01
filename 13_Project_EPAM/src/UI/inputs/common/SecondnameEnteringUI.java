package UI.inputs.common;

import java.util.Scanner;

public class SecondnameEnteringUI {
    public String enterSecondName(Scanner sc){
        String secondName = sc.next();
        while(!sc.nextLine().isEmpty()){
            System.out.println("Error, enter second name!");
            sc.nextLine();
        }
        return secondName;
    }
}

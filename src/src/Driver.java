package src;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        String userOption = mainMenu();
        if(userOption.equalsIgnoreCase("create")){

        }
        else if(userOption.equalsIgnoreCase(("edit"))){

        }
        else if(userOption.equalsIgnoreCase("delete")){

        }
        else{
            System.out.println("Invalid input");
            userOption = mainMenu();
        }
    }
    public static String mainMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose from the following options");
        System.out.println("Enter 'create' to create a polynomial");
        System.out.println("'edit' to edit a polynomial");
        System.out.println("'delete' to delete a polynomial");

        String userOption = sc.nextLine();

        return userOption;

    }
}

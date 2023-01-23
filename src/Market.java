import java.util.List;

import Console.Console;
import Farm.Cultivation.Plant;

public class Market {
    List<Plant> Seeds;

    public void DisplayMarketMenu() {
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {
            System.out.println(this.toString());
            System.out.println("Witaj na rynku.");
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Przejdź do sklepu");
            System.out.println("2. Przejdź do skupu");
            System.out.println("3. Wróć");
            
            choice = Console.ReadValue();
            Console.Clear();

            switch (choice) {
                case "1":
                this.DisplayShopMenu();
                break;
                
                case "2":
                this.DisplayPurchaseMenu();
                break;

                case "3":
                Console.Clear();
                BreakLoop = true;
                break;

                default:
                Console.PressAnyKey("Podano nieprawidłową wartość!");
                break;
            }
        }
    }

    public void DisplayShopMenu(){
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {

            System.out.println(this.toString());
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Kup budynek");
            System.out.println("2. Kup pole");
            System.out.println("3. Kup nasiona/sadzonki roślin");
            System.out.println("4. Wróć");
            
            choice = Console.ReadValue();
            Console.Clear();

            switch (choice) {
                case "1":
                break;
                
                case "2":
                break;

                case "3":
                break;

                case "4":
                Console.Clear();
                BreakLoop = true;
                break;

                default:
                Console.PressAnyKey("Podano nieprawidłową wartość!");
                break;
            }
        }
    }

    public void DisplayPurchaseMenu(){
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {

            System.out.println(this.toString());
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Sprzedaj budynek");
            System.out.println("2. Sprzedaj pole");
            System.out.println("3. Sprzedaj nasiona/sadzonki roślin");
            System.out.println("4. Wróć");
            
            choice = Console.ReadValue();
            Console.Clear();

            switch (choice) {
                case "1":
                break;
                
                case "2":
                break;

                case "3":
                break;

                case "4":
                Console.Clear();
                BreakLoop = true;
                break;

                default:
                Console.PressAnyKey("Podano nieprawidłową wartość!");
                break;
            }
        }
    }
}

package User;

import Console.Console;
import Farm.Farm;
import Shop.Shop;

public class User {
    public String Name;
    public Double Cash;
    
    private Farm Farm;

    public User() {
        this.Cash = 100000.0;
    }

    public void SetFarm(Farm farm) {
        this.Farm = farm;
    }

    public Farm GetFarm() {
        return this.Farm;
    }

    public void ManageFarm() {
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {
            System.out.printf("Witaj %s \n\n",this.Name);
            System.out.println("MENU");
            System.out.println("1. Przeglądaj budynki");
            System.out.println("2. Przeglądaj pola");
            System.out.println("3. Przeglądaj zapasy ze zbiorów");
            System.out.println("4. Przeglądaj zapasy jedzenia dla zwierząt");
            System.out.println("5. Idź do sklepu");
            System.out.println("6. Zakończ bieżącą turę");

            choice = Console.ReadValue();
            Console.Clear();
            switch (choice) {
                case "1":
                this.Farm.ManageBuildings(this);
                break;

                case "2":
                this.Farm.ManageFarmlands(this);
                break;

                case "3":
                System.out.println("Twoje zapasy ze zbiorów:\n");
                this.Farm.ViewYields();
                Console.PressAnyKey("Wróć");
                break;

                case "4":
                System.out.println("Twoje zapasy jedzenia dla zwierząt:\n");
                this.Farm.ViewFood();
                Console.PressAnyKey("Wróć");
                break;

                case "5":
                Shop.ViewShopMenu(this);
                break;

                case "6":
                BreakLoop = true;
                break;
                
                default:
                Console.PressAnyKey("Podano nieprawidłową wartość!");
                break;
            }
        }
    }
}

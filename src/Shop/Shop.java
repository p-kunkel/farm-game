package Shop;

import Console.Console;
import Farm.Farm;
import User.User;

public class Shop {
    public static void ViewShopMenu(User user) {
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {
            System.out.printf("Witaj %s \n\n",user.Name);
            System.out.println("MENU");
            System.out.println("1. Kup budynek");
            System.out.println("2. Kup pole");
            System.out.println("3. Kup jedzenie dla zwierząt");
            System.out.println("0. Wróć");

            choice = Console.ReadValue();
            Console.Clear();

            System.out.println("MENU");
            System.out.println("0. Wróć");
            System.out.println();

            switch (choice) {
                case "1":
                GameData.BuildingsType.ViewBuildingsType();
                Console.PressAnyKey("");
                break;

                case "2":
                GameData.FarmlandsType.ViewFarmlandType();
                Console.PressAnyKey("");
                break;

                case "3":
                GameData.FoodType.ViewFoodType();;
                Console.PressAnyKey("");
                break;

                case "0":
                BreakLoop = true;
                break;
                
                default:
                Console.PressAnyKey("Podano nieprawidłową wartość!");
                break;
            }
        }
    }
}

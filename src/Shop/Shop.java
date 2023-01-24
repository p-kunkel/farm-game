package Shop;

import Console.Console;
import Exception.CustomException;
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

            try {
                Integer index;
                switch (choice) {
                    case "1":
                    GameData.BuildingsType.ViewBuildingsType();
                    choice = Console.ReadValue();
                    index = Integer.parseInt(choice);
                    index --;
                    Console.Clear();
                    GameData.BuildingsType.GetByIndex(index).Buy(user);
                    break;

                    case "2":
                    GameData.FarmlandsType.ViewFarmlandType();
                    choice = Console.ReadValue();
                    index = Integer.parseInt(choice);
                    index --;
                    Console.Clear();
                    GameData.FarmlandsType.GetByIndex(index).Buy(user);
                    break;

                    case "3":
                    GameData.FoodType.ViewFoodType();;
                    choice = Console.ReadValue();
                    index = Integer.parseInt(choice);
                    index --;
                    Console.Clear();
                    GameData.FoodType.GetByIndex(index).Buy(user);
                    break;

                    case "0":
                    Console.Clear();
                    BreakLoop = true;
                    break;
                    
                    default:
                    Console.PressAnyKey("Podano nieprawidłową wartość!");
                    break;
                }
            }
            catch (NumberFormatException ex){
                Console.Clear();
                Console.PressAnyKey("Podano nieprawidłową wartość!");
            }
            catch (CustomException ex){
                Console.Clear();
                Console.PressAnyKey(ex.toString());
            }
        }
    }
}

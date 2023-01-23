
package Farm.Cultivation;

import Console.Console;
import Exception.CustomException;
import User.User;

public class Farmland {
    Integer Area;
    private Plant Plant;

    public Farmland(Integer area) {
        this.Area = area;
    }

    public String toString() {
        String plant = "Na tym polu nie jest nic uprawiane.";
        if (this.Plant != null) {
            plant = this.Plant.toString();
        }
        return String.format("%-15s | %s", String.format("%d ha", this.Area) , plant);
    }

    public void SetPlant(Plant plant) throws CustomException {
        if (plant == null) {
            throw new CustomException("Niestety, z pustego to i Salomon nie naleje.");
        }

        if (this.Plant != null && !this.Plant.IsHarvested()) {
            throw new CustomException(String.format("Na tym polu rośnie %s",this.Plant.GetName()));
        }

        this.Plant = plant;
    }

    public Integer GetYields() throws CustomException {
        Integer yields = 0;

        if (this.Plant == null) {
            throw new CustomException("Żeby zebrać plony najpierw musisz coś zasiać");
        }
        
        yields = this.Plant.GetYields();
        return yields*this.Area;
    }

    public void MenageIt(User user){
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {

            System.out.println(this.toString());
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Zbierz plony");
            System.out.println("2. Zasiej coś");
            System.out.println("0. Wróć");
            
            choice = Console.ReadValue();
            Console.Clear();

            switch (choice) {
                case "1":
                if (this.Plant == null) {
                    Console.PressAnyKey("Żeby zebrać plony najpierw musisz coś zasiać");
                    break;
                }

                try {
                    user.GetFarm().AddYelds(this.Plant.GetName(), this.GetYields());
                    Console.PressAnyKey("");
                }
                catch (CustomException ex) {
                    Console.PressAnyKey(ex.toString());
                }
                
                break;
                
                case "2":
                Integer index;
                System.out.printf("Saldo: %.2f zł\n\n", user.Cash);
                GameData.PlantType.ViewPantType();
                System.out.print("\nPodaj pozycję rośliny którą chcesz kupić:");
                choice = Console.ReadValue();

                try {
                    index = Integer.parseInt(choice);
                    index --;
                    Console.Clear();
                }
                catch (NumberFormatException ex){
                    Console.PressAnyKey("Podano nieprawidłową wartość!");
                    break;
                }

                try {
                    GameData.PlantType.GetByIndex(index).Buy(user, this);
                }
                catch (CustomException ex) {
                    Console.PressAnyKey(ex.toString());
                    break;
                }

                this.Plant.AddWeekOfLife();
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
    }
}

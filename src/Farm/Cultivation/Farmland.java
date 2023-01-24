
package Farm.Cultivation;

import Console.Console;
import Exception.CustomException;
import Farm.Yields;
import User.User;

public class Farmland implements Cloneable {
    private Integer Area;
    private Double BuyPrice;
    private Plant Plant;

    public Farmland(Integer area, Double buyPrice) {
        this.Area = area;
        this.BuyPrice = buyPrice;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        String plant = "Na tym polu nie jest nic uprawiane.";
        if (this.Plant != null) {
            plant = this.Plant.toString();
        }
        return String.format("%-15s | %s", String.format("%d ha", this.Area) , plant);
    }

    public Plant getPlant() {
        return this.Plant;
    }

    public Double GetPrice() {
        return this.BuyPrice;
    }

    public Integer GetArea() {
        return this.Area;
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

    public Yields GetYields() throws CustomException {
        if (this.Plant == null) {
            throw new CustomException("Żeby zebrać plony najpierw musisz coś zasiać");
        }
        
        Yields yields = new Yields(this.Plant.GetName(), this.Plant.GetYields()*this.Area, this.Plant.IsForAnimal);
        this.Plant = null;
        return  yields;
    }

    public void Buy(User user) throws CustomException {
        if (user.Cash < this.BuyPrice) {
            throw new CustomException("Nie posiadasz wystarczająco dużo pieniędzy.");
        }

        user.Cash = user.Cash-this.BuyPrice;
        user.GetFarm().AddFarmland(this);
        Console.PressAnyKey(String.format("Kupiono %s ha zemi za %.2f zł na koncie zostało %.2f zł", this.Area, this.BuyPrice, user.Cash));
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
                    user.GetFarm().AddYelds(this.GetYields());
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

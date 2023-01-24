package Farm.Breeding;
import java.util.ArrayList;
import java.util.List;

import Console.Console;
import User.User;

public class Building implements Cloneable  {
    String Type;
    Double BuyPrice;
    Double SellPrice;
    String ForAnimalType;
    Integer MaxAnimalsQuantity;

    List<Animal> Animals;

    public Building(String type,String forAnimalType, Integer maxAnimalsQuantity, Double buyPrice) {
        this.Type = type;
        this.BuyPrice = buyPrice;
        this.MaxAnimalsQuantity = maxAnimalsQuantity;
        this.ForAnimalType = forAnimalType;

        this.Animals = new ArrayList<Animal>();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String GetType(){
        return this.Type;
    }

    public Double GetPrice() {
        return this.BuyPrice;
    }

    public String toString(){
        return String.format("%-15s %-8s", this.Type, String.format("%d/%d szt.",this.Animals.size(), this.MaxAnimalsQuantity));
    }

    public void ViewAnimals() {
        Integer position = 1;
        if (this.Animals.size() == 0) {
            System.out.println("Nie posiadasz żadnych zwierząt w tym budynku");
            return;
        }

        System.out.printf("%-7s | %-10s\n", "pozycja", "zwierzę");
        System.out.println(Console.LINE);
        for (Animal animal : this.Animals) {
            System.out.printf("%-7s | %-10s\n", String.format("%d.", position), animal);
            position ++;
        }
    }

    public void MenageIt(User user){
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {

            System.out.println(this.toString());
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Sprzedaj zwierzęta gotowe do sprzedaży");
            System.out.println("2. Dokup zwierzęta");
            System.out.println("0. Wróć");
            
            this.ViewAnimals();
            choice = Console.ReadValue();
            Console.Clear();

            switch (choice) {
                case "1":
                
                case "2":
                
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

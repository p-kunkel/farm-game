package Farm.Breeding;
import java.util.ArrayList;
import java.util.List;

import Console.Console;
import Exception.CustomException;
import Farm.Farm;
import GameData.Animals;
import User.User;

public class Building implements Cloneable  {
    String Type;
    Double BuyPrice;
    Double SellPrice;
    String ForAnimalSpecies;

    private List<Animal> animals;

    public Building(String type, String forAnimalSpecies, Double buyPrice) {
        this.Type = type;
        this.BuyPrice = buyPrice;
        this.ForAnimalSpecies = forAnimalSpecies;

        this.animals = new ArrayList<Animal>();
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
        return String.format("%-15s %-8s", this.Type, String.format("%d szt.",this.animals.size()));
    }

    public void ViewAnimals() {
        Integer position = 1;
        if (this.animals.size() == 0) {
            System.out.println("Nie posiadasz żadnych zwierząt w tym budynku");
            return;
        }

        System.out.printf("%-7s | %-10s\n", "pozycja", "zwierzę");
        System.out.println(Console.LINE);
        for (Animal animal : this.animals) {
            System.out.printf("%-7s | %-10s\n", String.format("%d.", position), animal);
            position ++;
        }
    }

    public void Buy(User user) throws CustomException {
        if (user.Cash < this.BuyPrice) {
            throw new CustomException("Nie posiadasz wystarczająco dużo pieniędzy.");
        }

        if (user.GetFarm().HasBuiding(this)){
            throw new CustomException("Posiadasz już ten budynek.");
        }

        user.Cash = user.Cash-this.BuyPrice;
        user.GetFarm().AddBuilding(this);
        Console.PressAnyKey(String.format("Kupiono %s za %.2f zł na koncie zostało %.2f zł", this.Type, this.BuyPrice, user.Cash));
    }

    public void AddAnimal(Animal animal) throws CustomException {
        if (animal == null) {
            throw new CustomException("Z pustego to i salomon nie naleje");
        }
        if (animal.Species != this.ForAnimalSpecies) {
            throw new CustomException(String.format("Ten budynek jest przeznaczony dla zwierząt o gatunku: %s", this.ForAnimalSpecies));
        }

        this.animals.add(animal);
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
            System.out.println();
            
            this.ViewAnimals();
            choice = Console.ReadValue();
            Console.Clear();

            switch (choice) {
                case "1":
                break;

                case "2":
                    this.BuyAnimal(user);
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

    public void BuyAnimal(User user) {
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {
            System.out.println(this.toString());
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Potwierdź zakup");
            System.out.println("0. Wróć");
            System.out.println();
            
            Animals.ViewAnimal(this.ForAnimalSpecies);
            choice = Console.ReadValue();
            Console.Clear();

            switch (choice) {         
                case "1":
                    try {
                        Animals.getBySpecies(this.ForAnimalSpecies).Buy(user, this);;
                    } catch (CustomException ex) {
                        Console.PressAnyKey(ex.toString());
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

    public List<String> AddWeekOfLife(Farm farm) {
        List<String> aList = new ArrayList<>();
        for (Animal animal : animals) {
            try {
                animal.AddWeekOfLife(farm);
            } catch (CustomException ex) {
                aList.add(ex.toString());
            }
        }
        return aList;
    }
}

package Farm;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Console.Console;
import Exception.CustomException;
import Farm.Breeding.Building;
import Farm.Cultivation.Farmland;
import User.User;

public class Farm {
    String Name;
    private List<Farmland> Farmlands;
    private List<Building> Buildings;
    private Map<String, Integer> Yields;

    public Farm(String name) {
        this.Name = name;
        this.Farmlands = new ArrayList<Farmland>();
        this.Buildings = new ArrayList<Building>();
        this.Yields = new TreeMap<>();
    }

    public void ViewFarmlands() {
        Integer position = 1;
        if (this.Farmlands.size() == 0) {
            System.out.println("Nie posiadasz żadnych pól");
            return;
        }

        System.out.printf("%-7s | %-10s\n", "pozycja", "pole");
        System.out.println(Console.LINE);
        for (Farmland farmland : this.Farmlands) {
            System.out.printf("%-7s | %-10s\n", String.format("%d.", position), farmland);
            position ++;
        }
    }

    public void AddYelds(String PlantName, Integer Quantity) {
        if (this.Yields.get(PlantName) != null){
            Quantity += this.Yields.get(PlantName);
        }
        this.Yields.put(PlantName, Quantity);
        System.out.println("Aktualny stan zapasów.\n\n");
        this.ViewYields();
    }

    public void ViewBuildings() {
        Integer position = 1;
        if (this.Buildings.size() == 0) {
            System.out.println("Nie posiadasz żadnych budynków");
            return;
        }

        System.out.printf("%-7s | %-10s\n", "pozycja", "budynek");
        System.out.println(Console.LINE);
        for (Building building : this.Buildings) {
            System.out.printf("%-7s | %-10s\n", String.format("%d.", position), building);
            position ++;
        }
    }

    public void ViewYields() {
        Integer position = 1;
        if (this.Yields.size() == 0) {
            System.out.println("Nie posiadasz żadnych zapasów");
            return;
        }

        System.out.printf("%-7s | %-20s | %-10s\n", "pozycja", "roślina", "ilość");
        System.out.println(Console.LINE);

        for (String key : this.Yields.keySet()) {
            System.out.printf("%-7s | %-20s | %-20s\n", String.format("%d.", position), key, String.format("%d",this.Yields.get(key)));
            position ++;
        }
    }

    public void AddBuilding(Building building) {
        this.Buildings.add(building);
    }

    public Farmland GetFarmlandByIndex(Integer index) throws CustomException {
        Farmland result;
        try 
        {
           result =  this.Farmlands.get(index);
        }
        catch (IndexOutOfBoundsException err)
        {
            throw new CustomException("Wybrana pozycja nie istnieje!");
        }

        return result;
    }

    public void AddFarmland(Farmland farmland) {
        this.Farmlands.add(farmland);
    }

    public void ManageBuildings() {


    }

    public void ManageFarmlands(User user) {
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {
            Integer index;
            System.out.println("MENU");
            System.out.println("0. Wróć");
            System.out.println();

            this.ViewFarmlands();
            System.out.print("\nPodaj pozycję pola, którym chcesz zarządzać: ");

            choice = Console.ReadValue();
            Console.Clear();
            switch (choice) {
                case "0":
                BreakLoop = true;
                Console.Clear();
                break;

                default:
                try {
                    index = Integer.parseInt(choice);
                    index --;
                    Console.Clear();
                    this.GetFarmlandByIndex(index).MenageIt(user);
                }
                catch (NumberFormatException ex){
                    Console.PressAnyKey("Podano nieprawidłową wartość!");
                    break;
                }
                catch (CustomException ex){
                    Console.PressAnyKey(ex.toString());
                    break;
                }
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class Farm {
    final private String LINE = "--------------------------------------------------------------------------------------------------------------------------------------------";
    String Name;
    private List<Farmland> Farmlands;
    private List<Building> Buildings;
    private List<Plant> Yields;

    public Farm(String name) {
        this.Name = name;
        this.Farmlands = new ArrayList<Farmland>();
        this.Buildings = new ArrayList<Building>();
        this.Yields = new ArrayList<Plant>();
    }

    public void ViewFarmlands() {
        Integer position = 1;
        if (this.Farmlands.size() == 0) {
            System.out.println("Nie posiadasz żadnych pól");
            return;
        }

        System.out.printf("%-7s | %-10s\n", "pozycja", "pole");
        System.out.println(LINE);
        for (Farmland farmland : this.Farmlands) {
            System.out.printf("%-7s | %-10s\n", String.format("%d.", position), farmland);
            position ++;
        }
    }

    public void ViewBuildings() {
        Integer position = 1;
        if (this.Buildings.size() == 0) {
            System.out.println("Nie posiadasz żadnych budynków");
            return;
        }

        System.out.printf("%-7s | %-10s\n", "pozycja", "budynek");
        System.out.println(LINE);
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

        System.out.printf("%-7s | %-10s\n", "pozycja", "plony");
        System.out.println(LINE);
        for (Plant yield : this.Yields) {
            System.out.printf("%-7s | %-10s\n", String.format("%d.", position), yield);
            position ++;
        }
    }

    public void AddBuilding(Building building) {
        this.Buildings.add(building);
    }

    public void AddFarmland(Farmland farmland) {
        this.Farmlands.add(farmland);
    }
}

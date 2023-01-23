package Farm.Breeding;
import java.util.ArrayList;
import java.util.List;

public class Building {
    String Name;
    String Type;
    Integer Area;
    Double BuyPrice;
    Double SellPrice;
    String ForAnimalType;

    List<Animal> Animals;

    public Building(String name, String type, Integer area, Double buyPrice) {
        this.Name = name;
        this.Type = type;
        this.Area = area;
        this.BuyPrice = buyPrice;

        this.Animals = new ArrayList<Animal>();
    }

    public String toString(){
        return String.format("%-15s %-15s %-8d %-8d", this.Name, this.Type, this.Area, this.Animals.size());
    }
}

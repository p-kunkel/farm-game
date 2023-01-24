package GameData;

import java.util.ArrayList;
import java.util.List;

import Exception.CustomException;
import Farm.Breeding.Building;
import Console.Console;

public class BuildingsType {
    private static List<Building> BuildingTypes;
    static {
        List<Building> aList = new ArrayList<>();
        aList.add(new Building("Obora", "Krowa", 10, 40000.0));
        aList.add(new Building("Chlewnia", "Świnia", 10, 40000.0));
        aList.add(new Building("Owczarnia", "Owca", 10, 40000.0));
        aList.add(new Building("Kurnik", "Kura", 10, 40000.0));
        aList.add(new Building("Budynek do hodowli psów", "Pies", 10, 40000.0));

        BuildingTypes = aList;
    }

    public static List<Building> BuildingsTypes() {
        return BuildingTypes;
    }

    public static Building GetByIndex(Integer key) throws CustomException {
        Building result;
        try {
           result = (Building) BuildingTypes.get(key).clone();
        } catch (IndexOutOfBoundsException err) {
            throw new CustomException("Wybrana pozycja nie istnieje!");
        } catch (CloneNotSupportedException e) {
            throw new CustomException("Wystąpił błąd podczas pobierania budynku.");
        }
        return result;
    }

    public static void ViewBuildingsType() {
        Integer position = 1;
        System.out.printf("%-10s | %-30s | %-10s\n", "pozycja", "nazwa", "cena");
        System.out.println(Console.LINE);
        for (Building building : BuildingTypes) {
            System.out.printf("%-10s | %-30s | %-10s\n",position, building.GetType(), building.GetPrice());
            position++;
        }
    }
}

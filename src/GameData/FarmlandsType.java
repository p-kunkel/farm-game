package GameData;

import java.util.ArrayList;
import java.util.List;

import Exception.CustomException;
import Farm.Cultivation.Farmland;
import Console.Console;

public class FarmlandsType {
    private static List<Farmland> FarmlandTypes;
    static {
        List<Farmland> aList = new ArrayList<>();
        aList.add(new Farmland(1000, 100.0));

        FarmlandTypes = aList;
    }

    public static List<Farmland> GetPlantTypes() {
        return FarmlandTypes;
    }

    public static Farmland GetByIndex(Integer key) throws CustomException {
        Farmland result;
        try {
            result = (Farmland) FarmlandTypes.get(key).clone();
        } catch (IndexOutOfBoundsException err) {
            throw new CustomException("Wybrana pozycja nie istnieje!");
        } catch (CloneNotSupportedException e) {
            throw new CustomException("Wystąpił błąd podczas pobierania rośliny.");
        }
        return result;
    }

    public static void ViewFarmlandType() {
        Integer position = 1;
        System.out.printf("%-10s | %-20s | %-10s\n", "pozycja", "powierzchnia [ha]", "cena");
        System.out.println(Console.LINE);
        for (Farmland farmland : FarmlandTypes) {
            System.out.printf("%-10s | %-20s | %-10s\n",position, farmland.GetArea(), farmland.GetPrice());
            position++;
        }
    }
}


package GameData;

import java.util.ArrayList;
import java.util.List;
import Console.Console;
import Exception.CustomException;
import Farm.Cultivation.Plant;

public class PlantType {
    private static List<Plant> PlantType;
    static {
        List<Plant> aList = new ArrayList<>();
        aList.add(new Plant(Plant.PLANT_TYPE_RYE, 1000.0, 900.0, 10,  1, 100.0, 100.0, 100.0, true));
        aList.add(new Plant(Plant.PLANT_TYPE_CORN, 1000.0, 900.0, 10,  16, 100.0, 100.0, 100.0, true));
        aList.add(new Plant(Plant.PLANT_TYPE_CARROT, 1000.0, 900.0, 10,  16, 100.0, 100.0, 100.0, true));
        aList.add(new Plant(Plant.PLANT_TYPE_APPLE_TREE, 10000.0, 9000.0, 100,  20, 100.0, 1000.0, 1000.0, true));
        PlantType = aList;
    }

    public static List<Plant> GetPlantTypes() {
        return PlantType;
    }

    public static Plant GetByIndex(Integer key) throws CustomException {
        Plant result;
        try {
           result = (Plant) PlantType.get(key).clone();
        } catch (IndexOutOfBoundsException err) {
            throw new CustomException("Wybrana pozycja nie istnieje!");
        } catch (CloneNotSupportedException e) {
            throw new CustomException("Wystąpił błąd podczas pobierania rośliny.");
        }
        return result;
    }

    public static void ViewPantType() {
        Integer position = 1;
        System.out.printf("%-10s | %-20s | %-10s\n", "pozycja", "nazwa", "cena");
        System.out.println(Console.LINE);
        for (Plant plant : PlantType) {
            System.out.printf("%-10s | %-20s | %-10s\n",position, plant.GetName(), plant.GetPrice());
            position++;
        }
    }
}

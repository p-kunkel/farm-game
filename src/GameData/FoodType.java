package GameData;

import java.util.ArrayList;
import java.util.List;

import Exception.CustomException;
import Farm.Breeding.Food;
import Console.Console;

public class FoodType {
    private static List<Food> FoodType;
    static {
        List<Food> aList = new ArrayList<>();
        aList.add(new Food("Karma dla psa", 100.0));
        aList.add(new Food("Karma dla kota", 100.0));
        FoodType = aList;
    }

    public static List<Food> GetPlantTypes() {
        return FoodType;
    }

    public static Food GetByIndex(Integer key) throws CustomException {
        Food result;
        try {
           result = (Food) FoodType.get(key).clone();
        } catch (IndexOutOfBoundsException err) {
            throw new CustomException("Wybrana pozycja nie istnieje!");
        } catch (CloneNotSupportedException e) {
            throw new CustomException("Wystąpił błąd podczas pobierania rośliny.");
        }
        return result;
    }

    public static void ViewFoodType() {
        Integer position = 1;
        System.out.printf("%-10s | %-20s | %-10s\n", "pozycja", "nazwa", "cena");
        System.out.println(Console.LINE);
        for (Food food : FoodType) {
            System.out.printf("%-10s | %-20s | %-10s\n",position, food.GetName(), food.GetPrice());
            position++;
        }
    }
}

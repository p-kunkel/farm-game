package GameData;

import java.util.ArrayList;
import java.util.List;

import Exception.CustomException;
import Farm.Breeding.Animal;
import Console.Console;

public class Animals {
    private static List<Animal> Animals;
    static {
        List<Animal> aList = new ArrayList<>();
        aList.add(new Animal(Animal.ANIMAL_SPECIES_COW,700.0,10,100.0,40,20,100,0.1));
        aList.add(new Animal(Animal.ANIMAL_SPECIES_CHICKEN,15.0,1,1.0,1,5,10,0.3));
        aList.add(new Animal(Animal.ANIMAL_SPECIES_RABBIT,50.0,1,1.0,40,10,15,0.6));
        aList.add(new Animal(Animal.ANIMAL_SPECIES_SHEEP,200.0,3,15.0,5,20,30,0.2));
        aList.add(new Animal(Animal.ANIMAL_SPECIES_DOG,2000.0,1,1.0,1,20,20,0.2));
        aList.add(new Animal(Animal.ANIMAL_SPECIES_PIG ,700.0,20,50.0,20,20,40,0.2));
        Animals = aList;
    }

    public static void ViewAnimal(String species) {
        System.out.printf("%-30s | %-10s\n","NAZWA", "cena");
        System.out.println(Console.LINE);
        for (Animal animal : Animals) {
            if (animal.Species == species) {
                System.out.printf("%-30s | %-10s\n", animal.Species , animal.BuyPrice);
                break;
            }
        }
    }

    public static Animal getBySpecies(String species) throws CustomException {
        Animal result = null;
        for (Animal animal : Animals) {
            if (animal.Species == species) {
                try {
                    result = (Animal) animal.clone();
                } catch (CloneNotSupportedException e) {
                    throw new CustomException("Wystąpił błąd podczas pobierania zwierzęcia.");
                }
                break;
            }
        }
        return result;
    }
}

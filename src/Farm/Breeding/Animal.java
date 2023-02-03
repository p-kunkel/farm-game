package Farm.Breeding;

import java.util.ArrayList;
import java.util.List;

import Console.Console;
import Exception.CustomException;
import Farm.Farm;
import Farm.Cultivation.Plant;
import User.User;

public class Animal implements Cloneable {
    public static final String ANIMAL_SPECIES_COW = "Krowa";
    public static final String ANIMAL_SPECIES_CHICKEN = "Kura";
    public static final String ANIMAL_SPECIES_SHEEP = "Owca";
    public static final String ANIMAL_SPECIES_RABBIT = "Królik";
    public static final String ANIMAL_SPECIES_DOG = "Pies";
    public static final String ANIMAL_SPECIES_CAT = "Kot";
    public static final String ANIMAL_SPECIES_PIG = "Świnia";

    public String Species;
    public Double BuyPrice;
    private Integer GrowthRate;
    private Double Weight;
    private Integer MinWeight;
    private Integer GrowsUpAfter;
    private Integer WeeklyFood;
    private List<String> RequiredFood;
    private Integer WeekOfLife;
    private Double ChanceToBreed;
    private Boolean IsAlive;


    public Animal(String Species, Double BuyPrice, Integer GrowthRate,  Double Weight, Integer MinWeight, Integer GrowsUpAfter, Integer WeeklyFood, Double ChanceToBreed) {
        this.Species = Species;
        this.BuyPrice = BuyPrice;
        this.GrowthRate = GrowthRate;
        this.Weight = Weight;
        this.MinWeight = MinWeight;
        this.GrowsUpAfter = GrowsUpAfter;
        this.WeeklyFood = WeeklyFood;
        this.RequiredFood = getFoodList(Species);
        this.WeekOfLife = 5;
        this.ChanceToBreed = ChanceToBreed;
        this.IsAlive = true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public List<String> GetRequiredFood() {
        return this.RequiredFood;
    }

    public boolean CanEatThisFood(FoodForAnimal ffa) {
        for (String string : RequiredFood) {
            if (string == ffa.GetName()) {
                return true;
            }
        }
        return false;
    }

    public void Buy(User user, Building building) throws CustomException {
        if (user.Cash < this.BuyPrice) {
            throw new CustomException("Nie posiadasz wystarczająco dużo pieniędzy.");
        }

        user.Cash = user.Cash-this.BuyPrice;
        building.AddAnimal(this);
        Console.PressAnyKey(String.format("Kupiono %s za %.2f zł na koncie zostało %.2f zł", this.Species, this.BuyPrice, user.Cash));
    }

    public void AddWeekOfLife(Farm farm) throws CustomException {
        if (!this.IsAlive) {
            return;
        }

        FoodForAnimal ffa = null;
        this.WeekOfLife ++;
        for (String requiredFood : RequiredFood) {
            ffa = farm.GetFoodForAnimal(requiredFood);
            if (ffa != null && ffa.CanTakeIt(WeeklyFood)) {
                ffa.Take(this.WeeklyFood);

                if (this.GrowsUpAfter != this.WeekOfLife) {
                    this.Weight += this.GrowthRate;
                }
                return;     
            }
        }
        
        this.Weight -= this.GrowthRate*1.1;
        if (this.Weight < this.MinWeight) {
            this.IsAlive = false;
            throw new CustomException(String.format("Zabrakło jedzenia! Zwierzę (%s) zdechło!", this.Species));
        }
    }

    private List<String> getFoodList(String species) {
        List<String> aList = new ArrayList<>();

        if (species == ANIMAL_SPECIES_COW || species == ANIMAL_SPECIES_PIG || species == ANIMAL_SPECIES_RABBIT) {
            aList.add(Plant.PLANT_TYPE_APPLE_TREE);
        }

        if (species == ANIMAL_SPECIES_RABBIT || species == ANIMAL_SPECIES_PIG || species == ANIMAL_SPECIES_SHEEP) {
            aList.add(Plant.PLANT_TYPE_CARROT);
        }

        if (species == ANIMAL_SPECIES_COW || species == ANIMAL_SPECIES_PIG || species == ANIMAL_SPECIES_SHEEP) {
            aList.add(Plant.PLANT_TYPE_CORN);
        }

        if (species == ANIMAL_SPECIES_RABBIT || species == ANIMAL_SPECIES_PIG  || species == ANIMAL_SPECIES_SHEEP || species == ANIMAL_SPECIES_CHICKEN) {
            aList.add(Plant.PLANT_TYPE_RYE);
        }

        if (species == ANIMAL_SPECIES_DOG) {
            aList.add(Food.FOOD_FOR_DOG);
        }

        if (species == ANIMAL_SPECIES_CAT) {
            aList.add(Food.FOOD_FOR_CAT);
        }

        return aList;
    }
}

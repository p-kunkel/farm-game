package Farm.Breeding;

import java.util.List;

public class Animal implements Cloneable {
    private String Species;
    private Double BuyPrice;
    private Integer GrowthRate;
    private Integer Weight;
    private Integer MinWeight;
    private Integer GrowsUpAfter;
    private Integer WeeklyFood;
    private List<String> RequiredFood;
    private Integer WeekOfLife;
    private Double ChanceToBreed;
    private Boolean IsAlive;

    private AnimalProduct Product;

    public Animal(String Species, Double BuyPrice, Integer GrowthRate,  Integer Weight, Integer MinWeight, Integer GrowsUpAfter, Integer WeeklyFood, List<String> RequiredFood, Integer WeekOfLife, Double ChanceToBreed) {
        this.Species = Species;
        this.BuyPrice = BuyPrice;
        this.GrowthRate = GrowthRate;
        this.Weight = Weight;
        this.MinWeight = MinWeight;
        this.GrowsUpAfter = GrowsUpAfter;
        this.WeeklyFood = WeeklyFood;
        this.RequiredFood = RequiredFood;
        this.WeekOfLife = WeekOfLife;
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

    public void SetProduct(AnimalProduct animalProduct) {
        this.Product = animalProduct;
    }
}

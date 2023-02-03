package Farm.Cultivation;

import Console.Console;
import Exception.CustomException;
import User.User;

public class Plant implements Cloneable {
    public static final String PLANT_TYPE_RYE = "Żyto";
    public static final String PLANT_TYPE_CORN = "Kukurydza";
    public static final String PLANT_TYPE_CARROT = "Marchewka";
    public static final String PLANT_TYPE_APPLE_TREE = "Jabłoń";
    private String Name;
    private Double BuyPrice;
    private Integer Yields;
    private Integer HarvestsAfter;
    private Integer WeekOfLife;
    private Double HarvestCost;
    private Double ProtectionCost;
    private Double SowingCost;
    private Boolean IsHarvested = false;
    Boolean IsForAnimal;

    public Plant(String name, Double buyPrice,Double sellPrice,Integer yields, Integer harvestsAfter,Double harvestCost,Double protectionCost,Double sowingCost, Boolean isForAnimal) {
        this.Name = name;
        this.BuyPrice = buyPrice;
        this.Yields = yields;
        this.HarvestsAfter = harvestsAfter;
        this.HarvestCost = harvestCost;
        this.ProtectionCost = protectionCost;
        this.SowingCost = sowingCost;
        this.IsHarvested = false;
        this.IsForAnimal = isForAnimal;
        this.WeekOfLife = 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    
    public String toString() {
        return String.format("%-20s %.2f %%", this.Name, (this.WeekOfLife.floatValue()/this.HarvestsAfter.floatValue()*100));
    }

    public void AddWeekOfLife() {
        if (this.HarvestsAfter == this.WeekOfLife) {
            return;
        }
        this.WeekOfLife ++;
    }

    public Integer GetYields() throws CustomException {
        if (this.HarvestsAfter != this.WeekOfLife){
            throw new CustomException("Uprawa nie jest gotowa do zbiorów.");
        }

        if (this.IsHarvested){
            throw new CustomException("Już po zbiorach!");
        }

        this.IsHarvested = true;
        return this.Yields;
    }

    public Boolean IsHarvested() {
        return this.IsHarvested;
    }

    public Double GetPrice() {
        return this.BuyPrice;
    }

    public String GetName() {
        return this.Name;
    }

    public void Buy(User user, Farmland farmland) throws CustomException {
        if (user.Cash < this.BuyPrice*farmland.GetArea()) {
            throw new CustomException("Nie posiadasz wystarczająco dużo pieniędzy.");
        }

        user.Cash = user.Cash-this.BuyPrice*farmland.GetArea();
        farmland.SetPlant(this);
        Console.PressAnyKey(String.format("Kupiono %s za %.2f zł na koncie zostało %.2f zł", this.Name, this.BuyPrice*farmland.GetArea(), user.Cash));
    }
}

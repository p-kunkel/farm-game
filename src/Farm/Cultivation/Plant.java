package Farm.Cultivation;

import Console.Console;
import Exception.CustomException;
import User.User;

public class Plant implements Cloneable {
    private String Name;
    private Double BuyPrice;
    private Integer Yields;
    private Integer HarvestsAfter;
    private Integer WeekOfLife;
    private Double HarvestCost;
    private Double ProtectionCost;
    private Double SowingCost;
    private Boolean IsHarvested = false;

    public Plant(String name, Double buyPrice,Double sellPrice,Integer yields, Integer harvestsAfter,Double harvestCost,Double protectionCost,Double sowingCost) {
        this.Name = name;
        this.BuyPrice = buyPrice;
        this.Yields = yields;
        this.HarvestsAfter = harvestsAfter;
        this.HarvestCost = harvestCost;
        this.ProtectionCost = protectionCost;
        this.SowingCost = sowingCost;
        this.IsHarvested = false;
        this.WeekOfLife = 0;
    }

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
        if (user.Cash < this.BuyPrice*farmland.Area) {
            throw new CustomException("Nie posiadasz wystarczająco dużo pieniędzy.");
        }

        user.Cash = user.Cash-this.BuyPrice*farmland.Area;
        farmland.SetPlant(this);
        Console.PressAnyKey(String.format("Kupiono %s za %.2f zł na koncie zostało %.2f zł", this.Name, this.BuyPrice*farmland.Area, user.Cash));
    }
}

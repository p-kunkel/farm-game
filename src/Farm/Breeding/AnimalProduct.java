package Farm.Breeding;

import Exception.CustomException;

public class AnimalProduct {
    private String Name;
    private Double SellPrice;
    private Integer WeeklyQuantity;
    private Boolean isCollected;

    public AnimalProduct(String name, Double sellPrcice, Integer weeklyQuantity) {
        this.Name = name;
        this.SellPrice = sellPrcice;
        this.WeeklyQuantity = weeklyQuantity;
        this.isCollected = false;
    }

    public String GetName() {
        return this.Name;
    }

    public void SetNoCollected() {
        this.isCollected = false;
    }

    public Integer Collect() throws CustomException {
        if (isCollected){
            throw new CustomException("Ju!");
        }

        this.isCollected = true;
        return this.WeeklyQuantity;
    }
}

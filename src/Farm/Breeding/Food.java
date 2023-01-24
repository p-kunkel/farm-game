package Farm.Breeding;

import Exception.CustomException;

public class Food  implements FoodForAnimal{
    String Name;
    Double BuyPrice;
    Integer Quantity;

    public Food(String name, Double buyPrice) {
        this.Name = name;
        this.BuyPrice = buyPrice;
    }

    public Double GetPrice() {
        return this.BuyPrice;
    }

    @Override
    public String GetName() {
        return this.Name;
    }

    @Override
    public Boolean IsForAnimal() {
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void Take(Integer i) throws CustomException{
        if (i > this.Quantity) {
            throw new CustomException("Niewystarczająca ilość jedzenia, aby wykarmić zwierzęta");
        }

        this.Quantity -= i;   
    }
}

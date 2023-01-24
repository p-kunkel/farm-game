package Farm.Breeding;

import Console.Console;
import Exception.CustomException;
import User.User;

public class Food  implements FoodForAnimal, Cloneable {
    String Name;
    Double BuyPrice;
    public Integer Quantity;

    public Food(String name, Double buyPrice) {
        this.Name = name;
        this.BuyPrice = buyPrice;
    }

    public Double GetPrice() {
        return this.BuyPrice;
    }

    public Integer GetQuantity() {
        return this.Quantity;
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

    public void Buy(User user) throws CustomException {
        if (user.Cash < this.BuyPrice) {
            throw new CustomException("Nie posiadasz wystarczająco dużo pieniędzy.");
        }

        user.Cash = user.Cash-this.BuyPrice;
        user.GetFarm().AddFood(this);
        Console.PressAnyKey(String.format("Kupiono %s za %.2f zł na koncie zostało %.2f zł", this.Name, this.BuyPrice, user.Cash));
    }
}

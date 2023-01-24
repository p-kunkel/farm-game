package Farm;

import Exception.CustomException;
import Farm.Breeding.FoodForAnimal;

public class Yields implements FoodForAnimal{
    String Name;
    Boolean IsForAnimal;
    Integer Quantity;

    public Yields(String name, Integer quantity, Boolean isForAnimal) {
        this.Name = name;
        this.IsForAnimal = isForAnimal;
        this.Quantity = quantity;
    }

    @Override
    public String GetName() {
        return this.Name;
    }

    @Override
    public Boolean IsForAnimal() {
        return this.IsForAnimal;
    }

    @Override
    public void Take(Integer i) throws CustomException{
        if (i > this.Quantity) {
            throw new CustomException("Niewystarczająca ilość zapasów, aby wykarmić zwierzęta");
        }

        this.Quantity -= i;   
    }
}

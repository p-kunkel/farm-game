package Farm.Breeding;

import Exception.CustomException;

public interface FoodForAnimal {
    public String GetName();
    public Boolean IsForAnimal();
    public void Take(Integer i) throws CustomException; 
}

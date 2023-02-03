import java.util.ArrayList;
import java.util.List;

import Console.Console;
import Exception.CustomException;
import Farm.Farm;
import User.User;

public class Game {
    Integer Week;
    Boolean BreakLoop;
    private List<User> Users;


    public Game(Integer week) {
        this.Week = week;
        this.BreakLoop = false;
        this.Users = new ArrayList<User>();
    }

    public void Start() {
       
        System.out.println("Symulator farmy");

        while (this.BreakLoop == false) {
            System.out.println("MENU");
            System.out.println("1. Rozpocznij nową grę");
            System.out.println("0. Wyjdź");

            String choice = Console.ReadValue();
            Console.Clear();
            switch (choice) {
                case "1":
                User NewUser = new User();
                System.out.println("Podaj nazwę gracza: ");
                NewUser.Name = Console.ReadValue();
                this.Users.add(NewUser);
                Console.Clear();

                while (this.BreakLoop == false) {
                    for (User user : this.Users) {
                        if (user.GetFarm() == null) {
                            user.SetFarm(new Farm(String.format("Farma '%s'", user.Name)));
                        }

                        System.out.printf("Tydzień nr %d \n",this.Week);
                        user.ManageFarm();
                        user.GetFarm().SimulateWeeklyProgress();

                    }

                    this.Week +=1;
                }
 
                this.BreakLoop = false;
                break;
                case "0":
                System.out.println("Do zobaczenia!");
                this.BreakLoop = true;
                break;
                default:
                Console.PressAnyKey("Podano nieprawidłową wartość!");
                break;
            }
        }  
    }

    public void AddUser(User user) {
        
    }
}


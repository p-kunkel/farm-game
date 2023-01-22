public class User {
    String Name;
    Double Cash;
    
    private Farm Farm;


    public User() {

    }

    public void SetFarm(Farm farm) {
        this.Farm = farm;
    }

    public void ManageFarm() {
        Boolean BreakLoop = false;
        String choice;
        while (BreakLoop == false) {
            System.out.printf("Witaj %s \n\n",this.Name);
            System.out.println("MENU");
            System.out.println("1. Przeglądaj budynki");
            System.out.println("2. Przeglądaj pola");
            System.out.println("3. Przeglądaj zapasy");
            System.out.println("4. Idź do sklepu");
            System.out.println("5. Zakończ bieżącą turę");

            choice = Console.ReadValue();
            Console.Clear();
            switch (choice) {
                case "1":
                System.out.println("Twoje budynki:");

                Console.ProcessAnyKey("Naciśnij dowolny klawisz, aby przejść dalej :)");
                break;
                case "2":
                System.out.println("Twoje pola:");

                Console.ProcessAnyKey("Naciśnij dowolny klawisz, aby przejść dalej :)");
                break;
                case "3":
                System.out.println("Twoje zapasy:");

                Console.ProcessAnyKey("Naciśnij dowolny klawisz, aby przejść dalej :)");
                break;
                case "4":
                System.out.println("Sklep:");

                Console.ProcessAnyKey("Naciśnij dowolny klawisz, aby przejść dalej :)");
                break;
                case "5":
                BreakLoop = true;
                break;
                default:
                System.out.println("Podano nieprawidłową wartość!");
                Console.ReadValue();
                Console.Clear();
                break;
            }
        }
    }
}

public class Farmland {
    Integer Area;
    Plant Plant;

    public Farmland(Integer area) {
        this.Area = area;
    }

    public String toString() {
        String plant = "Na tym polu nie jest nic uprawiane.";
        if (this.Plant != null) {
            plant = this.Plant.toString();
        }
        return String.format("%-15d | %s", this.Area, plant);
    }
}

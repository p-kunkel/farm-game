public class Plant {
    private String Name;
    private Double BuyPrice;
    private Double SellPrice;
    private Integer SowingArea;
    private Double Yields;
    private Double HarvestsAfter;
    private Double HarvestCost;
    private Double ProtectionCost;
    private Double SowingCost;

    public Plant(String name, Double buyPrice,Double sellPrice,Double pellPrice,Double yields, Double harvestsAfter,Double harvestCost,Double protectionCost,Double sowingCost) {
        this.Name = name;
        this.BuyPrice = buyPrice;
        this.SellPrice = sellPrice;
        this.Yields = yields;
        this.HarvestsAfter = harvestsAfter;
        this.HarvestCost = harvestCost;
        this.ProtectionCost = protectionCost;
        this.SowingCost = sowingCost;
    }

    

    
}

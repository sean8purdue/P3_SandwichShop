/**
 * Created by Sean on 3/6/16.
 */
public class Sandwich implements PurchasedItem {
    private String name;
    private int condiments;
    private Spicyness level;
    private int delTime; // delivery time in Minutes
    private double sellPrice;
    private double matCost;

    private int numCon; // number of Condiments

    //?1 not sure? why don't set to final
    //? diffrence public static final
    public static double costOfCondiment = 0.05;
    public static double pricePerCondiment = 0.75;


    // @Default Constructor
    public Sandwich() {
        this.name = null;
        this.condiments = 0;
        this.level = null;
        this.delTime = 0;
        this.sellPrice = 0;
        this.matCost = 0;
        this.numCon = 0;

    }

    //++++++++++++++++++++ Constructor
    public Sandwich(String name, double matCost) {
        this();
        this.name = name;
        this.matCost = matCost;
    }

    public Sandwich(String name, double matCost, double sellPrice) {
        this(name, matCost);
        this.sellPrice = sellPrice;
    }

    public Sandwich(String name, double matCost, double sellPrice, int delTime, Spicyness level, int condiments) {
        this(name, matCost, sellPrice);
        this.delTime = delTime;
        this.level = level;
        this.condiments = condiments;
    }
    //-------------------- Constructor End

    //++++++++++++++++++++ Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCondiments() {
        return condiments;
    }

    public void setCondiments(int condiments) {
        this.condiments = condiments;
    }

    public Spicyness getLevel() {
        return level;
    }

    public void setLevel(Spicyness level) {
        this.level = level;
    }

    public int getDelTime() {
        return delTime;
    }

    public void setDelTime(int delTime) {
        this.delTime = delTime;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getMatCost() {
        return matCost;
    }

    public void setMatCost(double matCost) {
        this.matCost = matCost;
    }
    //-------------------- Getter and Setter End

    public void addCondiments(int num) {
        if (this.numCon + num >= 0) {
            this.numCon += num;
            setMatCost(getMatCost() + this.numCon * costOfCondiment);
            setSellPrice(getSalePrice() + this.numCon * pricePerCondiment);
        }
    }

    public void removeCondiments(int num) {
        if (this.numCon - num >= 0) {
            this.numCon -= num;
            //?2 might be wrong
            setMatCost(getMatCost() + this.numCon * costOfCondiment);
            setSellPrice(getSalePrice() + this.numCon * pricePerCondiment);
        }
    }

    public int getNumCondients() {
        return this.numCon;
    }

}

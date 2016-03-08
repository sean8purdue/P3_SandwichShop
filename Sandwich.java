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
        this.sellPrice = 0.0;
        this.matCost = 0.0;
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
        if (level != null)
            this.level = level;
    }

    public int getDelTime() {
        return delTime;
    }

    public void setDelTime(int delTime) {
        if (delTime > 0)
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

    //++++++++++++++++++++ Condiments Maintain Methods
    public void addCondiments(int num) {
        if (this.numCon + num >= 0) {
            this.numCon += num;
//            setMatCost(getMatCost() + this.numCon * costOfCondiment);
//            setSellPrice(getSalePrice() + this.numCon * pricePerCondiment);
        }
    }

    public void removeCondiments(int num) {
        if (this.numCon - num >= 0) {
            this.numCon -= num;
            //?2 might be wrong
//            setMatCost(getMatCost() + this.numCon * costOfCondiment);
//            setSellPrice(getSalePrice() + this.numCon * pricePerCondiment);
        }
    }

    public int getNumCondients() {
        return this.numCon;
    }

    //-------------------- Condiments Maintain Methods End

    //++++++++++++++++++++ Override Interface Methods
    @Override
    public boolean isDelivery() {
        if (delTime > 0 && delTime < 60)
            return true;

        return false;
    }

    @Override
    public String getCustomerName() {
        return name;
    }

    @Override
    public int getDeliveryTime() {
        return this.delTime;
    }

    @Override
    public void setDeliveryTime(int time) {
        //b2
        // input validation to ensure the new value is logically correct.
        if (delTime >= 0)
            this.delTime = time;
    }

    @Override
    public double getMaterialCost() {
        //b1 bug1
        // private numCon, can't use this.numCon
        //setMatCost(getMatCost() + this.numCon * costOfCondiment);
        setMatCost(getMatCost() + getNumCondients() * costOfCondiment);
        return getMatCost();
    }

    @Override
    public double getSalePrice() {
        setSellPrice(getSellPrice() + getNumCondients() * pricePerCondiment);
        return getSellPrice();
    }

    //-------------------- Override Interface Methods

    @Override
    public boolean equals(Object obj) {
        //?2 why (Sandwich) obj.name
        //   not  obj.name;
        //?3 price are the same to the nearest cent??
        if (obj instanceof Sandwich
                && this.name.equals(((Sandwich) obj).name)
                && this.getMatCost() == ((Sandwich) obj).getMatCost()
                && this.getSellPrice() == ((Sandwich) obj).getSellPrice()
                && this.delTime == ((Sandwich) obj).delTime
                && this.level == ((Sandwich) obj).level
                )
            return true;

        return false;
    }

}

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

//    private int numCon; // number of Condiments

    //?1 not sure? why don't set to final
    // diffrence public static final
    //! can be set as final
    private static double costOfCondiment = 0.05;
    private static double pricePerCondiment = 0.75;

    //++++++++++++++++++++ Constructor
    public Sandwich(String name, double matCost, double sellPrice, int delTime, Spicyness level, int condiments) {
        this.name = name;
        this.matCost = matCost;
        this.sellPrice = sellPrice;
        this.delTime = delTime;
        this.level = level;
        this.condiments = condiments;

//        this.numCon = 0; // should be the same as condiments
    }

    public Sandwich(String name, double matCost, double sellPrice) {
        this(name, matCost, sellPrice, 0, Spicyness.MILD, 0);
    }

    public Sandwich(String name, double matCost) {
        this(name, matCost, 3.5 * matCost, 0, Spicyness.MILD, 0);
    }
    //-------------------- Constructor End

    //++++++++++++++++++++ Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null)
            this.name = name;
    }

    public int getCondiments() {
        return condiments;
    }

    public void setCondiments(int condiments) {
        if (condiments >= 0)
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
        if (delTime >= 0)
            this.delTime = delTime;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        if (sellPrice >= 0)
            this.sellPrice = sellPrice;
    }

    public double getMatCost() {
        return matCost;
    }

    public void setMatCost(double matCost) {
        if (matCost >= 0)
            this.matCost = matCost;
    }
    //-------------------- Getter and Setter End

    //++++++++++++++++++++ Condiments Maintain Methods
    public void addCondiments(int num) {
        if (num > 0) {
            //? may have bugs
            num += getCondiments();
            setCondiments(num);
        }
//        if (this.condiments + num >= 0) {
//            this.numCon += num;
//            setMatCost(getMatCost() + this.numCon * costOfCondiment);
//            setSellPrice(getSalePrice() + this.numCon * pricePerCondiment);
//        }
    }

    public void removeCondiments(int num) {
        if (num > 0) {
            num -= getCondiments();
            if (num < 0) {
                setCondiments(0);
            }
            if (num > 0) {
                setCondiments(num);
        }
//        if (this.numCon - num >= 0) {
//            this.numCon -= num;
            //?2 might be wrong
//            setMatCost(getMatCost() + this.numCon * costOfCondiment);
//            setSellPrice(getSalePrice() + this.numCon * pricePerCondiment);
        }
    }

    public int getNumCondients() {
        return this.condiments;
    }

    //-------------------- Condiments Maintain Methods End

    //++++++++++++++++++++ Override Interface Methods
    @Override
    public boolean isDelivery() {
        if (delTime > 0 && delTime <= 60)
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

    //? the same as Setter and Getter Method in previous, Redundant?
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sandwich sandwich = (Sandwich) o;

        if (getDelTime() != sandwich.getDelTime()) return false;
        //? Base material costs and base selling price. Which is the base?
//        if (Double.compare(sandwich.getSellPrice(), getSellPrice()) != 0) return false;
        if (!(Math.abs(getSellPrice() - sandwich.getSellPrice()) < 0.01)) return false;
//        if (Double.compare(sandwich.getMatCost(), getMatCost()) != 0) return false;
        if (!(Math.abs(getMatCost() - sandwich.getMatCost()) < 0.01)) return false;
        if (getName() != null ? !getName().equals(sandwich.getName()) : sandwich.getName() != null) return false;
        return getLevel() == sandwich.getLevel();

    }
//    public boolean equals(Object obj) {
//        //?2 why (Sandwich) obj.name
//        //   not  obj.name;
//        //?3 price are the same to the nearest cent??
//        if (obj instanceof Sandwich
//                && this.name.equals(((Sandwich) obj).name)
//                && this.getMatCost() == ((Sandwich) obj).getMatCost()
//                && this.getSellPrice() == ((Sandwich) obj).getSellPrice()
//                && this.delTime == ((Sandwich) obj).delTime
//                && this.level == ((Sandwich) obj).level
//                )
//            return true;
//
//        return false;
//    }

}

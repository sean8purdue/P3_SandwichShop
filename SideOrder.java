/**
 * Created by Sean on 3/6/16.
 */
public class SideOrder implements PurchasedItem {
    private String name;
    private double matCost;
    private double sellPrice;
    private int delTime; // Dellivery time cannot be a negative number
    private OrderSize size;

    public static double costSmall = 0.0;
    public static double costMedium = 0.40;
    public static double costLarge = 0.80;
    public static double costAbsurd = 1.50;

    public static double sellSmall = 0.0;
    public static double sellMedium = 2.00;
    public static double sellLarge = 3.00;
    public static double sellAbsurd = 4.50;

    // Default Constructor
    public SideOrder() {
        this.name = null;
        this.matCost = 0.0;
        this.sellPrice = 0.0;
        this.delTime = 0;
        this.size = OrderSize.SMALL;
    }

    public SideOrder(String name, double matCost, double sellPrice) {
        this();
        this.name = name;
        this.matCost = matCost;
        this.sellPrice = sellPrice;
    }

    public SideOrder(String name, double matCost, double sellPrice, int delTime) {
        this(name, matCost, sellPrice);
        this.delTime = delTime;
    }

    public SideOrder(String name, double matCost, double sellPrice, int delTime, OrderSize size) {
        this(name, matCost, sellPrice, delTime);
        this.size = size;
    }

    // Getter and Setter Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMatCost() {
        return matCost;
    }

    public void setMatCost(double matCost) {
        this.matCost = matCost;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getDelTime() {
        return delTime;
    }

    public void setDelTime(int delTime) {
        this.delTime = delTime;
    }

    public OrderSize getSize() {
        return size;
    }

    public void setSize(OrderSize size) {
        this.size = size;
    }

    @Override
    public boolean isDelivery() {
        if (this.delTime > 0 && this.delTime <= 30) {
            return true;
        }

        return false;
    }

    @Override
    public String getCustomerName() {
        return this.name;
    }

    @Override
    public int getDeliveryTime() {
        return this.delTime;
    }

    @Override
    public void setDeliveryTime(int time) {
        if (time > 0) {
            this.delTime = time;
        }
    }

    @Override
    public double getMaterialCost() {
        switch (this.size) {
            case SMALL:
                setMatCost(getMatCost() + costSmall);
                break;

            case MEDIUM:
                setMatCost(getMatCost() + costMedium);
                break;

            case LARGE:
                setMatCost(getMatCost() + costLarge);
                break;

            case ABSURD:
                setMatCost(getMatCost() + costAbsurd);
                break;

            default:
                //?1
                break;
        }

        return getMatCost();
    }

    @Override
    public double getSalePrice() {
        switch (this.size) {
            case SMALL:
                setSellPrice(getSellPrice() + sellSmall);
                break;

            case MEDIUM:
                setSellPrice(getSellPrice() + sellSmall);
                break;

            case LARGE:
                setSellPrice(getSellPrice() + sellLarge);
                break;

            case ABSURD:
                setSellPrice(getSellPrice() + sellAbsurd);
                break;

            default:
                //?
                break;
        }
        return getSellPrice();
    }

    @Override
    public boolean equals(Object obj) {
        //?2 why (Sandwich) obj.name
        //   not  obj.name;
        //?3 price are the same to the nearest cent??
        if (obj instanceof SideOrder
                && this.name.equals(((SideOrder) obj).name)
                && this.getMatCost() == ((SideOrder) obj).getMatCost()
                && this.getSellPrice() == ((SideOrder) obj).getSellPrice()
                && this.delTime == ((SideOrder) obj).delTime
                && this.size == ((SideOrder) obj).size
                )
            return true;

        return false;
    }


}

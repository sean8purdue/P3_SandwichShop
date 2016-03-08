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

    // Constructor Chaining
    public SideOrder(String name, double matCost, double sellPrice, int delTime, OrderSize size) {
        this.name = name;
        this.matCost = matCost;
        this.sellPrice = sellPrice;
        this.delTime = delTime;
        this.size = size;
    }

    public SideOrder(String name, double matCost, double sellPrice, int delTime) {
        this(name, matCost, sellPrice, delTime, OrderSize.SMALL);
    }

    public SideOrder(String name, double matCost, double sellPrice) {
        this(name, matCost, sellPrice, 0, OrderSize.SMALL);
    }

    // Getter and Setter Methods
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public double getMatCost() {
        return matCost;
    }

    public void setMatCost(double matCost) {
        if (matCost > 0)
            this.matCost = matCost;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        if (sellPrice > 0)
            this.sellPrice = sellPrice;
    }

//    public int getDelTime() {
//        return delTime;
//    }
//
//    public void setDelTime(int delTime) {
//        this.delTime = delTime;
//    }

    public OrderSize getOrderSize() {
        return size;
    }

    public void setOrderSize(OrderSize size) {
        if (size != null)
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
                setSellPrice(getSellPrice() + sellMedium);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SideOrder sideOrder = (SideOrder) o;

//        if (Double.compare(sideOrder.getMatCost(), getMatCost()) != 0) return false;
        if (!(Math.abs(getMatCost() - sideOrder.getMatCost()) < 0.01)) return false;
//        if (Double.compare(sideOrder.getSellPrice(), getSellPrice()) != 0) return false;
        if (!(Math.abs(getSellPrice() - sideOrder.getSellPrice()) < 0.01)) return false;
        if (delTime != sideOrder.delTime) return false;
        if (name != null ? !name.equals(sideOrder.name) : sideOrder.name != null) return false;
        return size == sideOrder.size;

    }

    //    @Override
//    public boolean equals(Object obj) {
//        //?2 why (Sandwich) obj.name
//        //   not  obj.name;
//        //?3 price are the same to the nearest cent??
//        if (obj instanceof SideOrder
//                && this.name.equals(((SideOrder) obj).name)
//                && this.getMatCost() == ((SideOrder) obj).getMatCost()
//                && this.getSellPrice() == ((SideOrder) obj).getSellPrice()
//                && this.delTime == ((SideOrder) obj).delTime
//                && this.size == ((SideOrder) obj).size
//                )
//            return true;
//
//        return false;
//    }


}

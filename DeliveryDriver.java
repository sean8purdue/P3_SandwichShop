import java.util.Arrays;

public class DeliveryDriver {

    // You can add instance variables as needed

    private String name;

    private double wage;

    private int maxCarriableItems;

    private int numDeliveries; //? no update

    private int minutesDelivering;

    private int numItems;

    private PurchasedItem[] items;

    public DeliveryDriver(String name, double wage, int maxCarriableItems) {
        // TO-DO
//        super();
        this.name = name;
        this.wage = wage;
        this.maxCarriableItems = maxCarriableItems;

        this.numDeliveries = 0;
        this.minutesDelivering = 0;
        this.numItems = 0;

        //?1 not sure how to initialize an object array;
        this.items = new PurchasedItem[maxCarriableItems];
    }

    public DeliveryDriver(String name, double wage) {
        // TO-DO
        this(name, wage, 5);
    }

    public DeliveryDriver(String name) {
        // TO-DO
        this(name, 7.25);
    }

    public String getName() {
        return this.name;
    }

    public double getWage() {
        return this.wage;
    }

    public int getTimeSpent() {
        return this.minutesDelivering;
    }

    /**
     * * Consults the number of orders that the driver has delivered
     * @return number of orders delivered
     */
    public int getNumDelivered() {
        return this.numDeliveries;
    }

    public int getMaxCapacity() {
        return this.maxCarriableItems;
    }


    /**
     * Add the order to the list/array of items to deliver.
     *
     * @param item - order to add
     * @return true if the item is for delivery and if the driver can
     * hold more orders, return false otherwise
     */
    public boolean pickupOrder(PurchasedItem item) {
        // TO-DO
        if (item.isDelivery() && numItems < maxCarriableItems) {
            items[numItems] = item;
            numItems++;
            return true;
            }

        return false;
    }

    /**
     * Returns the number of items in the delivery list
     *
     * @return num items
     */
    public int getNumOrders() {
        // TO-DO

        return this.numItems;
    }


    /** Return an array of items to deliver.
     * the array has to be populated within the index 0 to numItems - 1
     * and of size numItems
     *
     * @return array of type PurchasedItem
     * */
    public PurchasedItem[] getOrders() {
        // TO-DO
        PurchasedItem[] rt = new PurchasedItem[getNumOrders()];
        rt = Arrays.copyOf(items, items.length);

        return rt;
    }

    /**
     * Update how long the driver has been delivering and empty the
     * list of items to deliver.
     */
    public void deliverOrders() {
       // TO-DO
        if (numItems > 0) {
            for (int i = 0; i < numItems; i++) {
                minutesDelivering += items[i].getDeliveryTime();
            }

            //?3 empty the list of items
            for (int i = 0; i < numItems; i++) {
                items[i] = null;
            }
        }

    }

    /**
     * Check if driver is scheduled to deliver an order and remove it
     * and update the driver's counters if the item is found.
     *
     * @param item - order to remove from deliveries
     * @return true if the driver is scheduled to deliver the item,
     * 			false otherwise
     */
    public boolean removeOrder(PurchasedItem item) {
        // TO-DO
        if (numItems > 0) {
            for (int i = 0; i < numItems; i++) {
                //?2 how to know if two items equal??
                if (items[i] == item) {
                    for (int j = i + 1; j < numItems; j++) {
                        items[j-1] = items[j];
                    }
                    numItems--;

                    return true;
                }
            }
        }

        return false;
    }


    /**
     * Calculates the amount of money earned by the driver
     * @return amount of money earned by the driver
     */
    public double getMoneyEarned() {
        // TO-DO
        // convert minutes to hour and times Wage
        double hour;
        double money;
        hour = getTimeSpent() / 60.0;

        if (hour <= 8) {
            // base pay
            money = wage * hour;
        } else {
            // overtime pay
            money = wage * 8 + (hour - 8) * wage * 1.5;
        }

        return money;
    }

    /**
     * Compares if the input object is equal to the instance
     * Two objects are equal if they are of the same type and
     * all instance variables are equal.
     * @return true if they are, false if they are not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryDriver that = (DeliveryDriver) o;

//        if (Double.compare(that.getWage(), getWage()) != 0) return false;
        if (!(Math.abs(getWage() - that.getWage()) < 0.01)) return false;
        if (numDeliveries != that.numDeliveries) return false;
        if (minutesDelivering != that.minutesDelivering) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;

    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("Name: ");
        ret.append(this.name);

        ret.append(" - Wage: $");
        ret.append(String.format("%.2f", this.wage));

        ret.append(" - Can Carry: ");
        ret.append(this.maxCarriableItems);

        ret.append(" items - Num Deliveries: ");
        ret.append(this.numDeliveries);

        ret.append(" - Minutes Worked: ");
        ret.append(this.minutesDelivering);
        ret.append(" min");

        ret.append(" - Currently Carrying: ");
        ret.append(this.numItems);
        ret.append(" items");

        return ret.toString();
    }

}

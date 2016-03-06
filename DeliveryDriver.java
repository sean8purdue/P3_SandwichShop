
public class DeliveryDriver {

    // You can add instance variables as needed

    private String name;

    private double wage;

    private int maxCarriableItems;

    private int numDeliveries;

    private int minutesDelivering;

    private int numItems;

    private PurchasedItem[] items;

    public DeliveryDriver(String name, double wage, int maxCarriableItems) {
        // TO-DO
    }

    public DeliveryDriver(String name, double wage) {
        // TO-DO
    }

    public DeliveryDriver(String name) {
        // TO-DO
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

        return true;
    }

    /**
     * Returns the number of items in the delivery list
     *
     * @return num items
     */
    public int getNumOrders() {
        // TO-DO

        return 0;
    }


    /** Return an array of items to deliver.
     * the array has to be populated within the index 0 to numItems - 1
     * and of size numItems
     *
     * @return array of type PurchasedItem
     * */
    public PurchasedItem[] getOrders() {
        // TO-DO

        return null;
    }

    /**
     * Update how long the driver has been delivering and empty the
     * list of items to deliver.
     */
    public void deliverOrders() {
       // TO-DO
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

        return true;
    }


    /**
     * Calculates the amount of money earned by the driver
     * @return amount of money earned by the driver
     */
    public double getMoneyEarned() {
        // TO-DO

        return 0.0;
    }

    /**
     * Compares if the input object is equal to the instance
     * Two objects are equal if they are of the same type and
     * all instance variables are equal.
     * @return true if they are, false if they are not
     */
    @Override
    public boolean equals(Object obj) {
        // TO-DO

        return true;
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

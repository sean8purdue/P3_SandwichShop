
public class Store {

    // You can add instance variables as needed

    private String name;

    private double revenue;

    private double materialCosts;

    private DeliveryDriver[] drivers;

    public Store(String storeName, DeliveryDriver[] drivers) {
        // TO-DO
    }

    public Store(String storeName, int numDrivers) {
        // TO-DO
    }

    String getStoreName() {
        return this.name;
    }

    DeliveryDriver[] getDrivers() {
        return this.drivers;
    }

    /**
     * Updates the store's financial information. This function
     * handles assigning orders to drivers if it's a delivery and
     * manages sending drivers out on delivery.
     *
     * @param item - purchased item being ordered
     */
    public void placeOrder(PurchasedItem item) {
        // TO-DO
    }


    /**
     * Cancels an order with the store. It works under the assumption
     * that this order has already been placed. Also, this function
     * won't reduce the store's total material cost, as the item is
     * already made and wasted.
     * <p>
     *
     *  This method will only fail to cancel an order if the item is
     *  marked for delivery but the currently selected delivery driver
     *  isn't holding the item / can't remove the item (it has likely
     *  already been removed).
     *
     * @param item - the order to cancel
     * @return true if the order could be canceled, false otherwise
     */
    public boolean cancelOrder(PurchasedItem item) {
        // TO-DO

        return true;
    }

    /**
     * Getter method for a store's revenue.
     *
     * @return gross revenue
     */
    public double getGrossRevenue() {
        // TO-DO

        return 0.0;
    }

    /**
     * Getter method for a store's material costs.
     *
     * @return material costs
     */
    public double getMaterialCosts() {
        // TO-DO

        return 0.0;
    }

    /**
     * Calculates the store's net profit using one of these equivalent
     * equations:
     * <p>
     *
     * <i>profit = $(revenue) - $(period costs)</i>
     * <p>
     * <i>profit = $(revenue) - $(material costs) - $(labor costs)</i>
     *
     * @return the net operating profit of the store at this point in
     * time
     */
    public double getNetProfit() {
        // TO-DO

        return 0.0;
    }

    /**
     * Calculates the store's net income. The traditional formula
     * used to calculate net income is:
     * <p>
     *
     * <i>income = $(profit) - $(indirect costs)</i>
     *
     * @return net income
     */
    public double getNetIncome() {
        // TO-DO

        return 0.0;
    }



    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append(String.format("\nStore Info\n----------\nName: \"%s\"\n", this.name));
        ret.append(String.format("Revenue: $%.2f\nCosts: $%.2f\n", this.revenue, this.materialCosts));
        ret.append(String.format("Profit: $%.2f\nIncome: $%.2f\n", this.getNetProfit(), this.getNetIncome()));

        ret.append(String.format("\nDriver Info\n-----------\n"));
        int i = 1;
        for (DeliveryDriver driver : this.drivers)
            ret.append(String.format("%d.) %s\n", i++, driver.toString()));

        return ret.toString();
    }

    private void printStatistics(double expRevenue, double expProfit, double expIncome) {
        double revenue = this.getGrossRevenue();
        System.out.printf("Revenue: $%.2f\t\tExpected: $%.2f\t\t%% Diff: %f%%\n",
                revenue, expRevenue, percentDiff(expRevenue, revenue));

        double profit = this.getNetProfit();
        System.out.printf("Profit: $%.2f\t\tExpected: $%.2f\t\t%% Diff: %f%%\n",
                profit, expProfit, percentDiff(expProfit, profit));

        double income = this.getNetIncome();
        System.out.printf("Income: $%.2f\t\tExpected: $%.2f\t%% Diff: %f%%\n",
                income, expIncome, percentDiff(expIncome, income));
    }

    private static double percentDiff(double from, double to) {
        return Math.abs((to - from) / from * 100.0);
    }

}

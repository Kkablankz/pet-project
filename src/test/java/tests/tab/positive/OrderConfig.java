package tests.tab.positive;

public class OrderConfig {
    private static final String[] unknown = {"36","48","60"};
    private static int currentIteration = 0;
    private final int index;

    private static final String UNKNOWN1 = "unknown";
    private static final String UNKNOWN2 = "unknown";

    private static final int LOAN_START_PERIOD = 36;

    public OrderConfig() {
        if (currentIteration >= unknown.length) {
            currentIteration = 0;
        }
        this.index = currentIteration;
        currentIteration++;
    }

    public String getOrderPeriod() {
        return unknown[index];
    }

    public String getType() {
        return Integer.parseInt(unknown[index]) >= LOAN_START_PERIOD ? UNKNOWN1 : UNKNOWN2;
    }
}

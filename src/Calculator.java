public class Calculator implements PrintText {

    protected int count = 0;

    public void calc(PayForGameInterface payForGameInterface) {
        count += payForGameInterface.pay();
    }

    @Override
    public void printText() {
        System.out.format("==================================================\n" +
                "Number of purchased games - %d\n", count);
    }
}

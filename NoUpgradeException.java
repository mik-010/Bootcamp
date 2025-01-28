public class NoUpgradeException extends Exception{

    public NoUpgradeException() {
        super("Not enough items to upgrade");
    }
    public NoUpgradeException(String message) {
        super(message);
    }
}

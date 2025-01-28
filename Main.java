public class Main {
    public static void main(String[] args) throws NoUpgradeException {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Iron Sword", "Common"));
        inventory.addItem(new Item("Iron Sword", "Common"));
        inventory.addItem(new Item("Iron Sword", "Common"));

        inventory.addItem(new Item("Iron Sword", "Great"));
        inventory.addItem(new Item("Iron Sword", "Great"));
        inventory.addItem(new Item("Iron Sword", "Great"));

        inventory.addItem(new Item("Iron Sword", "Rare"));
        inventory.addItem(new Item("Iron Sword", "Rare"));
        inventory.addItem(new Item("Iron Sword", "Rare"));

        inventory.addItem(new Item("Sword", "Epic 2"));
        inventory.addItem(new Item("Sword", "Epic 2"));
        inventory.addItem(new Item("Sword", "Epic 2"));

        inventory.displayInventory();

        inventory.upgradeItem("Iron Sword","Common");
        inventory.upgradeItem("Sword","Epic 2");
        inventory.generateRandomItem("Iron Sword");
        inventory.generateRandomItem("Steel Shield");
        inventory.displayInventory();
    }
}
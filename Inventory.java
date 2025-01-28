import java.util.*;
import java.util.Random;

class Inventory {
    private Map<String, List<Item>> items; // Rarity -> List of Items
    private final String[] rarities = {"Common", "Great", "Rare", "Epic", "Legendary"};
    private final double[] probabilities = {0.5, 0.25, 0.15, 0.08, 0.02};

    public Inventory() {
        items = new HashMap<>();
    }

    // Adds a new item to the inventory
    public void addItem(Item item) {
        items.putIfAbsent(item.rarity, new ArrayList<>());
        items.get(item.rarity).add(item);
    }

    // Generates a random item based on weighted probabilities
    public void generateRandomItem(String itemName) {
        String rarity = getRandomRarity();
        Item randomItem = new Item(itemName, rarity);
        addItem(randomItem);
        System.out.println("Generated: " + randomItem);
    }

    // Gets a random rarity based on probabilities
    private String getRandomRarity() {
        Random random = new Random();
        double roll = random.nextDouble();
        double cumulativeProbability = 0.0;

        for (int i = 0; i < rarities.length; i++) {
            cumulativeProbability += probabilities[i];
            if (roll <= cumulativeProbability) {
                return rarities[i];
            }
        }
        return rarities[0]; // Default to "Common"
    }

    // Upgrades an item using its name and rarity
    public void upgradeItem(String itemName, String itemRarity) throws NoUpgradeException {
        if (!items.containsKey(itemRarity)) {
            throw new NoUpgradeException("No items of rarity: " + itemRarity);
        }
        List<Item> itemList = items.get(itemRarity);

        // Filters items to find those with the same name
        List<Item> matchingItems = new ArrayList<>();
        for (Item item : itemList) {
            if (item.name.equals(itemName)) {
                matchingItems.add(item);
            }
        }

        if (matchingItems.isEmpty()) {
            throw new NoUpgradeException("Item not found: " + itemName + " (" + itemRarity + ")");
        }

        if (!canUpgrade(matchingItems.size(), itemRarity)) {
            throw new NoUpgradeException("Not enough items to upgrade: " + itemName + " (" + itemRarity + ")");
        }

        performUpgrade(itemName, itemRarity, matchingItems);
        System.out.println("Upgraded: " + itemName + " (" + itemRarity + ")");
    }

    // Checks if there are enough items with the same name and rarity for an upgrade
    private boolean canUpgrade(int matchingItemCount, String rarity) {
        return switch (rarity) {
            case "Common", "Great", "Rare", "Epic 2" -> matchingItemCount >= 3;
            case "Epic", "Epic 1" -> matchingItemCount >= 2;
            default -> false;
        };
    }

    // Performs the upgrade and update the inventory
    private void performUpgrade(String itemName, String rarity, List<Item> matchingItems) {
        switch (rarity) {
            case "Common":
                removeItems(matchingItems, 3);
                addItem(new Item(itemName, "Great"));
                break;
            case "Great":
                removeItems(matchingItems, 3);
                addItem(new Item(itemName, "Rare"));
                break;
            case "Rare":
                removeItems(matchingItems, 3);
                addItem(new Item(itemName, "Epic"));
                break;
            case "Epic":
                removeItems(matchingItems, 2);
                addItem(new Item(itemName, "Epic 1"));
                break;
            case "Epic 1":
                removeItems(matchingItems, 2);
                addItem(new Item(itemName, "Epic 2"));
                break;
            case "Epic 2":
                removeItems(matchingItems, 3);
                addItem(new Item(itemName, "Legendary"));
                break;
            default:
                throw new IllegalArgumentException("Invalid rarity for upgrade: " + rarity);
        }
    }

    // Removes a specified number of items with the same name from the inventory
    private void removeItems(List<Item> matchingItems, int count) {
        for (int i = 0; i < count; i++) {
            Item item = matchingItems.get(i);
            items.get(item.rarity).remove(item);
        }
    }

    // Displays the inventory
    public void displayInventory() {
        for (String rarity : rarities) {
            List<Item> itemList = items.getOrDefault(rarity, new ArrayList<>());
            if (itemList.isEmpty()) {
                System.out.println(rarity + ":");
                System.out.println(" - Empty");
            } else {
                System.out.println(rarity + ":");
                for (Item item : itemList) {
                    System.out.println(" - " + item);
                }
            }
        }
    }
}

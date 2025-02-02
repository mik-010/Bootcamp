Compile the Code: javac Main.java Inventory.java Item.java NoUpgradeException.java

Run the Program: java Main

Assumptions:

The inventory stores items categorized by rarity.
Items of the same name and rarity are required for upgrades, except for certain Epic-tier upgrades.
Epic items can be upgraded incrementally (Epic → Epic 1 → Epic 2 → Legendary).
Epic and Epic 1 upgrades can be performed using any other Epic items, including Epic 2.
Random item generation follows predefined rarity probabilities.

Design Choices:

HashMap-based Inventory - The inventory is stored as a Map<String, List<Item>>, where the key is rarity and the value is a list of items.
Upgrade Process - Upgrades require a specific number of items to be removed and a new upgraded item to be added.
Exception Handling - NoUpgradeException is thrown when an upgrade is not possible.
Random Item Generation - A weighted probability system determines the rarity of newly generated items.

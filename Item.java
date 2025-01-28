public class Item{
    String name;
    String rarity;
    int upgradeCount;

    public Item(String name, String rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

        // Upgrade item based on its rarity and upgrade rules
    public void upgrade() {
        if (rarity.equals("Common")) {
            rarity = "Great";
        } else if (rarity.equals("Great")) {
            rarity = "Rare";
        } else if (rarity.equals("Rare")) {
            rarity = "Epic";
        } else if (rarity.equals("Epic")) {
            upgradeCount = 1;
            rarity = "Epic 1";
        } else if (rarity.equals("Epic 1")) {
            upgradeCount = 2;
            rarity = "Epic 2";
        } else if (rarity.equals("Epic 2")) {
            rarity = "Legendary";
        } else if(rarity.equals("Legendary")) {
            upgradeCount=0;
        } else {
            System.out.println("Cannot upgrade: Already Legendary");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}


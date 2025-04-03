package model;

/**
 * enumeration representing the various categories of inventory items.
 *
 * this enum is used to classify items without hardcoding category values throughout the system.
 * it improves maintainability and scalability, allowing categories to be easily updated.
 */
public enum CategoryType {

    // ===== General Categories =====
    CONSUMABLE("Consumable"),
    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    FURNITURE("Furniture"),
    OFFICE_SUPPLIES("Office Supplies"),
    BEAUTY_CARE("Beauty & Personal Care"),
    SPORTS_EQUIPMENT("Sports Equipment"),
    TOYS_GAMES("Toys & Games"),

    // ===== Manufacturing & Industrial =====
    MACHINERY("Machinery"),
    TOOLS("Tools & Equipment"),
    RAW_MATERIALS("Raw Materials"),
    SAFETY_EQUIPMENT("Safety Equipment"),
    AUTOMOTIVE_PARTS("Automotive Parts"),
    CHEMICALS("Chemicals & Industrial Supplies"),

    // ===== Food & Beverage =====
    PERISHABLES("Perishable Food"),
    NON_PERISHABLES("Non-Perishable Food"),
    DAIRY_PRODUCTS("Dairy Products"),
    MEAT_SEAFOOD("Meat & Seafood"),
    BEVERAGES("Beverages"),
    ALCOHOL("Alcoholic Beverages"),
    BAKERY("Bakery & Confectionery"),
    SNACKS("Snacks & Packaged Goods"),

    // ===== Medical & Pharmaceuticals =====
    MEDICATIONS("Medications & Drugs"),
    MEDICAL_EQUIPMENT("Medical Equipment"),
    FIRST_AID("First Aid Supplies"),
    PPE("Personal Protective Equipment"),
    LAB_SUPPLIES("Lab & Testing Equipment"),

    // ===== Technology & Electronics =====
    COMPUTERS("Computers & Laptops"),
    MOBILE_DEVICES("Mobile Phones & Tablets"),
    COMPUTER_COMPONENTS("Computer Components"),
    NETWORKING_EQUIPMENT("Networking Equipment"),
    AUDIO_VIDEO("Audio & Video Equipment"),
    GAMING_CONSOLES("Gaming Consoles & Accessories"),
    HOME_APPLIANCES("Home Appliances"),

    // ===== Books & Stationery =====
    BOOKS("Books & Educational Materials"),
    STATIONERY("Stationery & School Supplies"),

    // ===== Miscellaneous =====
    PET_SUPPLIES("Pet Supplies"),
    CLEANING_SUPPLIES("Cleaning & Hygiene Products"),
    JEWELLERY("Jewellery & Accessories"),
    MUSICAL_INSTRUMENTS("Musical Instruments"),
    ART_SUPPLIES("Art & Craft Supplies"),

    // Custom category for items not classified
    OTHER("Other");

    // ===== Enum Fields =====

    private final String categoryName;

    /**
     * constructor to assign a readable category name.
     *
     * @param categoryName the display name of the category.
     */
    CategoryType(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * returns the display name of the category.
     *
     * @return category display name.
     */
    public String getCategoryName() {
        return categoryName;
    }
}
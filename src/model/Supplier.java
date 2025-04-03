package model;

/**
 * model class representing a Supplier.
 *
 * each Supplier contains an ID, name, and contact information.
 * this class is used in Purchase Orders to associate items with their respective suppliers.
 */
public class Supplier {
    private final String supplierID;   // unique identifier for the supplier
    private final String name;         // supplier name
    private final String contactInfo;  // supplier contact information

    /**
     * constructor to initialize a Supplier object.
     *
     * @param supplierID  unique identifier for the supplier.
     * @param name        name of the supplier.
     * @param contactInfo contact information for the supplier.
     */
    public Supplier(String supplierID, String name, String contactInfo) {
        this.supplierID = supplierID;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // ======= Getters =======

    /**
     * returns the unique ID of the supplier.
     */
    public String getSupplierID() {
        return supplierID;
    }

    /**
     * returns the name of the supplier.
     */
    public String getName() {
        return name;
    }

    /**
     * returns the contact information of the supplier.
     */
    public String getContactInfo() {
        return contactInfo;
    }

    // ======= String Representation =======

    @Override
    public String toString() {
        return "Supplier: " + name + " (ID: " + supplierID + ", Contact: " + contactInfo + ")";
    }
}
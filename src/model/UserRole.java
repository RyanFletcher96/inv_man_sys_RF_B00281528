package model;

/**
 * enumeration representing user roles in the Inventory Management System.
 *
 * used to control role-based notifications and access permissions.
 * this allows for future extension and easier role management.
 */
public enum UserRole {
    INVENTORY_MANAGER,  // role for inventory managers (receives stock alerts)
    SUPPLIER,           // role for suppliers (receives order notifications)
    USER,               // general system user (could be used for read-only access)
    ADMIN               // administrator role (for system-wide privileges)
}
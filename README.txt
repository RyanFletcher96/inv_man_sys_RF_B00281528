# Inventory Management System

This is a Java-based Inventory Management System designed to handle inventory stock management, supplier orders, and automated reordering when stock falls below a specified threshold. It is built using object-oriented design principles and incorporates design patterns such as Singleton, Factory, Observer, and Facade.

---

## Features

- Add new inventory items with category, quantity, reorder threshold, price, and supplier.
- Automatically generate a purchase order when stock falls below the reorder threshold.
- Notify different users based on their role (Inventory Manager & Supplier) when reorders occur.
- Observer Pattern implemented for user role-based notifications.
- Prevents duplicate purchase orders.
- Tracks and manages suppliers.
- Provides clear console outputs for key actions.
- Includes Unit Testing (JUnit) and Independent Testing documentation.
- Follows ATRIP testing principles.

---

## Project Structure

- inventory_management_system/
  - model/
    - CategoryType.java
    - InventoryItem.java
    - PurchaseOrder.java
    - Supplier.java
    - UserRole.java
  - observer/
    - InventoryManagerObserver.java
    - StockObserver.java
    - SupplierObserver.java
  - service/
    - IdentificationGenerator.java
    - Inventory.java
    - InventoryFacade.java
    - InventoryItemFactory.java
    - NotificationHandler.java
    - OrderService.java
    - PurchaseOrderFactory.java
  - test/
    - InventoryTest.java
    - OrderServiceTest.java
  - README.txt
  - ITR_B00281528.docx


---

## How to Run

1. **Compile & Run**
   - Use IntelliJ IDEA, Eclipse, or any Java IDE.
   - Run the `TestHarness` class to see system functionality in action.

2. **Run Unit Tests**
   - Run `InventoryTest.java`, `OrderServiceTest.java` using JUnit 5.

---

## Testing

The project includes:
- **JUnit Unit Tests** (in `test/`) written in **Given-When-Then** format.
- **Independent Testing Report** following the **ATRIP** principles.

---

## Technologies Used

- Java 17+
- JUnit 5

---

## Author

Ryan Fletcher  
University of the West of Scotland | GRLA08002 - GA - Software Engineering

---

## License

This project is for academic purposes only.
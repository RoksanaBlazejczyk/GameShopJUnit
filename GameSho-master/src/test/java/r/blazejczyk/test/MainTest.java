package r.blazejczyk.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import r.blazejczyk.customer.*;
import r.blazejczyk.game.*;



import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Inventory inventory;
    private Manager manager;
    private Customer customer;
    private Type mario;
    private Type lemmings;
    private Type zelda;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        manager = new Manager("Sylvie");
        customer = new Customer(1, "Robert", "123 Street");

        mario = new Type("Mario", 50.00, ConsoleType.NINTENDO, 2020, 101, 1, 7);
        lemmings = new Type("Lemmings", 40.00, ComputerType.AMIGA, 1991, 102, 2, 3);
        zelda = new Type("Zelda", 70.00, ConsoleType.NINTENDO, 2021, 103, 3, 2);

        inventory.addGame(mario);
        inventory.addGame(lemmings);
        inventory.addGame(zelda);
    }

    // ------------------------
// MANAGER TESTS
// -----------------------------
    @Test
    @DisplayName("Manager can buy a game if total stock ≤ 10")
    void testManagerBuyGameWithinLimit() {
        boolean bought = manager.buyGame(inventory, mario, 2);
        assertTrue(bought, "Manager should be able to buy up to stock limit");
        assertEquals(9, mario.getQuantity());
    }

    @Test
    @DisplayName("Manager cannot buy game exceeding stock limit of 10")
    void testManagerBuyGameExceedsLimit() {
        boolean bought = manager.buyGame(inventory, mario, 5);
        assertFalse(bought, "Buying 5 more Mario should exceed stock limit");
    }

    @Test
    @DisplayName("Manager cannot buy with invalid (0 or negative) quantity")
    void testManagerBuyInvalidQuantity() {
        boolean resultZero = manager.buyGame(inventory, zelda, 0);
        boolean resultNegative = manager.buyGame(inventory, zelda, -3);
        assertFalse(resultZero);
        assertFalse(resultNegative);
    }

    // -----------------------------
// CUSTOMER TESTS
// -----------------------------
    @Test
    @DisplayName("Customer trade-in increases stock but cannot exceed 10")
    void testCustomerTradeIn() {
        TradeIn trade = new TradeIn(1, new Date());
        customer.makeTransaction(trade, inventory, mario);
        assertTrue(mario.getQuantity() <= 10);
    }

    @Test
    @DisplayName("Customer trade-in rejected when stock already full (10)")
    void testCustomerTradeInFullStock() {
        mario.setQuantity(10);
        TradeIn trade = new TradeIn(2, new Date());
        customer.makeTransaction(trade, inventory, mario);
        assertEquals(10, mario.getQuantity(), "Quantity must remain at 10 after failed trade-in");
    }

    @Test
    @DisplayName("Customer purchase reduces stock by 1")
    void testCustomerPurchaseReducesStock() {
        int before = zelda.getQuantity();
        Purchase purchase = new Purchase(3, new Date(), false);
        customer.makeTransaction(purchase, inventory, zelda);
        assertEquals(before - 1, zelda.getQuantity());
    }

    @Test
    @DisplayName("Customer purchase rejected if game is out of stock")
    void testCustomerPurchaseOutOfStock() {
        zelda.setQuantity(0);
        Purchase purchase = new Purchase(4, new Date(), false);
        customer.makeTransaction(purchase, inventory, zelda);
        assertEquals(0, zelda.getQuantity(), "No change expected if purchase failed");
    }

    @Test
    @DisplayName("Customer receives discount after trade-in and uses it on next purchase")
    void testCustomerDiscountFlow() {
        // Trade-in makes Robert eligible for discount
        TradeIn trade = new TradeIn(5, new Date());
        customer.makeTransaction(trade, inventory, mario);
        assertTrue(customer.isDiscountEligible());

        // Purchase should apply discount and then disable it
        Purchase purchase = new Purchase(6, new Date(), false);
        customer.makeTransaction(purchase, inventory, zelda);
        assertFalse(customer.isDiscountEligible(), "Discount should be reset after purchase");
    }

    // -----------------------------
// INVENTORY TESTS
// -----------------------------
    @Test
    @DisplayName("Inventory cannot exceed 10 of any game")
    void testInventoryQuantityLimit() {
        Type newMario = new Type("Mario", 50.00, ConsoleType.NINTENDO, 2020, 101, 1, 5);
        boolean added = inventory.addGame(newMario);
        assertFalse(added, "Adding 5 more Mario exceed limit (7 + 5 > 10)");
    }

    @Test
    @DisplayName("Inventory removeGame reduces quantity correctly")
    void testInventoryRemoveGame() {
        boolean removed = inventory.removeGame(lemmings, 2);
        assertTrue(removed);
        assertEquals(1, lemmings.getQuantity());
    }

    @Test
    @DisplayName("Inventory removeGame fails if not enough stock")
    void testInventoryRemoveGameNotEnoughStock() {
        boolean removed = inventory.removeGame(zelda, 5);
        assertFalse(removed);
        assertEquals(2, zelda.getQuantity());
    }
}
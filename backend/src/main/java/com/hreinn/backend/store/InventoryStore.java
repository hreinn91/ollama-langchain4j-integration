package com.hreinn.backend.store;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class InventoryStore {
    private final Map<Long, Inventory> inventory = new HashMap<>();
    public InventoryStore() {
        inventory.put(getNewId(), new Inventory("Adidas Shoes"));
        inventory.put(getNewId(), new Inventory("Nike Shoes"));
        inventory.put(getNewId(), new Inventory("Asics Shoes"));
    }

    @Tool("Get the all the inventory")
    public Collection<Inventory> getInventory() {
        return inventory.values();
    }

    public static long getNewId() {
        return (long) (Math.random() * 9000000000000000L);
    }

    public record Inventory(String name) {
    }

}

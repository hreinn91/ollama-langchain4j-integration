package com.hreinn.backend.store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryStoreTest {

    @Test
    void getNewId() {
        long newId = InventoryStore.getNewId();
    }
}
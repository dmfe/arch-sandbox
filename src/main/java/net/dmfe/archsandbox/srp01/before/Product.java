package net.dmfe.archsandbox.srp01.before;

import net.dmfe.archsandbox.srp01.Price;

class Product {
    int stock;
    Price price;

    void replenishStock(int amount) {
        stock += amount;
    }

    void setPrice(Price newPrice) {
        price = newPrice;
    }
}

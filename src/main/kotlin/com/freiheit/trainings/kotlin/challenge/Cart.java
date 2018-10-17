package com.freiheit.trainings.kotlin.challenge;

import java.math.BigDecimal;
import java.util.Map;

public class Cart {
    private String cartId;
    private Map<String, Item> items;
    private Price price;

    public Cart() {
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId( String cartId ) {
        this.cartId = cartId;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems( Map<String, Item> items ) {
        this.items = items;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice( Price price ) {
        this.price = price;
    }

    public static class Item {
        private String itemId;
        private Integer quantity;
        private Price price;

        public Item( String itemId, Integer quantity, Price price ) {
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId( String itemId ) {
            this.itemId = itemId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity( Integer quantity ) {
            this.quantity = quantity;
        }

        public Price getPrice() {
            return price;
        }

        public void setPrice( Price price ) {
            this.price = price;
        }
    }

    public static class Price {
        private final String currency;
        private final BigDecimal amount;

        public Price( String currency, BigDecimal amount ) {
            this.currency = currency;
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public BigDecimal getAmount() {
            return amount;
        }
    }
}

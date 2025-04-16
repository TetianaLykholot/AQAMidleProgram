package org.example;

public class CartRequest {
    private String id;
    private int quantity;

    public CartRequest(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public static class Builder {
        private String id;
        private int quantity;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartRequest build() {
            return new CartRequest(id, quantity);
        }
    }
}

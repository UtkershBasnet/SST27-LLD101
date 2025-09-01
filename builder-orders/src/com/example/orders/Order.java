package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        // defensive copy + unmodifiable wrapper
        this.lines = Collections.unmodifiableList(new ArrayList<>(builder.lines));
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    public String getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public boolean isExpedited() {
        return expedited;
    }

    public String getNotes() {
        return notes;
    }

    public int totalBeforeDiscount() {
        return lines.stream()
                .mapToInt(l -> l.getQuantity() * l.getUnitPriceCents())
                .sum();
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null)
            return base;
        return base - (base * discountPercent / 100);
    }

    // -------------------------------
    // Builder
    // -------------------------------
    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String email, OrderLine firstLine) {
            this.id = Objects.requireNonNull(id, "id");
            this.customerEmail = Objects.requireNonNull(email, "email");
            this.lines.add(Objects.requireNonNull(firstLine, "first line"));
        }

        public Builder addLine(OrderLine line) {
            lines.add(Objects.requireNonNull(line, "line"));
            return this;
        }

        public Builder discountPercent(Integer d) {
            this.discountPercent = d;
            return this;
        }

        public Builder expedited(boolean exp) {
            this.expedited = exp;
            return this;
        }

        public Builder notes(String n) {
            this.notes = n;
            return this;
        }

        public Order build() {
            // Validation centralized here
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email: " + customerEmail);
            }
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Invalid discount: " + discountPercent);
            }
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one line");
            }
            return new Order(this);
        }
    }
}

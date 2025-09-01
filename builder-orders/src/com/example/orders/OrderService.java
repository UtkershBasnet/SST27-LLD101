package com.example.orders;

import java.util.List;

public class OrderService {
    public Order createOrder(String id, String email, List<OrderLine> lines,
                             Integer discount, boolean expedited, String notes) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("must have at least one line");
        }
        Order.Builder builder = new Order.Builder(id, email, lines.get(0));
        for (int i = 1; i < lines.size(); i++) {
            builder.addLine(lines.get(i));
        }
        if (discount != null) builder.discountPercent(discount);
        if (expedited) builder.expedited(true);
        if (notes != null) builder.notes(notes);
        return builder.build();
    }
}
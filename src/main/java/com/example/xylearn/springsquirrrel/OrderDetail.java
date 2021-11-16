package com.example.xylearn.springsquirrrel;

public class OrderDetail {
    private int id;
    private int orderId;
    private OrderStatus detailStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(OrderStatus detailStatus) {
        this.detailStatus = detailStatus;
    }

    @Override
    public String toString() {
        return "子订单号：" + id + ", 订单状态：" + detailStatus;
    }
}
package com.example.xylearn.springsquirrrel;

import java.util.List;

public class Order {
    private int id;
    private OrderStatus status;
    List<OrderDetail> orderDetailList;

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "订单号：" + id + ", 订单状态：" + status;
    }
}
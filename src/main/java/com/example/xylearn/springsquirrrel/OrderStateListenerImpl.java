package com.example.xylearn.springsquirrrel;


import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("orderStateListener")
@WithStateMachine(name = "orderStateMachine")
public class OrderStateListenerImpl {
    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public boolean payTransition(Message<OrderStatusChangeEvent> message) {
         byte[] xiaoyaoByte111 = new byte[51024];
        Map<String,
                Object> map111  = new HashMap<>();

        map111.put("1",xiaoyaoByte111);

        Order order = (Order) message.getHeaders().get("order");
        System.out.println("支付：父订单逻辑操作");
        order.setStatus(OrderStatus.WAIT_DELIVER);
        System.out.println("支付：子订单逻辑操作");
        List<OrderDetail> orderDetailList = order.getOrderDetailList();
        orderDetailList.forEach(i -> i.setDetailStatus(OrderStatus.D_WAIT_DELIVER));

        System.out.println("支付，状态机反馈信息：" + message.getHeaders().toString());
        return true;
    }
    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public boolean deliverTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.WAIT_RECEIVE);
        System.out.println("发货，状态机反馈信息：" + message.getHeaders().toString());
        return true;
    }
    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public boolean receiveTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.FINISH);
        System.out.println("收货，状态机反馈信息：" + message.getHeaders().toString());
        return true;
    }
}
package com.example.xylearn.springsquirrrel;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService//, BeanPostProcessor
{
   static byte[] xiaoyaoByte = new byte[101024];
    static Map<String,Object> map  = new HashMap<>();
    static {
        map.put("1",xiaoyaoByte);
    }
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("After O1" + orderStateMachine);
        return arg0;
    }

    @Autowired
    private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine;
    @Autowired
    private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister;
    private int id = 1;
    private int detailId = 1;
    private Map<Integer, Order> orders = new HashMap<>();

    public Order create() {
        Order order = new Order();
        order.setStatus(OrderStatus.WAIT_PAYMENT);
        order.setId(id++);

        OrderDetail detail1 = new OrderDetail();
        detail1.setId(detailId++);
        detail1.setDetailStatus(OrderStatus.D_WAIT_PAYMENT);
        detail1.setOrderId(id);

        OrderDetail detail2 = new OrderDetail();
        detail2.setId(detailId++);
        detail2.setDetailStatus(OrderStatus.D_WAIT_PAYMENT);
        detail2.setOrderId(id);

        order.setOrderDetailList(Arrays.asList(detail1, detail2));
        orders.put(order.getId(), order);
        return order;
    }

    public Order pay(int id) {
        Order order = orders.get(id);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试支付，订单号：" + id);
        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED)
                .setHeader("order", order)
                .build();
        if (!sendEvent(message, order)) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 支付失败, 状态异常，订单号：" + id);
        }
        return orders.get(id);
    }

    public Order deliver(int id) {
        Order order = orders.get(id);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试发货，订单号：" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build(), orders.get(id))) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 发货失败，状态异常，订单号：" + id);
        }
        return orders.get(id);
    }

    public Order receive(int id) {
        Order order = orders.get(id);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试收货，订单号：" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build(), orders.get(id))) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 收货失败，状态异常，订单号：" + id);
        }
        return orders.get(id);
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    /**
     * 发送订单状态转换事件
     *
     * @param message
     * @param order
     * @return
     */
    private synchronized boolean sendEvent(Message<OrderStatusChangeEvent> message, Order order) {
        boolean result = false;
        try {
            orderStateMachine.start();
            //尝试恢复状态机状态
            persister.restore(orderStateMachine, order);
            //添加延迟用于线程安全测试
            Thread.sleep(1000);
            result = orderStateMachine.sendEvent(message);
            //持久化状态机状态
            persister.persist(orderStateMachine, order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            orderStateMachine.stop();
        }
        return result;
    }
}
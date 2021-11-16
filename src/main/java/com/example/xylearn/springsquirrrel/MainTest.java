package com.example.xylearn.springsquirrrel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.statemachine.StateMachine;
@SpringBootApplication
public class MainTest {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        ConfigurableApplicationContext context = SpringApplication.run(MainTest.class, args);
        OrderService orderService = (OrderService) context.getBean("orderService");
        Order order = orderService.create();
        orderService.pay(order.getId());
//        orderService.deliver(1);
//        orderService.receive(1);

//        new Thread("客户线程") {
//            @Override
//            public void run() {
//
//            }
//
//        }.start();
//        orderService.pay(2);
//        orderService.deliver(2);
//        orderService.receive(2);
        System.out.println("全部订单状态：" + orderService.getOrders());
    }
}

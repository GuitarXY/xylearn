package com.example.xylearn.springsquirrrel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;

/**
 * 订单状态机配置
 */
@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderStatusChangeEvent> {
    /**
     * 配置状态
     *
     * @param states
     * @throws Exception
     */
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvent> states) throws Exception {
        states.withStates()
                .initial(OrderStatus.WAIT_PAYMENT, new Action<OrderStatus, OrderStatusChangeEvent>() {
                    @Override
                    public void execute(StateContext<OrderStatus, OrderStatusChangeEvent> context) {
                        System.out.println("xy-一个父订单初始化了");
                        //后续可自动推动状态执行
                    }
                })
                .state(OrderStatus.WAIT_DELIVER, new Action<OrderStatus, OrderStatusChangeEvent>() {
                    @Override
                    public void execute(StateContext<OrderStatus, OrderStatusChangeEvent> context) {
                        System.out.println("xy-检查子订单是否已经到代发货状态");
                        Message<OrderStatusChangeEvent> message = context.getMessage();
                        Order order = (Order) message.getHeaders().get("order");
                        if (order.getOrderDetailList().stream().allMatch(i -> OrderStatus.D_WAIT_DELIVER.equals(i.getDetailStatus()))){
                            System.out.println("xy-检查子订单完成 -》 代发货状态");
                        }else {
                            context.getStateMachine().setStateMachineError(new Exception("有子订单未完成"));
                            context.getStateMachine().stop();
                        }
                    }
                })
                .states(EnumSet.allOf(OrderStatus.class))
                ;
    }
    /**
     * 配置状态转换事件关系
     *
     * @param transitions
     * @throws Exception
     */
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvent> transitions) throws Exception {
        transitions
                .withExternal().source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVER).event(OrderStatusChangeEvent.PAYED)
                .and()
                .withExternal().source(OrderStatus.WAIT_DELIVER).target(OrderStatus.WAIT_RECEIVE).event(OrderStatusChangeEvent.DELIVERY)
                .and()
                .withExternal().source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISH).event(OrderStatusChangeEvent.RECEIVED);
    }
    /**
     * 持久化配置
     * 实际使用中，可以配合redis等，进行持久化操作
     *
     * @return
     */
    @Bean
    public DefaultStateMachinePersister persister() {
        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object, Object, Order>() {
            @Override
            public void write(StateMachineContext<Object, Object> context, Order order) throws Exception {
                //此处并没有进行持久化操作
            }
            @Override
            public StateMachineContext<Object, Object> read(Order order) throws Exception {
                //此处直接获取order中的状态，其实并没有进行持久化读取操作
                return new DefaultStateMachineContext(order.getStatus(), null, null, null);
            }
        });
    }
}

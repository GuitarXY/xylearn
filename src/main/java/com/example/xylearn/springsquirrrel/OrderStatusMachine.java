//package com.example.xylearn.springsquirrrel;
//
//import org.springframework.messaging.Message;
//import org.springframework.statemachine.ExtendedState;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.statemachine.access.StateMachineAccessor;
//import org.springframework.statemachine.listener.StateMachineListener;
//import org.springframework.statemachine.state.State;
//import org.springframework.statemachine.transition.Transition;
//
//import java.util.Collection;
//import java.util.UUID;
//
//public class OrderStatusMachine implements StateMachine<OrderStatus, OrderStatusChangeEvent> {
//    @Override
//    public State<OrderStatus, OrderStatusChangeEvent> getInitialState() {
//        return null;
//    }
//
//    @Override
//    public ExtendedState getExtendedState() {
//        return null;
//    }
//
//    @Override
//    public StateMachineAccessor<OrderStatus, OrderStatusChangeEvent> getStateMachineAccessor() {
//        return null;
//    }
//
//    @Override
//    public void setStateMachineError(Exception e) {
//
//    }
//
//    @Override
//    public boolean hasStateMachineError() {
//        return false;
//    }
//
//    @Override
//    public UUID getUuid() {
//        return null;
//    }
//
//    @Override
//    public String getId() {
//        return null;
//    }
//
//    @Override
//    public void start() {
//
//    }
//
//    @Override
//    public void stop() {
//
//    }
//
//    @Override
//    public boolean sendEvent(Message<OrderStatusChangeEvent> message) {
//        return false;
//    }
//
//    @Override
//    public boolean sendEvent(OrderStatusChangeEvent orderStatusChangeEvent) {
//        return false;
//    }
//
//    @Override
//    public State<OrderStatus, OrderStatusChangeEvent> getState() {
//        return null;
//    }
//
//    @Override
//    public Collection<State<OrderStatus, OrderStatusChangeEvent>> getStates() {
//        return null;
//    }
//
//    @Override
//    public Collection<Transition<OrderStatus, OrderStatusChangeEvent>> getTransitions() {
//        return null;
//    }
//
//    @Override
//    public boolean isComplete() {
//        return false;
//    }
//
//    @Override
//    public void addStateListener(StateMachineListener<OrderStatus, OrderStatusChangeEvent> stateMachineListener) {
//
//    }
//
//    @Override
//    public void removeStateListener(StateMachineListener<OrderStatus, OrderStatusChangeEvent> stateMachineListener) {
//
//    }
//}

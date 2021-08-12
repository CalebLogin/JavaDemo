package com.caleb.demo;

/**
 * @author：hanzhigang
 * @Date : 2021/1/23 6:24 PM
 */
public enum PizzaDeliverySystemConfiguration {
    INSTANCE;
    PizzaDeliverySystemConfiguration(){

    }

    public PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

    public PizzaDeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }
    public PizzaDeliverySystemConfiguration getInstance(){
        return INSTANCE;
    }
}

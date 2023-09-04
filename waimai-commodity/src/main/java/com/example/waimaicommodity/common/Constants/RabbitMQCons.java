package com.example.waimaicommodity.common.Constants;

public final class RabbitMQCons {

    private RabbitMQCons(){}

    public static final String ORDER_EXCHANGE = "order.exchange";
    public static final String ORDER_QUEUE = "order.queue";
    public static final String DEAD_LETTER_EXCHANGE = "dead-letter.exchange";
    public static final String DEAD_LETTER_QUEUE = "dead-letter.queue";
}

/*
package com.example.coffee.utils.kafka;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

*/
/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: ConcurrentKafkaListenerContainerFactoryConfigurer
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/11/24 17:01
 *//*

public class ConcurrentKafkaListenerContainerFactoryConfigurer {
    private KafkaProperties properties;

    */
/**
     * Set the {@link KafkaProperties} to use.
     * @param properties the properties
     *//*

    void setKafkaProperties(KafkaProperties properties) {
        this.properties = properties;
    }

    */
/**
     * Configure the specified Kafka listener container factory. The factory can be
     * further tuned and default settings can be overridden.
     * @param listenerContainerFactory the {@link ConcurrentKafkaListenerContainerFactory}
     * instance to configure
     * @param consumerFactory the {@link ConsumerFactory} to use
     *//*

    public void configure(
            ConcurrentKafkaListenerContainerFactory<Object, Object> listenerContainerFactory,
            ConsumerFactory<Object, Object> consumerFactory) {
        listenerContainerFactory.setConsumerFactory(consumerFactory);
        KafkaProperties.Listener container = this.properties.getListener();
        ContainerProperties containerProperties = listenerContainerFactory
                .getContainerProperties();
        if (container.getAckMode() != null) {
            containerProperties.setAckMode(container.getAckMode());
        }
        if (container.getAckCount() != null) {
            containerProperties.setAckCount(container.getAckCount());
        }
        if (container.getAckTime() != null) {
            containerProperties.setAckTime(container.getAckTime());
        }
        if (container.getPollTimeout() != null) {
            containerProperties.setPollTimeout(container.getPollTimeout());
        }
        if (container.getConcurrency() != null) {
            listenerContainerFactory.setConcurrency(container.getConcurrency());
        }
    }
}
*/

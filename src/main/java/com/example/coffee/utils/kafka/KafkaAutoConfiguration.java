//package com.example.coffee.utils.kafka;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.kafka.core.*;
//import org.springframework.kafka.support.LoggingProducerListener;
//import org.springframework.kafka.support.ProducerListener;
//
///**
// * @version v1.0
// * @ProjectName: coffee
// * @ClassName: KafkaAutoConfiguration
// * @Description: TODO(一句话描述该类的功能)
// * @Author: 李茜骏
// * @Date: 2020/11/24 17:03
// */
//@Configuration
//@ConditionalOnClass(KafkaTemplate.class)
//@EnableConfigurationProperties(KafkaProperties.class)
//@Import(KafkaAnnotationDrivenConfiguration.class)
//public class KafkaAutoConfiguration {
//    private final KafkaProperties properties;
//
//    public KafkaAutoConfiguration(KafkaProperties properties) {
//        this.properties = properties;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(KafkaTemplate.class)
//    public KafkaTemplate<?, ?> kafkaTemplate(
//            ProducerFactory<Object, Object> kafkaProducerFactory,
//            ProducerListener<Object, Object> kafkaProducerListener) {
//        KafkaTemplate<Object, Object> kafkaTemplate = new KafkaTemplate<Object, Object>(
//                kafkaProducerFactory);
//        kafkaTemplate.setProducerListener(kafkaProducerListener);
//        kafkaTemplate.setDefaultTopic(this.properties.getTemplate().getDefaultTopic());
//        return kafkaTemplate;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(ProducerListener.class)
//    public ProducerListener<Object, Object> kafkaProducerListener() {
//        return new LoggingProducerListener<Object, Object>();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(ConsumerFactory.class)
//    public ConsumerFactory<?, ?> kafkaConsumerFactory() {
//        return new DefaultKafkaConsumerFactory<Object, Object>(
//                this.properties.buildConsumerProperties());
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(ProducerFactory.class)
//    public ProducerFactory<?, ?> kafkaProducerFactory() {
//        return new DefaultKafkaProducerFactory<Object, Object>(
//                this.properties.buildProducerProperties());
//    }
//}

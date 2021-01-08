//package com.example.coffee.utils.kafka;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.KafkaListenerConfigUtils;
//import org.springframework.kafka.core.ConsumerFactory;
//
///**
// * @version v1.0
// * @ProjectName: coffee
// * @ClassName: KafkaAnnotationDrivenConfiguration
// * @Description: TODO(一句话描述该类的功能)
// * @Author: 李茜骏
// * @Date: 2020/11/24 17:03
// */
//@Configuration
//@ConditionalOnClass(EnableKafka.class)
//public class KafkaAnnotationDrivenConfiguration {
//    private final KafkaProperties properties;
//
//    KafkaAnnotationDrivenConfiguration(KafkaProperties properties) {
//        this.properties = properties;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public ConcurrentKafkaListenerContainerFactoryConfigurer kafkaListenerContainerFactoryConfigurer() {
//        ConcurrentKafkaListenerContainerFactoryConfigurer configurer = new ConcurrentKafkaListenerContainerFactoryConfigurer();
//        configurer.setKafkaProperties(this.properties);
//        return configurer;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(name = "kafkaListenerContainerFactory")
//    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
//            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
//            ConsumerFactory<Object, Object> kafkaConsumerFactory) {
//        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
//        configurer.configure(factory, kafkaConsumerFactory);
//        return factory;
//    }
//
//    @EnableKafka
//    @ConditionalOnMissingBean(name = KafkaListenerConfigUtils.KAFKA_LISTENER_ANNOTATION_PROCESSOR_BEAN_NAME)
//    protected static class EnableKafkaConfiguration {
//
//    }
//}

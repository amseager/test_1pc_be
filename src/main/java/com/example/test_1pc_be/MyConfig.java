package com.example.test_1pc_be;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.cloud.stream.binder.BinderFactory;
import org.springframework.cloud.stream.binder.kafka.KafkaMessageChannelBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.kafka.transaction.KafkaTransactionManager;
import org.springframework.messaging.MessageChannel;

@Configuration
public class MyConfig {

  /**
   * https://docs.spring.io/spring-cloud-stream-binder-kafka/docs/current/reference/html/spring-cloud-stream-binder-kafka.html#kafka-transactional-binder
   * https://stackoverflow.com/a/68201937/5572007
   */


  @Bean
  SmartInitializingSingleton ktmProvider(BinderFactory binders, GenericApplicationContext context) {
    return () -> {
      context.registerBean("kafkaTransactionManager", KafkaTransactionManager.class,
          ((KafkaMessageChannelBinder) binders.getBinder(null, MessageChannel.class))
              .getTransactionalProducerFactory());
    };
  }

  //@Bean
  //@Primary
  //public KafkaTransactionManager kafkaTransactionManager(BinderFactory binders) {
  //  ProducerFactory<byte[], byte[]> pf = ((KafkaMessageChannelBinder) binders.getBinder(null,
  //      MessageChannel.class)).getTransactionalProducerFactory();
  //  return new KafkaTransactionManager<>(pf);
  //}
}

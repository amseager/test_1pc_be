package com.example.test_1pc_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test1pcBeApplication {

  public static void main(String[] args) {
    SpringApplication.run(Test1pcBeApplication.class, args);
  }

  //@Bean
  //public PlatformTransactionManager kafkaTransactionManager(BinderFactory binders) {
  //  ProducerFactory<byte[], byte[]> pf = ((KafkaMessageChannelBinder) binders.getBinder(null,
  //      MessageChannel.class)).getTransactionalProducerFactory();
  //  return new KafkaTransactionManager<>(pf);
  //}

}

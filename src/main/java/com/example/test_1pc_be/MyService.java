package com.example.test_1pc_be;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyService {

  private final TempRepository tempRepository;
  //private final StreamBridge streamBridge;
  private final KafkaTemplate<String, String> kafkaTemplate;
  //private final DataSourceTransactionManager dataSourceTransactionManager;

  @Transactional(transactionManager = "transactionManager")
  public Temp getTemp() {
    final Temp temp = new Temp();
    temp.setName("test");
    final Temp saved = tempRepository.save(temp);

    //streamBridge.send("stock-out-0", temp);
    kafkaTemplate.send("test_1pc_be", temp.toString());

    System.out.println(saved);

    if (true) {
      throw new RuntimeException();
    }
    return temp;
  }
}

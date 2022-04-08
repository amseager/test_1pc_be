package com.example.test_1pc_be;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyService {

  private final TempRepository tempRepository;
  private final StreamBridge streamBridge;

  @Transactional
  public Temp getTemp() {
    final Temp temp = new Temp();
    temp.setName("test");
    final Temp saved = tempRepository.save(temp);

    streamBridge.send("stock-out-0", temp);

    System.out.println(saved);

    //if (true) {
    //  throw new RuntimeException();
    //}
    return temp;
  }
}

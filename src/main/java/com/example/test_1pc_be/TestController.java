package com.example.test_1pc_be;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {


  private final MyService myService;


  @GetMapping("/")
  public Temp test() {
    final Temp saved = myService.getTemp();
    return saved;
  }
}

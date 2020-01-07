package doraemon.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

  @GetMapping("/test")
  public String get() {
    System.out.println("123");
    return "123";
  }

  @PostMapping("/scf-front/order-add")
  public String post(@RequestBody TestEntity testEntity) {
    System.out.println(testEntity.toString());
    return "123";
  }
}

package doraemon.api;

import com.google.common.collect.Maps;
import doraemon.entity.TestEntity;
import java.util.Map;
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

  @PostMapping("/add")
  public Map<String, String> post(@RequestBody TestEntity testEntity) {

    System.out.println(testEntity.toString());
    Map<String, String> responseBody = Maps.newHashMapWithExpectedSize(1);
    responseBody.put("格式化后的明文内容", testEntity.toString());
    return responseBody;
  }
}

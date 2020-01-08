package doraemon;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringGsonTests {

  @Autowired
  private Gson gson;

  @Test
  public void test(){
    Map<String ,Integer> object = Maps.newHashMapWithExpectedSize(2);
    object.put("做个真的我",1);
    object.put("爱江山更爱美人",2);

    String json = gson.toJson(object);
    System.out.println(json);
  }

}

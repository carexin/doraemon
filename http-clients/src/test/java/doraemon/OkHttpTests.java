package doraemon;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OkHttpTests {

  @Autowired
  OkHttpClient client;

  @Test
  public void test() throws IOException {
    String json = "{\"field\":\"123uensu\"}";
    String url = "https://localhost:8000/scf-front/order-add";
    MediaType JSON = MediaType.get("application/json; charset=utf-8");

    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder().url(url).post(body).build();
    String result;
    try (Response response = client.newCall(request).execute()) {
      assert response.body() != null;
      result = response.body().string();
    }

    System.out.println(result);
  }
}

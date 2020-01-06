package doraemon;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpTests {

  public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

  public static void main(String[] args) throws IOException {

    OkHttpClient client = new OkHttpClient();

    String json = "{\"field\":\"123uensu\"}";
    String url = "http://localhost:8000/scf-front/order-add";

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

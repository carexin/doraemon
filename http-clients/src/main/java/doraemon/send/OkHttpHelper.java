package doraemon.send;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Component;

@Component
public class OkHttpHelper {

  public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

  private final OkHttpClient client;

  public OkHttpHelper(OkHttpClient client) {
    this.client = client;
  }

  public String post(String url, String json) throws IOException {
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
        .url(url)
        .post(body)
        .build();
    try (Response response = client.newCall(request).execute()) {
      assert response.body() != null;
      return response.body().string();
    }
  }
}

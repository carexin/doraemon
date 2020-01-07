package doraemon.send;

import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class SendService {

  private final OkHttpHelper okHttpHelper;

  public SendService(OkHttpHelper okHttpHelper) {
    this.okHttpHelper = okHttpHelper;
  }

  public void httpSend(String url, String json) throws IOException {
    String result = okHttpHelper.post(url, json);

    System.out.println(result);
  }

}

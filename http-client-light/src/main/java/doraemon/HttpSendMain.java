package doraemon;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpSendMain {

  public static void main(String[] args) {

    HttpClient client = createHttpClient(
        args[0],
        Integer.parseInt(args[1])
    );

    PostMethod post = new PostMethod("");
    post.setRequestBody("");
  }



  public static HttpClient createHttpClient(String host, int port) {
    HttpClient client = new HttpClient();
    client.getHostConfiguration().setProxy(host, port);

    return client;
  }

}

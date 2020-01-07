package doraemon;

import doraemon.send.SendService;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * https https://localhost:8000/scf-front/order-add  {\"field\":\"123uensu\"}
 */
@SpringBootApplication
public class Application {

  /**
   * @param args methodName json字符串
   */
  public static void main(String[] args) throws IOException {
    ApplicationContext context = SpringApplication.run(Application.class, args);

    SendService sendService = context.getBean(SendService.class);

    if (args.length < 3) {
      System.out.println("传两个参数, 1http/https, 2url, 3json字符串");
      return;
    }

    if ("https".equals(args[0])) {
      System.out.println("https请求, 开发发送");
      sendService.httpSend(args[1], args[2]);
    }
  }
}

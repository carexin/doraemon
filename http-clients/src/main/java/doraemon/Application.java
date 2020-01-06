package doraemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  /**
   * @param args methodName json字符串
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    if (args.length < 2) {
      System.out.println("传两个参数, 1方法名称, 2json字符串");
      return;
    }
    System.out.println(args[0]);
    System.out.println(args[1]);

  }
}

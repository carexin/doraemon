package doraemon.config;

import doraemon.encrypt.CustomEncryptHttpMessageConverter;
import java.util.Collections;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * @author carexin@qq.com
 */
@Configuration
public class SpringMvcConfig {

  /**
   * 自定义的解析
   *
   * @return
   */
  @Bean
  public HttpMessageConverters httpMessageConverters() {
    HttpMessageConverter<Object> converter = new CustomEncryptHttpMessageConverter();
    return new HttpMessageConverters(Collections.singletonList(converter));
  }
}

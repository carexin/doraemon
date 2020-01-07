package doraemon.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "proxy")
@Configuration
public class ProxyProperties {

  private String host;
  private Integer port;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }
}

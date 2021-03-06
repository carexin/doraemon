package doraemon.config;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttpConfig {

  private final ProxyProperties proxyProperties;

  public OkHttpConfig(ProxyProperties proxyProperties) {
    this.proxyProperties = proxyProperties;
  }

  /**
   * 可以自定义校验过程, 不满足就抛出接口中推荐的异常.
   */
  @Bean
  public X509TrustManager x509TrustManager() {
    return new X509TrustManager() {
      @Override
      public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
      }

      @Override
      public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
      }

      @Override
      public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
      }
    };
  }


  @Bean
  public HostnameVerifier hostnameVerifier() {
    return (s, sslSession) -> true;
  }

  @Bean
  public SSLSocketFactory sslSocketFactory()
      throws NoSuchAlgorithmException, KeyManagementException {
    SSLContext sslContext = SSLContext.getInstance("TLS");
    TrustManager[] trustManagers = {x509TrustManager()};
    sslContext.init(null, trustManagers, new SecureRandom());

    return sslContext.getSocketFactory();
  }

  @Bean
  public Proxy proxy() {
    return new Proxy(
        Type.HTTP,
        new InetSocketAddress(proxyProperties.getHost(), proxyProperties.getPort())
    );
  }

  @Bean
  public OkHttpClient okHttpClient() throws KeyManagementException, NoSuchAlgorithmException {

    System.out.println(proxyProperties.getHost());
    return new OkHttpClient.Builder()
        .sslSocketFactory(sslSocketFactory(), x509TrustManager())
        .proxy(proxy())
        .hostnameVerifier(hostnameVerifier())
        .build();
  }


}

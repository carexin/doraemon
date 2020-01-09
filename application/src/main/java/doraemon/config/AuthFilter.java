package doraemon.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author carexin@qq.com
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    log.debug("---- 执行了auth过滤器 ----");

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    String token = httpServletRequest.getHeader("token");

    if ("12345".equals(token)) {
      chain.doFilter(request, response);
    } else {
      // todo 记录请求这的ip
      log.error("--- 不合法的请求 ---");
    }
  }
}

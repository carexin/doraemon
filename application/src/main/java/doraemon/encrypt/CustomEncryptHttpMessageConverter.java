package doraemon.encrypt;

import doraemon.util.EncryptUtils;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * custom http message converter
 *
 * @author carexin@qq.com
 */
@Slf4j
public class CustomEncryptHttpMessageConverter extends GsonHttpMessageConverter {

  /**
   * @param resolvedType
   * @param reader
   * @return
   * @throws Exception
   */
  @Override
  protected Object readInternal(Type resolvedType, Reader reader) throws Exception {
    logger.info("--- 执行了自定义的http json消息转换 --- ");
    EncryptModel encryptModel = super.getGson().fromJson(reader, EncryptModel.class);
    logger.info(encryptModel.toString());
    String data = EncryptUtils.SINGLETON.decryptByAes(encryptModel.getData());
    logger.info(data);
    return super.readInternal(resolvedType, new StringReader(data));
  }
}

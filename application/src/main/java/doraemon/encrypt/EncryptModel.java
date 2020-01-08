package doraemon.encrypt;

import java.lang.reflect.Type;
import lombok.Data;

/**
 * @author carexin@qq.com
 */
@Data
public class EncryptModel implements Type {

  private String sign;
  private Long timestamp;
  private String data;
}

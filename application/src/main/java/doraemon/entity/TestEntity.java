package doraemon.entity;

import com.google.gson.Gson;
import doraemon.util.EncryptUtils;

public class TestEntity {

  private String field;

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  @Override
  public String toString() {
    return "TestEntity{" + "field='" + field + '\'' + '}';
  }

  public static void main(String[] args) throws Exception {
    TestEntity testEntity = new TestEntity();
    testEntity.setField("这是一条测试数据少时诵诗书所所所所所所所所所所所所所所所所所所所所所所所");
    Gson gson = new Gson();

    System.out.println(EncryptUtils.SINGLETON.encryptByAes(
        gson.toJson(testEntity)
    ));
  }
}

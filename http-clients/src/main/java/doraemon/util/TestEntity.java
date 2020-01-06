package doraemon.util;

import com.google.gson.Gson;

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

  public static void main(String[] args) {
    TestEntity testEntity = new TestEntity();
    testEntity.setField("123uensu");
    Gson gson = new Gson();
    String json = gson.toJson(testEntity);
    System.out.println(json);
  }
}

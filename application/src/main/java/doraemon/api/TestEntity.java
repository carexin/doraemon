package doraemon.api;

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
}

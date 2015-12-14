package step07.ex15;

public class Customer2 {
  private String name;
  private boolean gender;
  private int age;
  private float height;
  private float weight;
  private float fatRate;

  @Override
  public String toString() {
    return "Customer [name=" + name + ", gender=" + gender + ", age=" + age + ", height=" + height + ", weight="
        + weight + ", fatRate=" + fatRate + "]";
  }

  // 인스턴스의 값을 넣는 메서드 제공
  // => set으로 메서드 이름을 시작한다.
  // => 셋터(setter) 메서드라 부른다.
  public void setName(String name) {
    if (name == null)
      this.name = "홍길동";
    else
      this.name = name;
  }

  public void setGender(boolean gender) {
    this.gender = gender;
  }

  public void setAge(int age) {
    if (age > 13 && age < 100)
      this.age = age;
    else
      this.age = 30;
  }

  public void setHeight(float height) {
    if (height > 0 && height < 200)
      this.height = height;
    else
      this.height = 170;
  }

  public void setWeight(float weight) {
    if (weight > 0 && weight < 200)
      this.weight = weight;
    else
      this.weight = 65;
  }

  public void setFatRate(float fatRate) {
    if (fatRate > 0 && fatRate < 70)
      this.fatRate = fatRate;
    else
      this.fatRate = 25;
  }

  // 인스턴스의 값을 꺼내는 메서드 제공
  // => get으로 메서드 이름을 시작한다.
  // => 갯터(getter)라 부른다.

  public String getName() {
    return this.name;
  }

  public boolean isGender() {
    return this.gender;
  }

  public int getAge() {
    return this.age;
  }

  public float getHeight() {
    return this.height;
  }

  public float getWeight() {
    return this.weight;
  }

  public float getFatRate() {
    return this.fatRate;
  }

}

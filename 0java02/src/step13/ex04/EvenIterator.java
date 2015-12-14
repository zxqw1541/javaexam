package step13.ex04;

public class EvenIterator extends AbstractIterator {
  LinkedList list;
  int cursor;
  
  public EvenIterator(LinkedList list) {
    this.list = list;
  }

  public boolean hasNext() {
    // 안에서는 바깥을 볼 수 있다.
    // 멤버 이너 클래스는 바깥 클래스의 맴버(인수턴스 변수와 인스턴스 메서드)를 사용 할 수 있다.
    if (cursor < list.size()) // 안에서는 바깥을 볼 수 있다.
      return true;
    return false;
  }

  public Object next() {
    int i = cursor;
    cursor += 2;
    return list.get(i);
  }

}
package step13.ex05;

public class LinkedList {
  
  // 탑 레벨 이너 클래스
  private static class Bucket {
    protected Object value;
    protected Bucket next;
    
    public Bucket() {}
    
    public Bucket(Object value) {
      this.value = value;
    }
    
    public Bucket(Object value, Bucket next) {
      this(value);
      this.next = next;        
    }

    public Object getValue() {
      return value;
    }

    public void setValue(Object value) {
      this.value = value;
    }

    public Bucket getNext() {
      return next;
    }

    public void setNext(Bucket next) {
      this.next = next;
    }
  }
  
  // 멤버 이너 클래스
  public abstract class AbstractIterator {
    public abstract boolean hasNext();
    public abstract Object next();
  }
  
  private Bucket start;
  private Bucket end;
  private int length;

  public LinkedList() {
    start = new Bucket();
    end = start;
  }

  public int add(Object value) {
    end.setValue(value);
    end.setNext(new Bucket());
    end = end.getNext();
    length++;

    return 0;
  }

  public Object get(int index) {
    if (index < 0 || index >= length)
      return null;

    Bucket cursor = start;
    int pos = 0;
    while (pos < index) {
      cursor = cursor.getNext();
      pos++;
    }

    return cursor.getValue();
  }

  public Object remove(int index) {
    if (index < 0 || index >= length)
      return null;

    Object removedValue = null;
    
    if (index == 0) {
      removedValue = start.getValue();
      start = start.getNext();
    } else {

      Bucket cursor = start;
      int pos = 0;
      while (pos < index - 1) {
        cursor = cursor.getNext();
        pos++;
      }
      removedValue = cursor.getNext().getValue();
      cursor.setNext(cursor.getNext().getNext());
    }
    length--;

    return removedValue;
  }
  
  public int size () {
    return length;
  }
  
  public AbstractIterator iterator(String type) {
    // 로컬 이너 클래스 - 특정 메서드에서만 사용하는 클래스
    // => 쓸데없이 공개 범위를 넓힐 필요는 없다.
    // => 가능한 한 사용 범위를 좁히는 것이 다른 클래스와의 간섭이나 충돌을 막을 수 있다.
    // => 로컬 멤버(변수,클래스)는 public, private, protected 등의 
    //    접근 제어를 할 수 없다.
    class EvenIterator extends AbstractIterator {
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
    
    class ReverseIterator extends AbstractIterator {
      LinkedList list;
      int cursor;
      
      public ReverseIterator(LinkedList list) {
        this.list = list;
        cursor = list.size() - 1;
      }

      public boolean hasNext() {
        // 안에서는 바깥을 볼 수 있다.
        // 멤버 이너 클래스는 바깥 클래스의 맴버(인수턴스 변수와 인스턴스 메서드)를 사용 할 수 있다.
        if (cursor >= 0) // 안에서는 바깥을 볼 수 있다.
          return true;
        return false;
      }

      public Object next() {
        return list.get(cursor--);
      }

    }
    
    if (type.equals("even")) {
      return new EvenIterator(this);
    } else {
      return new ReverseIterator(this);
    }
  }
}

package step13.ex07;

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
  
  // 멤버 이너 인터페이스
  public interface Iterator {
    boolean hasNext();
    Object next();
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
  
  // 익명 이너클래스는 상속과 구현을 같이 못함. 둘중 하나만 가능
  public Iterator iterator(String type) {
    
    if (type.equals("even")) {
      return new Iterator() {
        int cursor;

        public boolean hasNext() {
          // 안에서는 바깥을 볼 수 있다.
          // 멤버 이너 클래스는 바깥 클래스의 맴버(인수턴스 변수와 인스턴스 메서드)를 사용 할 수 있다.
          if (cursor < LinkedList.this.size()) // 안에서는 바깥을 볼 수 있다.
            return true;
          return false;
        }

        public Object next() {
          int i = cursor;
          cursor += 2;
          return LinkedList.this.get(i);
        }
      };
    } else {
      return new Iterator() {
        int cursor;
        { // 인스턴스 블록
          cursor = LinkedList.this.size() -1;
        }
        
        public boolean hasNext() {
          // 안에서는 바깥을 볼 수 있다.
          // 멤버 이너 클래스는 바깥 클래스의 맴버(인수턴스 변수와 인스턴스 메서드)를 사용 할 수 있다.
          if (cursor >= 0) // 안에서는 바깥을 볼 수 있다.
            return true;
          return false;
        }

        public Object next() {
          return LinkedList.this.get(cursor--);
        }

      };
    }
  }
}

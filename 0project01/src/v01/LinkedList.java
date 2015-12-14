package v01;

// 1) 클래스 이름 뒤에 어떤 타입을 다룰 지 별명(예:E, T, V 등)을 선언한다.
// 2) 그 타입을 사용하는 곳에 별명 문자로 대체한다.
public class LinkedList<E> {
  private Bucket<E> start;
  private Bucket<E> end;
  private int length;

  public LinkedList() {
    start = new Bucket<E>();
    end = start;
  }

  public int add(E value) {
    end.setValue(value);
    end.setNext(new Bucket<E>());
    end = end.getNext();
    length++;

    return 0;
  }

  public E get(int index) {
    if (index < 0 || index >= length)
      return null;

    Bucket<E> cursor = start;
    int pos = 0;
    while (pos < index) {
      cursor = cursor.getNext();
      pos++;
    }

    return cursor.getValue();
  }

  public E remove(int index) {
    if (index < 0 || index >= length)
      return null;

    E removedValue = null;
    
    if (index == 0) {
      removedValue = start.getValue();
      start = start.getNext();
    } else {

      Bucket<E> cursor = start;
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
}

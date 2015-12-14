package step10.ex01;

public class LinkedList {
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
}

package step10.ex03;

public class Queue {
  Bucket front;
  Bucket rear;
  int length;
  

  public Queue () {
    front = new Bucket();
    rear = front;
  }
  
  public int put(Object value) {
    rear.setValue(value);
    rear.setNext(new Bucket());
    rear = rear.getNext();
    length++;
    return 0;
  }
  
  public Object get() {
    if (length == 0)
      return null;
    
    Object removedValue = front.getValue();
    front = front.getNext();
    length--;
    
    return removedValue;
  }
  
  public static void main(String[] args) {
    Queue queue = new Queue();
    
    queue.put("111");
    queue.put("222");
    queue.put("333");
    queue.put("444");
    System.out.println(queue.get());
    queue.put("555");
    queue.put("666");
    queue.put("777");
    
    for (int i = 0; i < 5; i++) {
      System.out.println(queue.get());
    }
    queue.put("888");
    
    System.out.println(queue.get());
    System.out.println(queue.get());
    System.out.println(queue.get());
    
    queue.put("999");
    
    queue.put("000");
    System.out.println(queue.get());
    System.out.println(queue.get());
    
  }
}

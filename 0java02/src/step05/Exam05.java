/*
 * 주제 : 인스턴스의 변수를 사용하는 메서드는 클래스 메서드로 만들지 말고 인스턴스 메서드로 선언하라!
 */
package step05;

public class Exam05 {

  // 성적 정보를 다룰 특별한 데이터 타입을 정의한다.
  static class Score {
    String name;
    int[] subjects = new int[5];
    int sum;
    float aver;
    
    public void print() {
      System.out.printf("%s: %d %f\n", 
          this.name, this.sum, this.aver);
    }
    
    // 인스턴스 메서드
    public void setInfo(String name, 
        int kor, int eng, int math, int soc, int sci){
      this.name = name;
      this.subjects[0] = kor;
      this.subjects[1] = eng;
      this.subjects[2] = math;
      this.subjects[3] = soc;
      this.subjects[4] = sci;
      
      compute();
    }
    
    public void compute() {
      this.sum = 0;
      for (int i = 0; i < this.subjects.length; i++) {
        this.sum += this.subjects[i];
      }
      
      this.aver = this.sum / (float) this.subjects.length;
    }
  }
  
    
  public static void main(String[] args) {
    // 레퍼런스 배열 초기화 예:
    Score[] scores = { new Score(), new Score(), new Score() };
    
    scores[0].setInfo("홍길동", 100, 100, 100, 100, 100);
    scores[0].print();
    
    scores[0].subjects[2] = 50;
    scores[0].compute();
    scores[0].print();

    scores[1].setInfo( "임꺽정", 90, 90, 90, 90, 90);
    scores[1].print();

    scores[2].setInfo("신채호", 80, 80, 80, 80, 80);
    scores[2].print();
  }
}

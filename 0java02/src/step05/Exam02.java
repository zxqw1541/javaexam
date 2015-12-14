/*
 * 주제 : 기능을 잘게 쪼개기 전에 문제점!
 */
package step05;

public class Exam02 {

  // 성적 정보를 다룰 특별한 데이터 타입을 정의한다.
  static class Score {
    String name;
    int[] subjects = new int[5];
    int sum;
    float aver;

  }
    
  public static void main(String[] args) {
    // 레퍼런스 배열 초기화 예:
    Score[] scores = { new Score(), new Score(), new Score() };
    
    setInfo(scores[0], "홍길동", 100, 100, 100, 100, 100);
    print(scores[0]);
    scores[0].subjects[2] = 50;
    //총점과 평균을 구하는 명령어를 별도의 메서드로 정의해두면 편했을 것이다.
    //그러나 이 명령어들은 setInfo()에 함께 있기 때문에 재 사용할 수 없었다.
    //=> 가능한 기능들을 잘게 쪼개면 나중에 다시 쓰기가 쉬워진다.
    //=> 개선코드 "Exam03.java" 참고!
    scores[0].sum = 0;
    for (int i = 0; i < scores[0].subjects.length; i++) {
      scores[0].sum += scores[0].subjects[i];
    }
    
    scores[0].aver = scores[0].sum / (float) scores[0].subjects.length;
    print(scores[0]);

    setInfo(scores[1], "임꺽정", 90, 90, 90, 90, 90);
    print(scores[1]);

    setInfo(scores[2], "신채호", 80, 80, 80, 80, 80);
    print(scores[2]);
  }

  // 아규먼트를 받아서 처리하는 메서드
  // score 파라미터(변수) : 성적정보 아규먼트(값)를 받는 변수
  public static void print(Score score) {
    System.out.printf("%s: %d %f\n", 
        score.name, score.sum, score.aver);
  }
  
  // 성적 정보를 Score 인스턴스에 저장하는 메서드
  // score : 성적을 담을 인스턴스의 주소 
  // name, kor, eng, math, soc, sci: 생성 정보
  public static void setInfo(Score score, String name, 
      int kor, int eng, int math, int soc, int sci){
    score.name = name;
    score.subjects[0] = kor;
    score.subjects[1] = eng;
    score.subjects[2] = math;
    score.subjects[3] = soc;
    score.subjects[4] = sci;
    
    for (int i = 0; i < score.subjects.length; i++) {
      score.sum += score.subjects[i];
    }
    
    score.aver = score.sum / (float) score.subjects.length;
  }
}

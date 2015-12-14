/*
 * 주제 : 이름 추가 + 평균 추가
 */
package step04;

public class Exam08 {

  public static void main(String[] args) {

    String[] names = { "홍길동", "임꺽정", "신채호" };
    float[] avers = {0.0f, 0.0f, 0.0f};

    int[][] scores = { { 100, 97, 100, 100, 100, 0 }, 
        { 90, 90, 85, 90, 90, 0 },
        { 100, 100, 89, 100, 100, 0 }
    };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 5; j++) {
        scores[i][5] += scores[i][j];
      }
      avers[i] = scores[i][5] / 5f;
    }

    for (int i = 0; i < 3; i++) {
      System.out.printf("%s: 총점=%d, 평균=%f\n", 
          names[i], scores[i][5], avers[i]);
    }

  }
}

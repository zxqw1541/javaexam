/*
 * 주제 : 다른 타입끼리의 계산 결과
 * - 자바에서 내부적으로 정의한 규칙(암시적 형변환)에 따라 타입을 변환한 후 계산한다.
 *   (byte, short, char) > int > long > float > double
 */
package step02;

public class Exam02 {

  public static void main(String[] args) {
    byte b = 10;
    short s = 20;
    char c = 20;
    int i = 30;
    long l = 40L;
    float f = 50.0f;
    double d = 60.1;
    
    //1) byte, short, char --> int
    int r1 = b + s + c;
    
    //2) int, long --> long : 작은 메모리와 큰 메모리를 계산하면 큰 메모리가 된다.
    // int를 long으로 만든 다음 계산.
    long r2 = i + l;
    
    //3) int, float --> float : 정수와 실수를 계산하면 실수가 된다.
    // int를 float으로 만든 다음 계산.
    float r3 = i + f; // 주의! 값이 짤릴 수 있다.
    
    //4) long, float --> float : 아무리 큰 정수라도 실수와 계산을 하면 실수가 된다.
    // long을 float으로 만든 다음 계산.
    float r4 = l + f; //8바이트 크기의 정수 값을 7자리 크기의 메모리에 담을려고 하니까,
                      // 더더욱 값이 짤릴 경우가 높을 것이다.
    
    //5) float, double --> double : 큰 메모리와 작은 메모리의 계산은 큰 메모리
    // float을 double로 만든 다음 계산.
    double r5 = f + d;
    
    //6) 다음의 계산 결과는 어떤 타입일까요?
    // ? r6 = b + s - c * i / f  - d + l ;
    double r6 = b + s - c * i / f  - d + l;
    
    // 결론! 
    // - 두 개의 다른 타입의 값을 계산 하려면,
    //   두 값을 같은 타입으로 만든 후에 계산을 수행한다.
    
    //주의!
    byte x =10;
    short y = 20;
    int z = x + y;
    // x 변수와 y 변수를 int로 바꾸는 것이 아니다!
  }
}

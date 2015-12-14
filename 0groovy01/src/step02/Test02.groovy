//주제: 자동 형 변환 
package step02

// 정적 타입 바인딩 변수 선언
String a = "홍길동"
a = 20 // 숫자(20)는 자동으로 문자열("20")로 변경된다.
println a
println a.getClass().getName()

int b = 30
//b = "30" // 숫자 --> 문자열로 자동 형변환 가능, 숫자ㅗ느 ㅡㅁ
println b 
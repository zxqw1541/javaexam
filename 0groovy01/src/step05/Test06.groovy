//주제: 파라미터 값 전달하는 다양한 방법
package step05


//1) 파라미터 값 전달 시 괄호 생략하기
def test1(a) {
  println a
}

test1(10)
test1 10 // 파라미터의 값을 전달할 때 괄호를 생략할 수 있다.

def test2(a, b) {
  println a + "," + b
}

test2(10, 20)
test2 10, 20 // 괄호 생략 가능
//test2 a:10, b:20 // 변수 이름으로 값을 넣을 수 없다.

def test3(map) {
  for (entry in map) {
    println entry.key + "=" + entry.value
  }
}

// 맵 객체를 넘기는 일반적인 방법
test3(["이름":"홍길동", "국어":100, "수학":100, "역사":100])

//맵 객체를 넘기는 그루비 많의 독특한 방법: 괄호 및 대괄호 생략, 키의 따옴표 생략 가능
test3 "이름":"홍길동", "국어":100, 수학:100, 역사:100

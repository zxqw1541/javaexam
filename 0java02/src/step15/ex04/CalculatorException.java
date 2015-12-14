package step15.ex04;


// 엥?
// 수퍼 클래스에 기능이 추가도니 것도 아니고, 왜 만들었을까?
// => 코딩할 때 눈에 띄라고.
public class CalculatorException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public CalculatorException() {
    super();
    // TODO Auto-generated constructor stub
  }

  public CalculatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    // TODO Auto-generated constructor stub
  }

  public CalculatorException(String message, Throwable cause) {
    super(message, cause);
    // TODO Auto-generated constructor stub
  }

  public CalculatorException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

  public CalculatorException(Throwable cause) {
    super(cause);
    // TODO Auto-generated constructor stub
  }
  
  

}

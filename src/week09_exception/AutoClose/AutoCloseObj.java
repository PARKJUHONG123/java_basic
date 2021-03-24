package week09_exception.AutoClose;

public class AutoCloseObj implements AutoCloseable { // 자동으로 close() 를 호출하는 인터페이스 상속

    @Override
    public void close() throws Exception {
        System.out.println("close() 를 호출했습니다.");
    } 
    
}

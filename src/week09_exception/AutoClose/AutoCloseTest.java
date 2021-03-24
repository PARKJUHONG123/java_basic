package week09_exception.AutoClose;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AutoCloseTest {
    public static void main(String[] args) {

        // AutoCloseable 을 구현하지 않은 리소스의 경우 아래와 같이 close() 를 해줘야 함
        // FileInputStream 은 Autocloseable 을 구현한 리소스지만 예를 들기 위해 마치 Autocloseable 을 구현하지 않은 것처럼 작성함
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("foo");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        // AutoCloseable 을 구현한 리소스의 경우 [try - with -resources]
        // 리소스를 자동으로 해제하도록 제공해주는 구문
        // 해당 리소스가 AutoCloseable 을 구현한 경우, close() 를 명시적으로 호출하지 않아도 try{} 블록에서 오픈된 리소스는 정상적인 경우나 예외가 발생한 경우 모두 자동으로 close() 호출
        // 자바 7부터 제공됨
        try (FileInputStream fisAutoCloseable = new FileInputStream("foo")) { // try 안에다가 예외가 발생할 수 있는 문장을 작성함
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println(e);
        }


        try (AutoCloseObj autoCloseObj = new AutoCloseObj()) { // 자바 9 이전에는 다른 참조 변수로 다시 선언해야 함
            throw new Exception();
        }
        catch(Exception e) {
            System.out.println(e);
        }

        // [향상된 try - with - resources]
        AutoCloseObj autoCloseObj_9 = new AutoCloseObj(); 
        try (autoCloseObj_9) { // 자바 9부터는 외부에서 선언한 변수를 try 구문에 넣어도 동작함
            throw new Exception();
        }
        catch(Exception e) {
            System.out.println(e);
        }


    }
}

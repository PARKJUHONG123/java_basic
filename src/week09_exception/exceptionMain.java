package week09_exception;
import java.util.Scanner;

public class exceptionMain {

    // main() 메소드에서 throws Exception 을 붙이는 것은 좋지 못한 예외 처리 방법
    // 따라서 main() 에서 try-catch 블록으로 예외를 최종 처리하는 것이 바람직함
    public static void main(String[] args) {
        try { // try 에는 예외 발생이 가능한 코드를 작성함
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                Class cl = Class.forName("java.lang.String2");
            }
            else if (choice == 2) {
                makeNullException();
            }
            else if (choice == 3) {
                throw new Exception();
            }
            else if (choice == 4) {
                throw new customException("사용자 정의 Exception");
            }
            else {
                throw new customRuntimeException("사용자 정의 Runtime Exception");
            }
        }

        // catch (Exception e) { }
        // 상위 Exception 이 위에 있게 되면 하위 Exception 들이 실행되지 않기 때문에, 하위 Exception 부터 작성을 해야 함
        // try 문에서 예외가 발생하면 해당 catch 문을 위에서부터 차례대로 검색을 함

        // catch 문에는 예외 처리 구문을 작성함
        catch (NullPointerException e) { // catch 블록이 여러 개라 할지라도 단 하나의 catch 블록만 실행됨
            // try 블록에서 동시 다발적으로 예외가 발생하지 않고, 하나의 예외가 발생하면 즉시 실행을 멈추고 해당 catch 블록으로 이동하기 때문
            System.out.println("[NullPointerException] : 하위 Exception 예외 처리 구문");
        }
        catch (ClassNotFoundException | NumberFormatException e){ // 다음과 같이 하나의 CATCH 블록에서 여러 개의 예외 처리가 가능함 (multi catch)
            // java 7부터 적용 가능함
            System.out.println("[ClassNotFoundException 또는 NumberFormatException] : 하위 Exception 예외 처리 구문");
        }
        catch (customException | customRuntimeException e) { // 사용자 정의 Exception
            // 예외 클래스인 customException 에 해당하는 예외 객체 e 가 생성됨
            String message = e.getMessage(); // 예외 메세지 얻기
            System.out.println(message);
            e.printStackTrace(); // 예외 발생 코드 추적 후 콘솔에 출력
        } 
        catch (Exception e) {
            System.out.println("[Exception] : 상위 Exception 예외 처리 구문");
            return;
        }
        finally { // 예외 발생 여부와 상관없이 항상 실행될 내용 + 옵션으로 생략이 가능함 + try 블록과 catch 블록에서 return 문을 사용하더라도 실행됨
            System.out.println("[finally] : try 블록과 catch 블록에 return 문이 있더라도 실행됨");
        }
    }

    public static void makeNullException() throws NullPointerException {
        // 메소드를 호출한 곳으로 예외를 떠넘기는 방법
        // throws 키워드가 붙어있는 메소드는 반드시 try 블록 내에서 호출되어야 함
        // catch 블록에서 떠넘겨 받은 예외를 처리하게 됨
        String data = null;
        System.out.println("[throws] : 메소드를 호출한 곳으로 예외를 떠넘김");
        System.out.println(data.toString()); // == throw new NullPointerException();
    }
}

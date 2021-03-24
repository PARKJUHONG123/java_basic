package week13_IO;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest {
    public static void main(String[] args) {

        try {
            int i;
            InputStreamReader isr = new InputStreamReader(System.in); // 보조 스트림 (다른 스트림에 기능을 부가함 : 바이트로 읽어들인 값을 문자로 바꿔주는 역할)

            // while ((i = System.in.read()) != '끝') { // 1 바이트 단위로 읽어오기 때문에 멀티 바이트인 문자를 읽을 수 있게 보조 스트림을 사용해야 함
            while((i = isr.read()) !=  '끝') {            
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

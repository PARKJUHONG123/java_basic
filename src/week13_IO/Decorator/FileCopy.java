package week13_IO.Decorator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class FileCopy {
    public static void main(String[] args) {
        long f_ms = 0, b_ms = 0;
        int i;

        try(FileInputStream fis = new FileInputStream("test.zip");
            FileOutputStream fos = new FileOutputStream("copy.zip");
            BufferedInputStream bis = new BufferedInputStream(fis); 
            BufferedOutputStream bos = new BufferedOutputStream(fos)) {

                f_ms = System.currentTimeMillis();
                while( (i = fis.read()) != -1) {
                    fos.write(i);
                }
                f_ms = System.currentTimeMillis() - f_ms;

                b_ms = System.currentTimeMillis();
                while( (i = bis.read()) != -1) {
                    bos.write(i);
                }
                b_ms = System.currentTimeMillis() - b_ms;

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File I/O 걸린 시간 : " + f_ms + "ms");
        System.out.println("Buffered I/O 걸린 시간 : " + b_ms + "ms"); // 버퍼 스트림이 속도 개선에 도움이 됨

        try ( Socket socket = new Socket();
              InputStream is = socket.getInputStream(); // 영문만 읽을 수 있음 (바이트 단위)
              InputStreamReader isr = new InputStreamReader(is); // 한글로 읽을 수 있음 (바이트 단위에서 문자 단위로 읽음)
              BufferedReader br = new BufferedReader(isr)  // 읽을 때 버퍼링 기능까지 사용할 수 있게 됨 (좀 더 빠르게 읽을 수 있게 함)
              // 상속으로 구현하게 되면 Hierarchy 가 굉장히 복잡해지지만, 위와 같이 기능을 간단하게 추가할 수 있음
            ){
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}

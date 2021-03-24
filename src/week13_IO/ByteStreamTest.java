package week13_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest {
    public static void main(String[] args) {
        byte[] wbs = new byte[26];
        byte data = 65;
        for (int i = 0; i < wbs.length; i++) {
            wbs[i] = (byte) (data + i);
        }

        try (FileOutputStream fos = new FileOutputStream("test.txt", true)) { // true : append, false : new
            fos.write(wbs);
            try (FileInputStream fis = new FileInputStream("test.txt")){
                /* 하나하나 읽어서 출력하기
                int ch;
                while ((ch = fis.read()) != -1) {
                    System.out.print((char) ch);
                }
                */

                // 버퍼에 한번에 읽어와서 출력하기
                int bufferLength; 
                byte[] rbs = new byte[10];
                while ((bufferLength = fis.read(rbs)) != -1) {
                    for (int i = 0; i < bufferLength; i++) {
                        System.out.print((char) rbs[i]);
                    }
                    System.out.println();
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

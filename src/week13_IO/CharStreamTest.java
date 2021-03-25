package week13_IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamTest {
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("test.txt")) {
            fw.write('A');
            char[] wbuf = {'B', 'C', 'D', 'E', 'F'};
            fw.write(wbuf);
            fw.write("한글");
            fw.write(wbuf, 2, 3); // 2번째 인덱스에서부터 3개 더 적기 (DEF)

            try(FileReader fr = new FileReader("test.txt")) { // 문자를 읽을 때 사용함 (한글을 읽을 때 바이트 단위로 읽게 되면 깨짐)
                int i;
                char[] rbuf = new char[10];
                /*
                while ((i = fr.read()) != -1) {
                    System.out.println((char) i);
                }
                */
                int bufferLength;
                while((bufferLength = fr.read(rbuf)) != -1) {
                    for (i = 0; i < bufferLength; i++) {
                        System.out.print((char) rbuf[i]);
                    }
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

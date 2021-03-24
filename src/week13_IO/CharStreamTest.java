package week13_IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamTest {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("test.txt")) { // 문자를 읽을 때 사용함 (한글을 읽을 때 바이트 단위로 읽게 되면 깨짐)
            int i;

            while ((i = fr.read()) != -1) {
                System.out.println((char) i);
            }
    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

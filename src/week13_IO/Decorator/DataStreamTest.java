package week13_IO.Decorator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest { 
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("test.txt");
             DataOutputStream dos = new DataOutputStream(fos);
             FileInputStream fis = new FileInputStream("test.txt");
             DataInputStream dis = new DataInputStream(fis)) { // 자료가 저장된 상태 그대로의 자료형을 유지하며 읽거나 쓸 수 있음

            // 나중에 직렬화를 통해 Object 를 작성할 수도 있음
            dos.writeByte(100); // 매개변수는 int 라고 되어 있지만 1 byte 로 작성함
            dos.write(100); // 4 byte 로 작성됨
            dos.writeChar('A');
            dos.writeUTF("한글");

            // 읽을 때는 쓴 그대로 읽어야 함
            System.out.println(dis.readByte()); // dis.read() 로 읽으면 깨짐
            System.out.println(dis.read());
            System.out.println(dis.readChar());
            System.out.println(dis.readUTF());

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

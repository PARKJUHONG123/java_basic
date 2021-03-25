package week13_IO;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
        raf.writeInt(100);
        System.out.println(raf.getFilePointer());
        raf.writeDouble(3.14);
        raf.writeUTF("한글");

        // int i = raf.readInt(); // 오류 발생 - 파일 포인터가 이동한 다음에 끄트머리에 작성을 하고 있었기 때문에 맨 뒤에서 읽으려고 하니 찾을 수 없음
        raf.seek(0); // 다시 원점으로 돌아간 다음에 읽어야 함

        // 작성한 순서에 맞게 찾아야 함
        int i = raf.readInt();
        double d = raf.readDouble();
        String str = raf.readUTF();
        System.out.println(i + " " + d + " " + str);
        raf.close();
    }
}

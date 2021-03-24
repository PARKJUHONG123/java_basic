package week13_IO.SystemConsole;

import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();
        
        System.out.print("이름 : ");
        String name = console.readLine();
        System.out.print("비밀번호 : ");
        char[] password = console.readPassword();

        System.out.println(name);
        System.out.println(password);
    }
}

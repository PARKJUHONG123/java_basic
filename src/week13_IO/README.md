## 목표
    자바의 Input과 Ontput에 대해 학습하세요.

## 학습할 것 (필수)
- 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O
- InputStream과 OutputStream
- Byte와 Character 스트림
- 표준 스트림 (System.in, System.out, System.err)
- 파일 읽고 쓰기

## 스트림
- 네트워크에서 자료의 흐름이 물과 같다는 의미에서 유래
- 다양한 입출력 장치에서 독립적으로 일관성 있는 입출력 방식 제공
- 입출력이 구현되는 곳에서 모두 I/O 스트림 사용 (키보드, 파일 디스크, 메모리 등)
- 구분
    - I/O 대상 기준 : 입력 스트림, 출력 스트림
    - 자료의 종류 : 바이트 스트림, 문자 스트림
    - 스트림의 기능 : 기반 스트림, 보조 스트림 (바이트 -> 문자열, 버퍼링, 직렬화 등)

### I/O 대상 기준
- 입력 스트림
    - 대상으로부터 자료를 읽는 스트림
    - FileInputStream, FileReader, BufferedInputStream, BufferedReader 등
- 출력 스트림
    - 대상으로 자료를 출력하는 스트림
    - FileOutputStream, FileWriter, BufferedOutputStream, BufferedWriter 등

### 자료의 종류
- 바이트 단위 스트림
    - 바이트 단위로 자료를 읽고 씀
    - 동영상, 음악 파일 등
    - FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream 등
- 문자 단위 스트림
    - 문자는 2 Byte 씩 처리해야 함
    - FileReader, FileWriter, BufferedReader, BufferedWriter 등

### 스트림의 기능
- 기반 스트림
    - 대상에 직접 자료를 읽고 쓰는 기능의 스트림
    - FileInputStream, FileOutputStream, FileReader, FileWriter 등
- 보조 스트림
    - 직접 읽고 쓰는 기능은 없음
    - 기반 스트림에 추가적인 기능을 제공해주는 스트림
    - 기반 스트림이나 또 다른 보조 스트림을 생성자의 매개변수로 포함
    - InputStreamReader, OutputStreamWriter, BufferedInputStream, BufferedOutputStream 등

## 표준 입출력
- System 클래스의 표준 입출력 멤버

```
    public class System {
        public static PrintStream out; // 표준 출력 스트림
        public static InputStream in; // 표준 입력 스트림
        public static PritnStream err; // 표준 에러 스트림
    }
```

## Scanner 클래스
- java.util 패키지에 있는 입력 클래스
- 문자뿐 아니라 정수, 실수 등 다양한 자료형 읽을 수 있음
- 생성자가 다양하여 여러 소스로부터 자료 읽을 수 있음
    - Scanner(File source) : 파일을 매개변수로 받아 Scanner 생성
    - Scanner(InputStream source) : 바이트 스트림을 매개변수로 받아 Scanner 생성
    - Scanner(String source) : String 을 매개변수로 받아 Scanner 생성

## Console 클래스
- 이클립스랑은 연동이 되지 않음
- System.in 을 사용하지 않고 콘솔에서 표준 입출력이 가능
- Console 클래스의 메소드
    - String readLine() : 문자열을 읽음
    - char[] readPassword() : 사용자에게 문자열을 보여주지 않고 읽음
    - Reader reader() : Reader 클래스 반환
    - PrintWriter writer() : PrintWriter 클래스 반환
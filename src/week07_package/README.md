## 목표
    자바의 패키지에 대해 학습하세요.

## 학습할 것 (필수)
- package 키워드
- import 키워드
- 클래스패스
- CLASSPATH 환경변수
- classpath 옵션
- 접근지시자

### 클래스패스 (CLASSPATH)
1. 소스 코드 (.java) 를 컴파일 (javac.exe) 하면 소스 코드가 바이트 코드 (.class) 로 변환됨
2. java runtime (java.exe) 으로 바이트 코드 파일에 포함된 명령을 실행하려면, 바이트 코드 파일의 위치를 알아야 한다
- 즉 바이트 코드 파일 (.class) 을 찾을 때, classpath 에 지정된 경로를 사용함
- classpath 는 .class 파일이 포함된 디렉토리와 파일을 클론 (;) 으로 구분한 목록
- classpath 를 지정하기 위한 두 가지 방법
    1. CLASSPATH 환경변수 사용
    2. JAVA RUNTIME 에 -classpath 옵션 사용

#### 1. CLASSPATH 환경변수
- 컴퓨터 시스템 변수 설정을 통해 지정함
- CLASSPATH 환경 변수에는 필수 클래스들이 위치한 디렉토리를 등록함
1. JVM 이 시작될 때 JVM 의 CLASS LOADER 는 CLASSPATH 환경 변수를 호출함
2. 환경 변수에 설정되어 있는 디렉토리가 호출됨
3. 호출된 디렉토리 내의 클래스들을 JVM 에 로드함


    변수이름 : CLASSPATH
    변수 값 : %JAVA_HOME%lib


#### 2. CLASSPATH 옵션

    javac <options> <source files>

- 컴파일러가 컴파일 하기 위해서 필요로 하는 참조할 클래스 파일들의 위치로 파일 경로를 지정해주는 옵션

만약에 Hello.java 파일이 C:\Java 디렉토리에 존재하고, 필요한 클래스 파일들이 현 디렉토리와 C:\Java\Sub 와 C:\Java\Other 에 위치한다고 가정한다면,

    javac -classpath .;C:\Java\Sub;C:\Java\Other C:\Java\Hello.java
    (단축어) javac -cp .;C:\Java\Sub;C:\Java\Other C:\Java\Hello.java

- 컴파일할 때 Hello.java 의 내부 소스가 참조하고 있는 외부 클래스 파일들을 지정해줘야 함
- 클래스 파일들이 위치한 디렉토리가 다를 경우 클론 (;) 으로 구분함
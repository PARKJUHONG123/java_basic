package week05_class.Annotation;

/*
Annotation (@Annotation)
= 메타데이터 = 어플리케이션이 처리해야 할 데이터가 아니라, 컴파일 과정과 실행 과정에서 어떻게 컴파일하고 처리할 것인지 알려주는 정보
- 컴파일러에게 코드 문법 에러를 체크하도록 정보 제공 (@override 가 정확히 되었는지 확인하는 등)
- 소프트웨어 개발 툴이 빌드나 배치 시 코드를 자동으로 생성할 수 있도록 정보 제공
- 실행 시 (런타임 시) 특정 기능을 실행하도록 정보 제공
    - 빌드 시 자동으로 XML 설정 파일을 생성
    - 배포를 위해 JAR 압축 파일을 생성
    - 실행 시 클래스의 역할을 정의
 */

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.METHOD) // Annotation 이 적용될 대상 지정 - 여기서는 Method 임으로 Method 에만 Annotation 적용 가능
@Retention(RetentionPolicy.RUNTIME) // Annotation 유지 정책 - SOURCE, CLASS, RUNTIME
// SOURCE = 소스 상에만 어노테이션 정보 유지, 소스 코드 분석 시에만 의미있음, 바이트 코드 파일에는 정보가 남지 않음
// CLASS = 바이트 코드 파일까지 정보 유지, 리플렉션 (런타임 시에 클래스의 메타 정보를 얻는 기능) 을 이용해서는 정보 얻을 수 없음
// RUNTIME = 바이트 코드 파일까지 정보 유지 + 리플랙션을 이용해서 정보 얻을 수 있음
public @interface PrintAnnotation {
    String value() default "-";
    int number() default 15;
}

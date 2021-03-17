package week14_generic.WildCard;
import week14_generic.WildCard.People.*;

import java.util.Arrays;

public class WildCardMain {
    /* [People Package]
    - Person
        - Worker
        - Student
            - HighStudent
     */

    public void registerCourse(Course<?> course) { // 모든 과정
        System.out.println(course.getName() + " 수강생 : " + Arrays.toString(course.getStudents()));
    }

    // Student 본인 또는 상위 클래스 (자식) = Student 와 HighStudent
    public void registerCourseStudent(Course<? extends Student> course ) { // 학생 과정
        System.out.println("[extends] " + course.getName() + " 수강생 : " + Arrays.toString(course.getStudents()));
    }

    // Worker 본인 또는 하위 클래스 (부모) = Worker 와 Person
    public void registerCourseWorker(Course<? super Worker> course) { // 직장인과 일반인 과정
        System.out.println("[super] " + course.getName() + " 수강생 : " + Arrays.toString(course.getStudents()));
    }

    public static void main(String[] args) {
        Course<Person> personCourse = new Course<Person>("일반인 과정" , 10);
        personCourse.add(new Person("일반인 A1"));
        personCourse.add(new Worker("직장인 A2"));
        personCourse.add(new Student("학생 A3"));
        personCourse.add(new HighStudent("고등학생 A4"));

        Course<Worker> workerCourse = new Course<Worker>("직장인 과정", 5);
        workerCourse.add(new Worker("직장인 B1"));

        Course<Student> studentCourse = new Course<Student>("학생 과정", 3);
        studentCourse.add(new Student("학생 C1"));
        studentCourse.add(new HighStudent("고등학생 C2"));

        Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생 과정", 5);
        highStudentCourse.add(new HighStudent("고등학생 D1"));


        WildCardMain wildCardMain = new WildCardMain();
        wildCardMain.registerCourse(personCourse);

        wildCardMain.registerCourseWorker(personCourse);
        wildCardMain.registerCourseWorker(workerCourse);
        // wildCardMain.registerCourseWorker(studentCourse);
        // wildCardMain.registerCourseWorker(highStudentCourse);

        wildCardMain.registerCourseStudent(studentCourse);
        wildCardMain.registerCourseStudent(highStudentCourse);
        // wildCardMain.registerCourseStudent(personCourse);
        // wildCardMain.registerCourseStudent(workerCourse);
    }
}

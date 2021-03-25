package week13_IO.Serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {
    public static void main(String[] args) {
        Person p1 = new Person("A", "1");
        Person p2 = new Person("B", "2");

        Coffee c1 = new Coffee("C", 1000);
        Coffee c2 = new Coffee("D", 3000);

        try (FileOutputStream fos = new FileOutputStream("serial.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) { // 그냥 파일에 Object 내용을 적을 수 없기 때문에 보조스트림인 ObjectOutputStream 사용
                oos.writeObject(p1);
                oos.writeObject(p2);

                oos.writeObject(c1);                
                oos.writeObject(c2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("serial.dat");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
                Object o1 = ois.readObject();
                Object o2 = ois.readObject();

                Object o3 = ois.readObject();
                Object o4 = ois.readObject();
                
                if ((o1 instanceof Person) && (o2 instanceof Person)) {
                    Person op1 = (Person) o1;
                    Person op2 = (Person) o2;
                    System.out.println("[Serialzable Result]\n" + op1.toString() + "\n" + op2.toString());
                }

                if ((o3 instanceof Coffee) && (o4 instanceof Coffee)) {
                    Coffee oc1 = (Coffee) o3;
                    Coffee oc2 = (Coffee) o4;
                    System.out.println("[Externalizable Result]\n" + oc1.toString() + "\n" + oc2.toString());
                }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable { // class Person 으로만 작성하면 직렬화되지 않기 때문에 Serializable 을 명시해줘야 함
    String name;
    transient String job; // 해당 Context 는 직렬화하지 말라는 의미

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String toString() {
        return name + " : " + job;
    }
}

class Coffee implements Externalizable { // Serializable 대신 Externalizable 을 사용해서 writeObject 와 readObject 사용 시 각각 writeExternal 과 readExternal 을 호출하게 함
    transient String name; // Externalizable 에서는 전송 데이터를 각각 지정해줘야 하며, transient 선언이 되어 있어도 전송이 됨
    int price;
    
    public Coffee() { } // Externalizable 선언 시 기본 생성자를 선언해줘야 함

    public Coffee(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " : " + price;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal() 호출");

        out.writeInt(this.price);
        if (this.price == 1000) {
            out.writeObject("Americano");
        }        
        else {
            out.writeObject(this.name);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("readExternal() 호출");

        // writeExternal 데이터 순서대로 읽어와야 함
        price = in.readInt();
        Object objectName = in.readObject();
        name = (objectName instanceof String) ? (String) objectName : "";
    }
}

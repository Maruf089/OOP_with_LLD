import java.util.ArrayList;
import java.util.List;

/*
- same behavior but they do it differently -> Polymorphism
 */
interface Student{
    void nightPreparation();
}

public class ResidentStudent implements Student{
    @Override
    public void nightPreparation(){
       // hall.read();
    }
}
public class NonResidentStudent implements Student{
    @Override
    public void nightPreparation() {
       // home.read();
    }
}


public void main() {
    List<Student>students = new ArrayList<>();
    students.add(0, new ResidentStudent());
    students.add(1, new NonResidentStudent());
    students.add(0, new ResidentStudent());

//    for (int i = 0; i < students.size(); i++) {
//        students.get(i).nightPreparation();
//    }
    for(Student s : students)
        s.nightPreparation();
}



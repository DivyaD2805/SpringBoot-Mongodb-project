package com.example.demo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Student;
import com.example.demo.Repository.StudentRepository;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    //Create operation
    public Student create(String firstName,String lastName, int age ,int sem, String sec,String usn) {
        return studentRepository.save(new Student(firstName, lastName, age,sem,sec,usn));
    }
    //Retrieve operation
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public Student getByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }
    public Student getByUsn(String usn) {
        return studentRepository.findByUsn(usn);
    }
    //Update operation
    public Student update(String firstName, String lastName, int age,int sem, String sec, String usn) {
        Student p = studentRepository.findByFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        p.setUsn(usn);
        p.setSem(sem);
        p.setSec(sec);
        return studentRepository.save(p);
    }
    public Student updaterecord(Student s, String usn) {
        Student p = studentRepository.findByUsn(usn);
        p.setFirstName(s.getFirstName());
        p.setLastName(s.getLastName());
        p.setAge(s.getAge());
        p.setSec(s.getSec());
        p.setSem(s.getSem());
        studentRepository.save(p);
        return p;
    }
    //Delete operation
    public void deleteAll() {
        studentRepository.deleteAll();
    }
    public void delete(String firstName) {
        Student p = studentRepository.findByFirstName(firstName);
        studentRepository.delete(p);
    }
    public void deletebyusn(String usn) {
        Student s =studentRepository.findByUsn(usn);
        studentRepository.delete(s);
    }
    public  void createrecord(Student person) {
        studentRepository.save(person);
    }
}

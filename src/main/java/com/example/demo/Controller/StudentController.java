package com.example.demo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Student;
import com.example.demo.Service.StudentService;
@RestController@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("")
    public String mainpage(){
        return "WELCOME !! your app is running succesfully !!!";
    }
    @RequestMapping("/create")
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age,@RequestParam int sem, @RequestParam String sec,@RequestParam String usn) {
        Student p = studentService.create(firstName, lastName, age,sem,sec,usn);
        return p.toString();
    }
    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody Student person) {
        studentService.createrecord(person);
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }
    @GetMapping(value="/firstname/{firstName}")
    public Student getstudentbyname(@PathVariable ("firstName") String firstName) {
        return studentService.getByFirstName(firstName);
    }
    @GetMapping(value="/usn/{usn}")
    public Student getstudentbyusn(@PathVariable ("usn") String usn) {
        return studentService.getByUsn(usn);
    }
    @GetMapping(value="/")
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @RequestMapping("/update")
    public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam int sem, @RequestParam String sec,@RequestParam String usn) {
        Student p = studentService.update(firstName, lastName, age,sem,sec,usn);
        return p.toString();
    }
    @PutMapping(value="/{usn}")
    public Student updaterecord(@RequestBody Student s, @PathVariable ("usn") String usn) {
        Student p = studentService.updaterecord(s,usn);
        return p;
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName) {
        studentService.delete(firstName);
        return "Deleted "+firstName;
    }
    @DeleteMapping(value="/firstname/{firstName}")
    public String deleterecord(@PathVariable("firstName") String firstName){
        studentService.delete(firstName);
        return "deleted"+firstName;
    }
    @DeleteMapping(value="/")
    public String deleteallrecord() {
        studentService.deleteAll();
        return "Deleted all the records from students";
    }
    @DeleteMapping(value="/usn/{usn}")
    public String deletebyusn(@PathVariable("usn") String usn) {
        studentService.deletebyusn(usn);
        return "deleted"+usn;
    }
    @RequestMapping ("/deleteAll")
    public String deleteAll() {
        studentService.deleteAll();
        return "Deleted all records";
    }
}
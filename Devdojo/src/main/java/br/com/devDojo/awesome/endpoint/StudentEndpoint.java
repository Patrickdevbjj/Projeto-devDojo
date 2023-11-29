package br.com.devDojo.awesome.endpoint;

import br.com.devDojo.awesome.error.CustomErrorType;
import br.com.devDojo.awesome.model.Student;
import br.com.devDojo.awesome.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentEndpoint {

    private final StudentRepository studentDAO;

    @Autowired
    public StudentEndpoint(StudentRepository studentDAO) {
        this.studentDAO = studentDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(Student.getStudentList(), HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        Student student = new Student();
        student.setId(id);
        int index = Student.studentList.indexOf(student);
        if (index == -1 ) {
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student){
        Student.studentList.add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Student student){
        Student.studentList.remove(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

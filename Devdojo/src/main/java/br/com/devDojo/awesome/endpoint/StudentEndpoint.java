package br.com.devDojo.awesome.endpoint;

import br.com.devDojo.awesome.error.CustomErrorType;
import br.com.devDojo.awesome.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.devDojo.awesome.util.Dateutil;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
    @Autowired
    private Dateutil dateUtil;

    public StudentEndpoint(Dateutil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        System.out.println(dateUtil.formatlocalDateTimeToDatabasesStyle(LocalDateTime.now()));
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK);

    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
        Student student = new Student();
        student.setId(id);
        int index = Student.studentList.indexOf(student);

        if (index == -1)
            return new ResponseEntity<>(new CustomErrorType(  "Student not found"),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{id}")
    public ResponseEntity<?> save(@RequestBody Student student) {
       Student.studentList.add(student);
       return new ResponseEntity<>(student,HttpStatus.OK);
    }

}

package br.com.devDojo.awesome.endpoint;

import br.com.devDojo.awesome.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.devDojo.awesome.util.Dateutil;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("student")
public class StudentEndpoint {
    @Autowired
    private Dateutil dateUtil;
    @RequestMapping(method = RequestMethod.GET,path = "/list")
    public List<Student> listall(){
        System.out.println(dateUtil.formatlocalDateTimeToDatabasesStyle(LocalDateTime.now()));
        return asList(new Student("Deku"), new Student("Todoroki"));
    }
}

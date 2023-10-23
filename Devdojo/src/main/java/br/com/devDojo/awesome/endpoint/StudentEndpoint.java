package br.com.devDojo.awesome.endpoint;

import br.com.devDojo.awesome.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("student")
public class StudentEndpoint {

    @RequestMapping(method = RequestMethod.GET,path = "/list")
    public List<Student> listall(){
        return asList(new Student("Deku"), new Student("Todoroki"));
    }
}

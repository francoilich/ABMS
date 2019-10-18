package com.app.controller;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class ABMPersonController {
    @Autowired
    private PersonService personService;

    public ABMPersonController() {
        System.out.println("Person Controller");
    }
    @RequestMapping(value = "/")
    public ModelAndView listOfPersons(ModelAndView model) throws IOException {
        List<Person> personList = personService.getAllPersons();
        model.addObject(personList);
        model.setViewName("Home");
        return model;
    }

    @RequestMapping(value = "/newPerson", method = RequestMethod.GET)
    public ModelAndView addNewPerson(ModelAndView model) {
        Person person = new Person();
        model.addObject("person", person);
        model.setViewName("PersonForm");
        return model;
    }

    @RequestMapping(value = "/savePerson", method = RequestMethod.POST)
    public ModelAndView savePerson(@ModelAttribute Person person) {
        if (person.getId() == 0) {
            personService.addPerson(person);
        } else {
            personService.updatePerson(person);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int personId = Integer.parseInt(request.getParameter("id"));
        personService.deletePerson(personId);
        return new ModelAndView("redirect:/");
    }

//    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
//    public ModelAndView editPerson(HttpServletRequest request) {
//        String name = Integer.parseInt(request.getParameter("name"));
//        Person employee = personService.getPersonByName(name);
//        ModelAndView model = new ModelAndView("EmployeeForm");
//        model.addObject("employee", employee);
//        return model;
//    }
}
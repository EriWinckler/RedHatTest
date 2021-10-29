package com.example.redhat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EmployeeController {
    private final AtomicLong counter = new AtomicLong();
    private final static String templateFirst = "Employee First Name: %s";
    private final static String templateLast = "Employee Last Name: %s";
    private final static String templateInvalid = "Invalid input";

    @GetMapping("/")
    public String getHello() {
        return "Hello World 2";
    }

    @GetMapping("/sayHello")
    public Employee sayHello() {
        return new Employee(42, "John", "Doe");
    }

    @GetMapping("/createEmployee")
    public Employee createEmployee(@RequestParam(value = "name", defaultValue = "first") String firstName, @RequestParam(value = "name", defaultValue = "last") String lastName) {
        return new Employee(counter.incrementAndGet(),
                String.format(templateFirst, firstName),
                String.format(templateLast, lastName));
    }

    @GetMapping("/hello/{name}/{last}")
    public Employee hello(@PathVariable String name, @PathVariable String last) {
        return new Employee(counter.incrementAndGet(),
                String.format(templateFirst, name),
                String.format(templateLast, last));
    }

    @GetMapping("/employee/{firstName}/{lastName}")
    public Employee employee(@RequestParam(defaultValue = "empty") String firstName, @RequestParam(defaultValue = "empty") String lastName) {
        if(firstName.equals("empty") || lastName.equals("empty")) {
            return new Employee(404, templateInvalid);
        }

        return new Employee(counter.incrementAndGet(),
                String.format(templateFirst, firstName),
                String.format(templateLast, lastName));
    }
}

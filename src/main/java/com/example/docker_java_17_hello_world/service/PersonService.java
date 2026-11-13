package com.example.docker_java_17_hello_world.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    public String process(Object value) {
        final String data = "test1";
        int data2 = 12;
        if (value instanceof String) {
            String text = (String) value;
            return processString(text);
        }

        if (value instanceof Integer) {
            Integer number = (Integer) value;
            return processInteger(number);
        }

        return "unknown";
    }

    public String processPerson(Object value) {
        System.out.println(12);
        if (value instanceof Person) {
            Person person = (Person) value;
            return person.getName();
        }

        return "Not a person";
    }

    public String processPersonWithAnd(Object value) {
        if (value instanceof Person && ((Person) value).isActive()) {
            Person person = (Person) value;
            return person.getName();
        }

        return "Not an active person";
    }

    public String processPersonWithNestedBlock(Object value) {
        if (value instanceof Person) {
            if (value instanceof Employee) {
                Employee employee = (Employee) value;
                return employee.getEmployeeId();
            }

            Person person = (Person) value;
            return person.getName();
        }

        return "Unknown";
    }

    public String processList(Object value) {
        if (value instanceof List) {
            List<?> list = (List<?>) value;
            return "Size: " + list.size();
        }

        return "Not a list";
    }

    public String processNumber(Object value) {
        if (value instanceof Number) {
            Number number = (Number) value;
            return String.valueOf(number.doubleValue());
        }

        return "Not a number";
    }

    public boolean isPerson(Object value) {
        return value instanceof Person;
    }

    public void processWithoutCast(Object value) {
        if (value instanceof Person) {
            System.out.println("It is a person");
        }
    }

    public String processWithExistingVariable(Object value) {
        Person person = new Person("John");

        if (value instanceof Person) {
            return person.getName();
        }

        return "Unknown";
    }

    public String processWithMultipleTypes(Object value) {
        if (value instanceof String) {
            String text = (String) value;
            return processString(text);
        } else if (value instanceof Integer) {
            Integer number = (Integer) value;
            return processInteger(number);
        } else if (value instanceof Person) {
            Person person = (Person) value;
            return person.getName();
        }

        return "Unknown";
    }

    public String processWithEarlyReturn(Object value) {
        if (!(value instanceof Person)) {
            return "Not a person";
        }

        Person person = (Person) value;
        return person.getName();
    }

    public String processInLoop(List<Object> values) {
        StringBuilder result = new StringBuilder();

        for (Object value : values) {
            if (value instanceof Person) {
                Person person = (Person) value;
                result.append(person.getName());
            }
        }

        return result.toString();
    }

    public String processInWhile(Object value) {
        while (value instanceof Person) {
            Person person = (Person) value;
            return person.getName();
        }

        return "Not a person";
    }

    public String processInLambda(List<Object> values) {
        return values.stream()
                .filter(value -> value instanceof Person)
                .map(value -> {
                    if (value instanceof Person) {
                        Person person = (Person) value;
                        return person.getName();
                    }

                    return "Unknown";
                })
                .findFirst()
                .orElse("Empty");
    }

    public String processWithTernary(Object value) {
        return value instanceof Person
                ? ((Person) value).getName()
                : "Unknown";
    }

    public String processWithNegation(Object value) {
        if (!(value instanceof Person)) {
            return "Not a person";
        }

        Person person = (Person) value;
        return person.getName();
    }

    private String processString(String value) {
        return "String: " + value;
    }

    private String processInteger(Integer value) {
        return "Integer: " + value;
    }

    public static class Person {

        private final String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Employee extends Person {

        private final String employeeId;

        public Employee(String name, String employeeId) {
            super(name);
            this.employeeId = employeeId;
        }

        public String getEmployeeId() {
            return employeeId;
        }
    }
}
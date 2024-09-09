package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void getTaskNumberMessage(Integer taskNumber) {
        System.out.println("\nTask #" + taskNumber + '\n');
    }

    public static void task1() {
        getTaskNumberMessage(1);
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> 10 <= animal.getAge() && 20 >= animal.getAge())
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(14)
                .limit(7)
                .forEach(System.out::println);
    }

    public static void task2() {
        getTaskNumberMessage(2);
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .peek(animal -> {
                    if (animal.getGender().equals("Female")) {
                        animal.setBread(animal.getBread().toUpperCase());
                    }
                })
                .map(Animal::getBread)
                .forEach(System.out::println);
    }

    public static void task3() {
        getTaskNumberMessage(3);
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .forEach(System.out::println);
    }

    public static void task4() {
        getTaskNumberMessage(4);
        List<Animal> animals = Util.getAnimals();
        long count = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.println(count);
    }

    public static void task5() {
        getTaskNumberMessage(5);
        List<Animal> animals = Util.getAnimals();
        boolean ofHungarianOrigin = animals.stream()
                .filter(animal -> 20 <= animal.getAge() && 30 >= animal.getAge())
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
        System.out.println(ofHungarianOrigin);
    }

    public static void task6() {
        getTaskNumberMessage(6);
        List<Animal> animals = Util.getAnimals();
        boolean isNotFemaleAndMale = animals.stream()
                .anyMatch(animal -> !(animal.getGender().equals("Female") || animal.getGender().equals("Male")));
        System.out.println(isNotFemaleAndMale);
    }

    public static void task7() {
        getTaskNumberMessage(7);
        List<Animal> animals = Util.getAnimals();
        boolean ofOceaniaOrigin = animals.stream()
                .anyMatch(animal -> animal.getOrigin().equals("Oceania"));
        System.out.println(ofOceaniaOrigin);
    }

    public static void task8() {
        getTaskNumberMessage(8);
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(animal -> System.out.println(animal.getAge()));
    }

    public static void task9() {
        getTaskNumberMessage(9);
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .min(Comparator.comparing(chars -> chars.length))
                .ifPresent(chars -> System.out.println(chars.length));

    }

    public static void task10() {
        getTaskNumberMessage(10);
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .map(Animal::getAge)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    public static void task11() {
        getTaskNumberMessage(11);
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .ifPresent(System.out::println);

    }

    public static void task12() {
        getTaskNumberMessage(12);
        List<Person> persons = Util.getPersons();
        persons.stream()
                .filter(person -> person.getGender().equals("Male")
                        && person.getDateOfBirth().isAfter(LocalDate.of(1997, 1, 1))
                        && person.getDateOfBirth().isBefore(LocalDate.of(2006, 1, 1)))
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        getTaskNumberMessage(16);
        List<Student> students = Util.getStudents();
        students.stream()
                .filter(student -> student.getAge() <= 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(student -> System.out.println("name: " + student.getSurname() + ", age: " + student.getAge()));
    }

    public static void task17() {
        getTaskNumberMessage(17);
        List<Student> students = Util.getStudents();
        students.stream()
                .map(Student::getGroup)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
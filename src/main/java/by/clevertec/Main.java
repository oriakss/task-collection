package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

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
        getTaskNumberMessage(13);
        List<House> houses = Util.getHouses();
        Map<String, List<Person>> map = houses.stream()
                .collect(groupingBy(House::getBuildingType, flatMapping(house -> house.getPersonList().stream(), toList())));
        List<Person> priorityPersons = map.get("Hospital");

        if (priorityPersons.size() > 500) {
            priorityPersons = priorityPersons.subList(0, 500);
        }
        if (priorityPersons.size() < 500) {
            map.remove("Hospital");
            getNewPriorityPersons(map, priorityPersons.size(), getUnderagePredicate())
                    .forEach(priorityPersons::addLast);
        }
        if (priorityPersons.size() < 500) {
            getNewPriorityPersons(map, priorityPersons.size(), getFemaleRetiredPredicate())
                    .forEach(priorityPersons::addLast);
        }
        if (priorityPersons.size() < 500) {
            getNewPriorityPersons(map, priorityPersons.size(), getMaleRetiredPredicate())
                    .forEach(priorityPersons::addLast);
        }
        if (priorityPersons.size() < 500) {
            getNewPriorityPersons(map, priorityPersons.size(), getOtherPersonsPredicate())
                    .forEach(priorityPersons::addLast);
        }
        priorityPersons.forEach(System.out::println);
    }

    private static List<Person> getNewPriorityPersons(Map<String, List<Person>> map, int priorityPersonsCount, Predicate<Person> predicate) {
        return map.values().stream()
                .flatMap(List::stream)
                .filter(predicate)
                .limit(500 - priorityPersonsCount)
                .toList();
    }

    private static Predicate<Person> getUnderagePredicate() {
        return person -> person.getDateOfBirth().isAfter(LocalDate.of(2006, 1, 1));
    }

    private static Predicate<Person> getFemaleRetiredPredicate() {
        return person -> person.getDateOfBirth().isBefore(LocalDate.of(1966, 1, 1))
                && person.getGender().equals("Female");
    }

    private static Predicate<Person> getMaleRetiredPredicate() {
        return person -> person.getDateOfBirth().isBefore(LocalDate.of(1961, 1, 1))
                && person.getGender().equals("Male");
    }

    private static Predicate<Person> getOtherPersonsPredicate() {
        return person -> (person.getDateOfBirth().isAfter(LocalDate.of(1961, 1, 1))
                && person.getDateOfBirth().isBefore(LocalDate.of(1966, 1, 1))
                && !person.getGender().equals("Female"))
                || (person.getDateOfBirth().isAfter(LocalDate.of(1966, 1, 1))
                && person.getDateOfBirth().isBefore(LocalDate.of(2006, 1, 1)));
    }

    public static void task14() {
        getTaskNumberMessage(14);
        List<Car> cars = Util.getCars();

        Map<Boolean, List<Car>> map1 = cars.stream()
                .collect(partitioningBy(car -> car.getCarMake().equals("Jaguar") || car.getColor().equals("White")));
        Map<Boolean, List<Car>> map2 = map1.get(false).stream()
                .collect(partitioningBy(car -> car.getMass() < 1500 || car.getCarMake().equals("BMW")
                        || car.getCarMake().equals("Lexus") || car.getCarMake().equals("Chrysler")
                        || car.getCarMake().equals("Toyota")));
        Map<Boolean, List<Car>> map3 = map2.get(false).stream()
                .collect(partitioningBy(car -> (car.getColor().equals("Black") && car.getMass() > 4000)
                        || car.getCarMake().equals("GMC") || car.getCarMake().equals("Dodge")));
        Map<Boolean, List<Car>> map4 = map3.get(false).stream()
                .collect(partitioningBy(car -> car.getReleaseYear() < 1982 || car.getCarModel().equals("Civic")
                        || car.getCarModel().equals("Cherokee")));
        Map<Boolean, List<Car>> map5 = map4.get(false).stream()
                .collect(partitioningBy(car -> !(car.getColor().equals("Red") || car.getColor().equals("Yellow")
                        || car.getColor().equals("Green") || car.getColor().equals("Blue")) || car.getPrice() > 40000));
        Map<Boolean, List<Car>> map6 = map5.get(false).stream()
                .collect(partitioningBy(car -> car.getVin().contains("59")));

        List<BigDecimal> countrySpendingSumList = List.of(getCountrySpendingSum(map1), getCountrySpendingSum(map2),
                getCountrySpendingSum(map3), getCountrySpendingSum(map4),
                getCountrySpendingSum(map5), getCountrySpendingSum(map6));

        countrySpendingSumList.forEach(System.out::println);
        countrySpendingSumList.stream()
                .reduce(BigDecimal::add)
                .ifPresent(System.out::println);
    }

    private static BigDecimal getCountrySpendingSum(Map<Boolean, List<Car>> map) {
        return new BigDecimal(map.get(true).stream()
                .mapToInt(Car::getMass)
                .sum())
                .multiply(new BigDecimal("0.00714"));
    }

    public static void task15() {
        getTaskNumberMessage(15);
        List<Flower> flowers = Util.getFlowers();
        BigDecimal sum = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed())
                .filter(flower -> flower.getCommonName().matches("[A-CS-Z].+") && flower.isShadePreferred()
                        && flower.getFlowerVaseMaterial().stream()
                        .anyMatch(vaseMaterial -> vaseMaterial.matches("Glass|Aluminum|Steel")))
                .map(flower -> BigDecimal.valueOf(flower.getPrice() + flower.getWaterConsumptionPerDay() * 1.39 * 360 * 5))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);
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
        getTaskNumberMessage(18);
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(groupingBy(Student::getFaculty, averagingDouble(Student::getAge)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public static void task19() {
        getTaskNumberMessage(19);
        String group = "C-3";
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        examinations.stream()
                .filter(examination -> examination.getExam3() > 4)
                .flatMap(examination -> students.stream()
                        .filter(student -> student.getGroup().equals(group) && student.getId() == examination.getStudentId()))
                .forEach(System.out::println);
    }

    public static void task20() {
        getTaskNumberMessage(20);
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        Map<String, List<Integer>> map = students.stream()
                .collect(groupingBy(Student::getFaculty, flatMapping(student -> examinations.stream()
                        .filter(examination -> examination.getStudentId() == student.getId())
                        .map(Examination::getExam1), toList())));

        map.entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), entry.getValue().stream()
                        .collect(averagingDouble(value -> value))))
                .max(Comparator.comparing(facultyAvgMap -> facultyAvgMap.values().stream()
                        .findFirst()
                        .get()
                ))
                .ifPresent(System.out::println);
    }

    public static void task21() {
        getTaskNumberMessage(21);
        List<Student> students = Util.getStudents();
        Map<String, Long> map = students.stream()
                .collect(groupingBy(Student::getGroup, counting()));
        System.out.println(map);
    }

    public static void task22() {
        getTaskNumberMessage(22);
        List<Student> students = Util.getStudents();
        Map<String, Optional<Student>> map = students.stream()
                .collect(groupingBy(Student::getFaculty, minBy(Comparator.comparing(Student::getAge))));
        System.out.println(map);
    }
}
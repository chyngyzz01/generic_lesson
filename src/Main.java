import database.GenerateId;
import enums.Gender;
import models.Animal;
import models.Person;
import services.GenericService;
import services.impl.AnimalServiceImpl;
import services.impl.PersonServiceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenericService<Animal> genericService = new AnimalServiceImpl();
        GenericService<Person> genericService1 = new PersonServiceImpl();

        System.out.println("Choose the number (1-6");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Animal                       Person
                    1-String add(List<T>t);      7-String add(List<T>t);
                    2-T getById(Long id);        8-T getById(Long id);
                    3-List<T> getAll();          9-List<T> getAll();
                    4-List<T> sortByName();      10-List<T> sortByName();
                    5-List<T> filterByGender();  11-List<T> filterByGender();
                    6-List<T> clear();           12-List<T> clear();
                    """);
            try {


                switch (scanner.nextInt()) {
                    case 1:
                        System.out.print("Enter the name: ");
                        String scanName = scanner.next();
                        scanner.nextLine();

                        System.out.print("Enter the age: ");
                        int scanAge = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter the gender: ");
                        String scanGender = scanner.nextLine();

                        Gender gender = Gender.valueOf(scanGender.toUpperCase());
                        Animal animal = new Animal(GenerateId.generateAnimalId(), scanName, scanAge, gender);
                        List<Animal> animals = new LinkedList<>();
                        animals.add(animal);
                        System.out.println(genericService.add(animals));
                        break;
                    case 2:
                        System.out.print("Enter the id which animal you want to get: ");
                        Long scanId = scanner.nextLong();
                        System.out.println(genericService.getById(scanId));
                        break;
                    case 3:
                        System.out.println(genericService.getAll());
                        break;
                    case 4:
                        System.out.println(genericService.sortByName());
                        break;
                    case 5:
                        System.out.println(genericService.filterByGender());
                        break;
                    case 6:
                        System.out.println(genericService.clear());
                        break;
                    case 7:
                        System.out.print("Enter the name: ");
                        String scanPersonName = scanner.next();
                        scanner.nextLine();

                        System.out.print("Enter the age: ");
                        int scanPersonAge = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter the gender: ");
                        String scanPersonGender = scanner.nextLine();

                        Gender genderPerson = Gender.valueOf(scanPersonGender.toUpperCase());
                        Person person = new Person(GenerateId.generatePersonId(), scanPersonName, scanPersonAge, genderPerson);
                        List<Person> people = new LinkedList<>();
                        people.add(person);
                        System.out.println(genericService1.add(people));
                        break;
                    case 8:
                        System.out.print("Enter the id which person you want to get: ");
                        Long scanPersonId = scanner.nextLong();
                        System.out.println(genericService1.getById(scanPersonId));
                        break;
                    case 9:
                        System.out.println(genericService1.getAll());
                        break;
                    case 10:
                        System.out.println(genericService1.sortByName());
                        break;
                    case 11:
                        System.out.println(genericService1.filterByGender());
                        break;
                    case 12:
                        System.out.println(genericService1.clear());
                        break;
                    default:
                        System.out.println("Enter the correct number (1-12)");

                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
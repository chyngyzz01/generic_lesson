package dao.daoServiceImpl;

import dao.dao_service.DaoGenericService;
import database.DataBase;
import enums.Gender;
import models.Person;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DaoPersonServiceImpl implements DaoGenericService<Person> {

    @Override
    public String add(List<Person> t) {
        DataBase.people.addAll(t);
        return "Success";
    }

    @Override
    public Person getById(Long id) {
        for (Person person : DataBase.people) {
            if (person.getId().equals(id))
                return person;
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return DataBase.people;
    }

    @Override
    public List<Person> sortByName() {
        final List<Person> sortedPeople = new LinkedList<>(DataBase.people);
        Scanner scanner = new Scanner(System.in);
        System.out.print("If you want to sort a-z -> 1 && 2-> z-a");
        int sortNum = scanner.nextInt();
        if (sortNum == 1) {
            Comparator<Person> sortedPeopleByName = (o1, o2) -> o1.getName().compareTo(o2.getName());
            sortedPeople.sort(sortedPeopleByName);
        }

        if (sortNum == 2) {
            Comparator<Person> sortedPeopleByName = (o1, o2) -> o2.getName().compareTo(o1.getName());
            sortedPeople.sort(sortedPeopleByName);
        }
        return sortedPeople;
    }

    @Override
    public List<Person> filterByGender() {
        List<Person> filteredPeopleByGender = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("1 - female && 2 - male: ");
        int chosePersonNum = scanner.nextInt();
        if (chosePersonNum == 1) {
            for (Person person : DataBase.people) {
                if (person.getGender().equals(Gender.valueOf("FEMALE")))
                    filteredPeopleByGender.add(person);
            }
        }
        if (chosePersonNum == 2) {
            for (Person person : DataBase.people) {
                if (person.getGender().equals(Gender.valueOf("MALE")))
                    filteredPeopleByGender.add(person);
            }
        }

        return filteredPeopleByGender;
    }

    @Override
    public List<Person> clear() {
        DataBase.people.clear();
        return DataBase.people;
    }
}

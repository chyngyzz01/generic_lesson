package services.impl;

import dao.daoServiceImpl.DaoPersonServiceImpl;
import models.Person;
import services.GenericService;

import java.util.List;


public class PersonServiceImpl implements GenericService<Person> {
    DaoPersonServiceImpl daoPersonService = new DaoPersonServiceImpl();

    @Override
    public String add(List<Person> t) {
        return daoPersonService.add(t);
    }

    @Override
    public Person getById(Long id) {
        return daoPersonService.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return daoPersonService.getAll();
    }

    @Override
    public List<Person> sortByName() {
        return daoPersonService.sortByName();
    }

    @Override
    public List<Person> filterByGender() {
        return daoPersonService.filterByGender();
    }

    @Override
    public List<Person> clear() {
        return daoPersonService.clear();
    }
}

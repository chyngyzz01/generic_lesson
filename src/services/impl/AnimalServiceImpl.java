package services.impl;

import dao.daoServiceImpl.DaoAnimalServiceImpl;
import dao.dao_service.DaoGenericService;
import models.Animal;
import services.GenericService;

import java.util.List;
import java.util.Scanner;

public class AnimalServiceImpl implements GenericService<Animal> {

    private final DaoGenericService<Animal> daoGenericService = new DaoAnimalServiceImpl();

    @Override
    public String add(List<Animal> t) {
        return daoGenericService.add(t);
    }

    @Override
    public Animal getById(Long id) {
        return daoGenericService.getById(id);
    }

    @Override
    public List<Animal> getAll() {
        return daoGenericService.getAll();
    }

    @Override
    public List<Animal> sortByName() {
        return daoGenericService.sortByName();
    }

    @Override
    public List<Animal> filterByGender() {
        return daoGenericService.filterByGender();
    }

    @Override
    public List<Animal> clear() {
        return daoGenericService.clear();
    }
}

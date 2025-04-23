package dao.daoServiceImpl;

import dao.dao_service.DaoGenericService;
import database.DataBase;
import enums.Gender;
import models.Animal;

import java.util.*;

public class DaoAnimalServiceImpl implements DaoGenericService<Animal> {
    @Override
    public String add(List<Animal> t) {
        if (t.isEmpty())
            return "Can not be null: " + t;
        DataBase.animals.addAll(t);
        return "Successfully added animal";
    }

    @Override
    public Animal getById(Long id) {
        for (Animal animal_db : DataBase.animals) {
            if (animal_db.getId().equals(id))
                return animal_db;
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return DataBase.animals;
    }

    @Override
    public List<Animal> sortByName() {
        List<Animal> sortedAnimals = new LinkedList<>(DataBase.animals);
        Scanner scanner = new Scanner(System.in);
        System.out.print("If you want to sort a-z -> 1 && 2-> z-a");
        int sortNum = scanner.nextInt();
        if (sortNum == 1) {
            Comparator<Animal> sortedAnimalsByName = (o1, o2) -> o1.getName().compareTo(o2.getName());
            sortedAnimals.sort(sortedAnimalsByName);
        }
        if (sortNum == 2) {
            Comparator<Animal> sortedAnimalsByName = (o1, o2) -> o2.getName().compareTo(o1.getName());
            sortedAnimals.sort(sortedAnimalsByName);
        }
        return sortedAnimals;
    }

    @Override
    public List<Animal> filterByGender() {
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("1 - male && 2 - female: ");
        int choseNum = scanner.nextInt();
        if (choseNum == 1) {
            for (Animal animal : DataBase.animals) {
                if (animal.getGender().equals(Gender.valueOf("MALE"))) {
                    animals.add(animal);
                }
            }
        }

        if (choseNum == 2) {
            for (Animal animal : DataBase.animals) {
                if (animal.getGender().equals(Gender.valueOf("FEMALE"))) {
                    animals.add(animal);
                }
            }
        }
        return animals;
    }

    @Override
    public List<Animal> clear() {
        DataBase.animals.clear();
        return DataBase.animals;
    }
}

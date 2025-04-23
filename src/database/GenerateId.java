package database;

public class GenerateId {
    private static Long personId = 0L;
    private static Long animalId = 0L;

    public static Long generatePersonId() {
        return ++personId;
    }

    public static Long generateAnimalId() {
        return ++animalId;
    }
}

public class UserGenerator {
    public static User getDefaultUser() {
        return new User(DataGenerator.getRandomString().toLowerCase(), DataGenerator.getRandomEmail().toLowerCase(),
                DataGenerator.getRandomString().toLowerCase());
    }

    public static User getUserWitIncorrectPassword() {
        return new User(DataGenerator.getRandomString(), DataGenerator.getRandomEmail(),
                DataGenerator.getRandomStringPhone());
    }
}
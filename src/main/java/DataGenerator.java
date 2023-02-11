import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {
    public static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public static String getRandomEmail() {
        return (RandomStringUtils.randomAlphabetic(5) + "@yandex.ru");
    }

    public static String getRandomStringPhone() {
        return RandomStringUtils.randomNumeric(5);
    }

}

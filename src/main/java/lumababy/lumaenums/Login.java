package lumababy.lumaenums;
import com.github.javafaker.Faker;

public enum Login {
    EMAIL("adamvanderborg@gmail.com"),
    PASSWORD("Panera76!"),
    INVALID_LOGIN("");

    private static String fakeEmail;
    private static String fakePassword;

    static {
        Faker faker = new Faker();
        fakeEmail = faker.internet().emailAddress();
        fakePassword = faker.internet().password();
    }

    private final String login;

    private Login(String login) {
        this.login = login;
    }

    public String getLogin() {
        if (this == INVALID_LOGIN) {
            return fakeEmail;
        }
        return login;
    }

    public String getPassword() {
        if (this == INVALID_LOGIN) {
            return fakePassword;
        }
        return login;
    }
}

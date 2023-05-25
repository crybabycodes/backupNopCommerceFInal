package nopcommerce.nopcommerceobjects;

import com.github.javafaker.Faker;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Customer {

    @lombok.Builder.Default
    String firstName = new Faker().name().firstName();

    @lombok.Builder.Default
    String lastName = new Faker().name().lastName();

    @lombok.Builder.Default
    String fullName = new Faker().name().fullName();

    @lombok.Builder.Default
    String senderName = String.valueOf(new Faker().funnyName());

    @lombok.Builder.Default
    String email = new Faker().bothify("????????###@gmail.com");

    @lombok.Builder.Default
    String senderEmail = new Faker().bothify("??????####@gmail.com");

    @lombok.Builder.Default
    String city = new Faker().address().city();

    @lombok.Builder.Default
    String address = new Faker().address().streetAddress();

    @lombok.Builder.Default
    String state = new Faker().address().state();

    @lombok.Builder.Default
    String zipCode = new Faker().address().zipCode();

    @lombok.Builder.Default
    String phoneNumber = new Faker().phoneNumber().cellPhone();

    @lombok.Builder.Default
    String password = new Faker().bothify("???????").toLowerCase();

    @lombok.Builder.Default
    String newPassword = new Faker().bothify("?????????").toLowerCase();

    @lombok.Builder.Default
    String message = new Faker().rickAndMorty().character();
}

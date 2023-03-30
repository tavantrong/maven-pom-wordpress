package utilitiesConfig;

import java.util.Locale;
import com.github.javafaker.Faker;

public class FakerConfig {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);

	public static FakerConfig getData() {
		return new FakerConfig();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getCompanyName() {
		return faker.company().name();
	}

	public String getFullName() {
		return faker.name().fullName();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getPhone() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getPassword() {
		return faker.internet().password();
	}

	public String getCityName() {
		return faker.address().cityName();
	}
}

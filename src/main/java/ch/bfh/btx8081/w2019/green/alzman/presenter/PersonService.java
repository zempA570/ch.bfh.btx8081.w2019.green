package ch.bfh.btx8081.w2019.green.alzman.presenter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;


public class PersonService {
	
	private static String[] firstName = { "James", "John", "Robert", "Michael", "William", "David", "Richard",
			"Charles", "Joseph", "Christopher", "Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "Jennifer",
			"Maria", "Susan", "Margaret", "Dorothy", "Lisa" };

	private static String[] lastName = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson",
			"Moore", "Taylor", "Andreson", "Thomas", "Jackson", "White" };

	private static List<AddPerson> persons;

	public List<AddPerson> getAllPersons() {
		if (persons == null) {

			final Random r = new Random();

			persons = new ArrayList<AddPerson>();
			for (int i = 0; i < 100; i++) {
				final AddPerson person = new AddPerson();
				person.setGender("Mann");
				person.setFirstname(firstName[r.nextInt(firstName.length)]);
				person.setLastname(lastName[r.nextInt(lastName.length)]);
				person.setAdress("Di Per");
				person.setAdressNr("556H");
				person.setPostcode("3390");
				person.setCity("Bern");
				person.setPhonenummber("0041791799999");
				

				persons.add(person);
			}
		}
		return persons;
	}

}

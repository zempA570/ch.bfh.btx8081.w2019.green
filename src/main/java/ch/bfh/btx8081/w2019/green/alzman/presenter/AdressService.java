package ch.bfh.btx8081.w2019.green.alzman.presenter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.model.AddPerson;


public class AdressService {
	
	private static String[] firstName = { "James", "John", "Robert", "Michael", "William", "David", "Richard",
			"Charles", "Joseph", "Christopher", "Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "Jennifer",
			"Maria", "Susan", "Margaret", "Dorothy", "Lisa" };

	private static String[] lastName = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson",
			"Moore", "Taylor", "Andreson", "Thomas", "Jackson", "White" };

	private static List<AddAdress> adresses;

	public List<AddAdress> getAllAdress() {
		if (adresses == null) {

			final Random r = new Random();

			adresses = new ArrayList<AddAdress>();
			for (int i = 0; i < 100; i++) {
				final AddAdress adress = new AddAdress();

				adress.setName(firstName[r.nextInt(firstName.length)]);
				adress.setAdress("Di Per");
				adress.setAdressNr("556H");
				adress.setPostcode("3390");
				adress.setCity("Bern");
				adress.setPhonenummber("0041791799999");
				

				adresses.add(adress);
			}
		}
		return adresses;
	}

}

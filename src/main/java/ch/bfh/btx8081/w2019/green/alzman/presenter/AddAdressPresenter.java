package ch.bfh.btx8081.w2019.green.alzman.presenter;


import java.util.List;
import java.util.Objects;



import ch.bfh.btx8081.w2019.green.alzman.model.AddAdress;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.AddAdressInfoboxView;


public class AddAdressPresenter {

	private AddAdressInfoboxView adressInfoboxView;

	private List<AddAdress> adresses;

	public AddAdressPresenter() {

	}

	// constructor for the presenter
	public AddAdressPresenter(AddAdressInfoboxView infoboxView) {
		this.adressInfoboxView = infoboxView;
	}

	public void deleteAdress(String inportantAdress) {

		DbService.em.getTransaction().begin();

		// get the id number of the user which is at the beginning of the string
		int AdressId = Integer.parseInt(inportantAdress.substring(0, inportantAdress.indexOf(" ")));

		AddAdress adressToDelete = null;

		// for every user we have in our list
		for (AddAdress adr : adresses) {
			// if the id of that user is the same as the id we got from the userIdFullname
			if (Objects.equals(adr.getId(), AdressId)) {
				// this is the user we want to delete
				adressToDelete = adr;
			}
		}

		// this is the part where we use the DB
		DbService.em.remove(adressToDelete);
		DbService.em.getTransaction().commit();

	}

	public void addAdress(String name, String adress, String adressNr, String postcode, String city,
			String phonenummber) {

		// create new user
		AddAdress newAdress = new AddAdress(name, adress, adressNr, postcode, city, phonenummber);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(newAdress);
		DbService.em.getTransaction().commit();

	}

}

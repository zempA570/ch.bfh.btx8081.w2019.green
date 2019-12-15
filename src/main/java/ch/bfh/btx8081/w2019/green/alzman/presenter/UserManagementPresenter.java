package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Query;

import ch.bfh.btx8081.w2019.green.alzman.model.User;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.UserManagementView;

/**
 * 
 * @author Adrian
 *
 */
public class UserManagementPresenter {

	private UserManagementView view;
	private List<User> users;

	// constructor for the presenter
	public UserManagementPresenter(UserManagementView userManagementView) {
		this.view = userManagementView;

		fillComboboxWithUsers();

	}

	public void deleteUser(String userIdFullname) {

		DbService.em.getTransaction().begin();

		// get the id number of the user which is at the beginning of the string
		int userId = Integer.parseInt(userIdFullname.substring(0, userIdFullname.indexOf(" ")));

		User userToDelete = null;

		// for every user we have in our list
		for (User user : users) {
			// if the id of that user is the same as the id we got from the userIdFullname
			if (Objects.equals(user.getId(), userId)) {
				// this is the user we want to delete
				userToDelete = user;
			}
		}

		// this is the part where we use the DB
		DbService.em.remove(userToDelete);
		DbService.em.getTransaction().commit();

		// after the user is deleted we "refresh" the list in the combobox so the
		// deleted user is gone
		fillComboboxWithUsers();

//		TODO when to close?
		// DbService.em.close();

	}

	public void addUser(String firstName, String lastName) {

		// create new user
		User newUser = new User(firstName, lastName);

		// DB stuff
		DbService.em.getTransaction().begin();
		DbService.em.persist(newUser);
		DbService.em.getTransaction().commit();

		// clear the textfields where the user entered the data
		view.clearTextfields();

		// after the user is added we "refresh" the list in the combobox so the new user
		// appears
		fillComboboxWithUsers();

	}

	private void fillComboboxWithUsers() {

		// DB stuff where we get all the users
		Query query = DbService.em.createNativeQuery("SELECT * FROM Relative", User.class);

		// get list of users out of the query
		users = query.getResultList();

		
		
		
		List<String> userNames = new ArrayList<String>();
		// for every user in our list
		for (User user : users) {
			// we add the id and fullname of that user to our List<String>
			userNames.add(user.getId() + " " + user.getFullName());
		}

		// then we tell the view to fill the combobox with the List<String>
		view.fillComboboxWithUsers(userNames);

//		TODO message to user that was deleted?

	}

}

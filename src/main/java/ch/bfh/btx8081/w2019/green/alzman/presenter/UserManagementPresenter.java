package ch.bfh.btx8081.w2019.green.alzman.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Query;

import com.vaadin.flow.component.button.Button;

import ch.bfh.btx8081.w2019.green.alzman.model.UserModel;
import ch.bfh.btx8081.w2019.green.alzman.services.DbService;
import ch.bfh.btx8081.w2019.green.alzman.view.UserManagementView;
import ch.bfh.btx8081.w2019.green.alzman.view.UserManagementView.UserManagagementViewListener;

/**
 * 
 * @author Adrian
 *
 */
public class UserManagementPresenter implements UserManagementView.UserManagagementViewListener {

	private UserManagementView view;
	private UserModel model;
	private List<UserModel> users;

	// constructor for the presenter
	public UserManagementPresenter(UserManagementView view, UserModel model) {
		this.view = view;
		this.model = model;
		view.addListener(this);

		fillComboboxWithUsers();
	}

	public void deleteUser() {

		String comboboxValue = view.getComboboxValue();

		// get the id number of the user which is at the beginning of the string
		int userId = Integer.parseInt(comboboxValue.substring(0, comboboxValue.indexOf(" ")));

		UserModel userToDelete = null;

		// for every user we have in our list
		for (UserModel user : users) {
			// if the id of that user is the same as the id we got from the userIdFullname
			if (Objects.equals(user.getId(), userId)) {
				// this is the user we want to delete
				userToDelete = user;
			}
		}
		
		DbService.remove(userToDelete);

		// after the user is deleted we "refresh" the list in the combobox so the
		// deleted user is gone
		fillComboboxWithUsers();

//		TODO when to close
		// DbService.em.close();

	}

	public void addUser() {

		String firstName = view.getFirstname();
		String lastName = view.getLastname();

		// create new user
		UserModel newUser = new UserModel(firstName, lastName);

		// DB stuff
		DbService.persist(newUser);

		// clear the textfields where the user entered the data
		view.clearTextfields();

		// after the user is added we "refresh" the list in the combobox so the new user
		// appears
		fillComboboxWithUsers();

	}

	private void fillComboboxWithUsers() {

		// DB stuff where we get all the users
		Query query = DbService.em.createNativeQuery("SELECT * FROM Relative", UserModel.class);

		// get list of users out of the query
		users = query.getResultList();

		List<String> userNames = new ArrayList<String>();
		// for every user in our list
		for (UserModel user : users) {
			// we add the id and fullname of that user to our List<String>
			userNames.add(user.getId() + " " + user.getFullName());
		}

		// then we tell the view to fill the combobox with the List<String>
		view.setComboboxItems(userNames);

//		TODO message to user that was deleted?

	}

	@Override
	public void buttonClick(Button button) {

		String buttonText = button.getText();

		switch (buttonText) {
		case "Add User":
			addUser();
			break;
		case "Delete User":
			deleteUser();
			break;
		default:
			// TODO
			;
		}

	}

}

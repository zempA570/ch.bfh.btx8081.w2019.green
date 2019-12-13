package usermanagement;

import java.util.List;

import com.vaadin.flow.component.button.Button;

public interface UserManagementView {

	interface UserManagagementViewListener {
		void buttonClick(Button button);
	}

	public void addListener(UserManagagementViewListener listener);

	public void clearTextfields();
	
	public String getFirstname();
	
	public String getLastname();
	
	public String getComboboxValue();

	public void setComboboxItems(List<String> userNames);

}

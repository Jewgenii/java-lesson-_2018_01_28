package lesson_2018_01_28;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Controller {
	 private ArrayList<String> users;
	 private DefaultListModel<String> dlm;
	 
	 public Controller(DefaultListModel<String> dlm) {
		 
		 this.dlm = dlm;
		 users = new ArrayList<>();
		 users.add("Hell0o");
		 users.add("Hell0o");
		 users.add("Hell0o");
		 users.add("Hell0o");
		 users.add("Hell0o");
		 users.add("Hell0o");
		 users.add("Hell0o");
		 users.add("Hell0o");
		 users.add("Hell0o");
		 users.add("Hell0o");
		 this.refresh();
		 
	 }
	 
	 public void deleteItem(int selectedRow) {
		 System.out.println(selectedRow);
		 users.remove(selectedRow);
		 this.refresh();
	 }
	/**
	 * @return the users
	 */
	public ArrayList<String> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}
	/**
	 * @return the dlm
	 */
	public DefaultListModel<String> getDlm() {
		return dlm;
	}
	/**
	 * @param dlm the dlm to set
	 */
	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
	}
	 
	public void refresh() {
		
		dlm.clear();
		for(String s:users) {
			dlm.addElement(s);
		}
		
	}
}

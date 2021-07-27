package chat.utils;

import chat.UserData;
import chat.utils.services.UserService;

/**
 * saves/loads Users with XML (JAXB)
 * @author Daniel Schmid
 */
public class XMLController {
	/**
	 * loads a user
	 * @param name the File to be loaded
	 * @return the user the loaded user
	 */
	public static UserData loadUser(String name) {
		UserService userService = new UserService();
		return userService.loadUser(name);
	}
	/**
	 * saves a User to a File
	 * @param data the user
	 */
	public static void saveUser(UserData data) {
		UserService userService = new UserService();
		userService.saveUser(data);
	}
}

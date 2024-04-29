package model;

public class Controller {

	private User[] users;

	public Controller() {

		users = new User[10];
		testCases();

	}

	public void testCases() {

		registerUserPremium("1234", "John Smith", "Smithy",2);
		registerUserRegular("12346", "Johana Smith", "jh");
		// users[1] = new User("5678", "Pocahontas", "Pocah");
	}

	public String getUserList() {

		String msg = "N°-CEDULA----NOMBRE";

		for (int i = 0; i < users.length; i++) {

			if (users[i] != null) {
				msg += "\n" + (i + 1) + ". " + users[i].getId() + " - " + users[i].getName();
			}

		}

		return msg;

	}



	

	public String listCategory() {

		Category[] arrayCategories = Category.values();

		String lista = "";

		for (int i = 0; i < arrayCategories.length; i++) {

			lista += "\n" + (i + 1) + "- " + arrayCategories[i];

		}

		return lista;

	}

	public boolean registerUserPremium(String id, String name, String nickname, int category ) {
		
		Premium newUserPremium = new Premium(id, name, nickname,Category.values()[category - 1]);

		for (int i = 0; i < users.length; i++) {

			if (users[i] == null) {

				users[i] = newUserPremium;

				return true;

			} else if (users[i].getId().equals(id)) {

				return false;
			}

		}
		return false;
	}

	public boolean registerUserRegular(String id, String name, String nickname) {

		Regular newUsRegular = new Regular(id, name, nickname);

		for (int i = 0; i < users.length; i++) {

			if (users[i] == null) {

				users[i] = newUsRegular;

				return true;

			} else if (users[i].getId().equals(id)) {

				return false;
			}

		}
		return false;
	}
	public User searchUser(String id) {

		for (int i = 0; i < users.length; i++) {

			User temporal = users[i];

			if (temporal != null) {

				if (id.equals(temporal.getId())) {

					return temporal;

				}
			}

		}

		return null;

	}
	public int searchIndexUser(String id) {

		for (int i = 0; i < users.length; i++) {

			User temporal = users[i];

			if (temporal != null) {

				if (id.equals(temporal.getId())) {

					return i;

				}
			}

		}

		return -1;

	}
	public boolean editUser(int userPosition) {		
		return false;
	}
	
	public boolean updateNameUser(String id, String name){
		return searchUser(id).setName(name);
	}
	public boolean updateCategoryUser(String id, int category){
		return ((Premium)searchUser(id)).setCategory(Category.values()[category - 1]);//Debes usar casting para acceder al metodo especifico de la clase hija 
	}

	public boolean deleteUser(String userPosition) {
		int index =searchIndexUser(userPosition);
		if(index != -1){
			users[index]=null;
			return true;
		}

		return false;
	}

	public String getUserInfo(String id) {

		User temporal = searchUser(id);

		if (temporal == null) {

			return "El usuario no se encuentra";
		}

		return temporal.toString();
	}



	public String getAllUserInfo() {

		String msg = "";
		int counterPremium = 0;
		int counterRegular = 0;

		for (int i=0; i<users.length;i++){
			if (users[i]!=null){
				if (users[i] instanceof Premium){
					counterPremium++;
				}else if(users[i] instanceof Regular){
					counterRegular++;
				}
			}
		}

		msg+="El inventario esta compuesto de la siguiente manera: \n"+
		"Usuarios Premiums: "+counterPremium+
		"\nUsuarios Regulares: "+counterRegular;

		return msg;
	}
	public int getValidateUser(String id) {
		int msg = 0;
		int index =searchIndexUser(id);
		
		for (int i=0; i<users.length;i++){
			if (users[i]!=null){
				if (users[index] instanceof Premium){
					msg=1;
				}else if(users[index] instanceof Regular){
					msg=2;
				}
			}
		}
		return msg;
	}



	public String getAllUserInfoCategory() {

		String msg = "";
		int counterOro = 0;
		int counterPlata = 0;
		int counterDiamante = 0;

		for (int i=0; i<users.length;i++){
			if (users[i]!=null){
				if (users[i] instanceof Premium){
					if (((Premium)users[i]).getCategory() == Category.ORO) {
						counterOro++;
					}else if(((Premium)users[i]).getCategory() == Category.PLATA){
						counterPlata++;
					}else if(((Premium)users[i]).getCategory() == Category.DIAMANTE){
						counterDiamante++;
					}
				}
			}
		}

		msg+="De los usuarios Premium tenemos el siguiente inventario \n"+
		"Usuarios Premiums ORO: "+counterOro+
		"\nUsuarios Premiums PLATA: "+counterPlata+
		"\nUsuarios Premiums DIAMANTE: "+counterDiamante;

		return msg;
	}



}

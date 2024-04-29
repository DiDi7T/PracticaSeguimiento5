package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller rXSystem;

	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	private void menu() {

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMENU PRINCIPAL");
			System.out.println("\n1. Registrar usuario");
			System.out.println("2. Modificar usuario");
			System.out.println("3. Borrar usuario");
			System.out.println("4. Consultar informacion de un usuario");
			System.out.println("5. Reporte de usuarios registrados");
			System.out.println("6. Salir");
			int option = reader.nextInt();

			switch (option) {

				case 1:
					System.out.println("Que tipo de usuario quieres registrar?\n1)Regular\n2)Premium");
					int type = reader.nextInt();
					switch (type) {
						case 1:
							registerUserRegular();
							break;
						case 2:
							registerUserPremium();
							break;
						default:
							System.out.println("Opcion invalida");
							break;
					}

					break;
				case 2:
					modifyUser();
					break;
				case 3:
					deleteUser();
					break;
				case 4:
					showUserInfo();
					break;
				case 5:
					showAllUserInfo();
					break;
				case 6:
					flag = true;
					break;
				default:
					System.out.println("Opcion invalida");
					break;

			}

		}

	}

	private void registerUserRegular() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el nickname");
		String nickname = reader.nextLine();

		if (rXSystem.registerUserRegular(id, name, nickname)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}
	}

	private void registerUserPremium() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el nickname");
		String nickname = reader.nextLine();

		System.out.println("Seleccione la categoria del usuario");
		System.out.println(rXSystem.listCategory());
		int category = reader.nextInt();

		if (rXSystem.registerUserPremium(id, name, nickname, category)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}
	}

	private void modifyUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);
			reader.nextLine();

			System.out.println("\nDigita el id del usuario a editar");

			String option = reader.nextLine();

			int typeUserOption = rXSystem.getValidateUser(option);
			String query2 = rXSystem.getUserInfo(option);

			if (query2.equals("")) {
				System.out.println("La operación no pudo realizarse");
			} else {
				System.out.println("INFORMACION DEL USUARIO");
				System.out.println(query2);
			}

			switch (typeUserOption) {
				case 1:
					System.out.println("Deseas modificar el nombre? si/no");
					String option1 = reader.nextLine();
					if (option1.equalsIgnoreCase("si")) {
						System.out.println("Digite el nuevo nombre del usuario");
						String newNamePremium = reader.nextLine();
						rXSystem.updateNameUser(option, newNamePremium);
					}
					System.out.println("Seleccione la nueva categoria del usuario");
					System.out.println(rXSystem.listCategory());
					int category = reader.nextInt();

					//rXSystem.updateCategoryUser(option, category);
					if (rXSystem.updateCategoryUser(option, category)) {

						System.out.println("\nUsuario editado exitosamente");

					} else {

						System.out.println("\nError, el usuario no pudo ser editado");
					}

					break;

				case 2:
					System.out.println("Digite el nuevo nombre del usuario");
					String newNameRegular = reader.nextLine();
					//rXSystem.updateNameUser(option, newNameRegular);
					if (rXSystem.updateNameUser(option, newNameRegular)) {

						System.out.println("\nUsuario editado exitosamente");

					} else {

						System.out.println("\nError, el usuario no pudo ser editado");
					}

					
				break;

			}

			

		}

	}

	private void deleteUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);
			reader.nextLine();

			System.out.println("\nDigite la cedula del usuario a borrar");

			String option = reader.nextLine();

			if (rXSystem.deleteUser(option)) {

				System.out.println("\nUsuario borrado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser borrado");
			}

		}

	}

	private void showUserInfo() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);
			reader.nextLine();
			System.out.println("\nDigite el id del usuario a consultar");

			String id = reader.nextLine();

			String query2 = rXSystem.getUserInfo(id);

			if (query2.equals("")) {
				System.out.println("La operación no pudo realizarse");
			} else {
				System.out.println(query2);
			}

		}

	}

	private void showAllUserInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllUserInfo();
		String queryCategory = rXSystem.getAllUserInfoCategory();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {
			System.out.println(query);
			System.out.println(queryCategory);
		}

	}

}
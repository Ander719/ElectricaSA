package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import herencia.Empleado;
import herencia.Jefe;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		ArrayList<Empleado> empleados = new ArrayList<>();

		System.out.println("Cambio");
		int opc = 0;
		do {
			mostrarOpcionesMenu();
			opc = scanner.nextInt();
			if (empleados.isEmpty() && opc > 1 && opc < 10) {
				System.out.println("No hay empleados registrados.");
			} else {
				switch (opc) {
				case 0:
					introducirEmpleados(scanner, empleados);
					break;

				case 1:
					visualizarDatos(empleados);
					break;
				case 2:
					visualizarJefes(empleados);
					break;
				case 3:
					jefesDepaConcreto(empleados, scanner);
					break;
				case 4:
					buscarNombre(empleados, scanner);
					break;
				case 5:
					mostrarSalario(empleados, scanner);
					break;
				case 6:
					aniosJefes(empleados, scanner);
					break;
				case 7:
					eliminarPorDni(scanner, empleados);
					break;
				case 8:
					//ordenaAlfabeticamnete(empleados);
					break;
				case 910:
					System.out.println("Saliendo...s");
					break;

				default:
					System.out.println("Opción no valida");
					break;
				}
			}
		} while (opc != 10);
	}

	private static void jefesDepaConcreto(ArrayList<Empleado> empleados, Scanner scanner) {
		String depaBuscar;
		boolean compro = false;

		System.out.println("Introduce el departamento a buscar:");
		depaBuscar = scanner.next();
		for (Empleado empl : empleados) {
			if (empl instanceof Jefe && ((Jefe) empl).getDepa().equalsIgnoreCase(depaBuscar)) {
				if (compro = false) {
					System.out.println("Jefe/s del departamento " + depaBuscar);
					compro = true;
				}
				System.out.println(empl.getNombreEmpleado());

			}
		}
		if (compro == false) {
			System.out.println("No se encontró ningún jefe en ese departamento.");
		}
	}

	private static void eliminarPorDni(Scanner scanner, ArrayList<Empleado> empleados) {
		String dniBuscar;
		boolean compro = false;

		System.out.println("Introduce el DNI del empleado a dar de baja:");
		dniBuscar = scanner.next();

		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getDniEmpleado().equalsIgnoreCase(dniBuscar)) {
				empleados.remove(i);
				System.out.println("Empleado eliminado correctamente.");
				compro = true;
			}
		}
		if (compro == false) {
			System.out.println("No se encontró ningún empleado con ese dni.");

		}
	}

	private static void aniosJefes(ArrayList<Empleado> empleados, Scanner scanner) {
		int anioBuscar;
		boolean compro = false;

		System.out.println("Introduce los años a buscar:");
		anioBuscar = scanner.nextInt();
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i) instanceof Jefe) {
				if ((LocalDate.now().getYear() - (empleados.get(i).getAnioEntrado())) > anioBuscar) {
					System.out.println("DNI: " + empleados.get(i).getDniEmpleado() + ", Años en la empresa: "
							+ (LocalDate.now().getYear() - empleados.get(i).getAnioEntrado()) + ", Es jefe: "
							+ (empleados.get(i) instanceof Jefe));
					compro = true;
				}
			}
		}
		if (compro == false) {
			System.out.println("No se encontró ningún jefe con esos años.");
		}
	}

	private static void buscarNombre(ArrayList<Empleado> empleados, Scanner scanner) {
		String nombreBuscar;
		boolean compro = false;

		System.out.println("Introduce el nombre a buscar:");
		nombreBuscar = scanner.next();
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getNombreEmpleado().contains(nombreBuscar)) {
				System.out.println("DNI: " + empleados.get(i).getDniEmpleado() + ", Años en la empresa: "
						+ (LocalDate.now().getYear() - empleados.get(i).getAnioEntrado()) + ", Es jefe: "
						+ (empleados.get(i) instanceof Jefe));
				compro = true;
			}
		}
		if (compro == false) {
			System.out.println("No se encontró ningún empleado con ese nombre.");
		}
	}

	private static void mostrarSalario(ArrayList<Empleado> empleados, Scanner scanner) {
		int salarioIntro;
		boolean compro = false;

		System.out.println("Introduce el salario que quieres buscar: ");
		salarioIntro = scanner.nextInt();
		for (int i = 0; i < empleados.size(); i++) {
			if (salarioIntro <= empleados.get(i).getSueldoBase()) {
				System.out.println(empleados.get(i));
				compro = true;
			}
		}
		if (compro == false) {
			System.out.println("No hay ningun empleado o jefe que supere ese salario");
		}
	}

	private static void visualizarJefes(ArrayList<Empleado> empleados) {
		for (Empleado empl : empleados) {
			if (empl instanceof Jefe) {
				System.out.println(empl);
			}
		}
	}

	private static void visualizarDatos(ArrayList<Empleado> empleados) {
		for (int i = 0; i < empleados.size(); i++) {
			System.out.println(empleados.get(i));
		}
	}

	private static void mostrarOpcionesMenu() {
		System.out.println("0.Introducir datos de empleade/s y/o jefe/s comprobando que no existan ya");
		System.out.println("1.Visualizar todos los datos");
		System.out.println("2.Visualizar les jefes");
		System.out.println("3.Visualizar les jefe/s de un departamento concreto");
		System.out.println("4.Introducir nombre");
		System.out.println("5.Introducir un salario y mostrar");
		System.out.println("6.Introducir un nº de años y mostrar les jefes");
		System.out.println("7.Dar de baja a un empleade/jefe");
		System.out.println("8.Estadística ordenada alfabéticamente por departamento");
		System.out.println("9.Salir.");
		System.out.println("Elegir opcion");
	}

	private static void introducirEmpleados(Scanner scanner, ArrayList<Empleado> empleados) {
		Empleado empl;
		String dni;
		int existeEmpleado;
		boolean seguir = true, esJefe;

		for (; seguir;) {
			System.out.println("Introduce el dni: ");
			dni = scanner.next();
			existeEmpleado = buscarEmpleado(empleados, dni);
			if (existeEmpleado == -1) {
				System.out.println("¿Es jefe?");
				esJefe = scanner.next().equalsIgnoreCase("si");
				if (esJefe) {
					empl = new Jefe();

				} else {
					empl = new Empleado();
				}
				empl.setDatos(dni);
				empleados.add(empl);
				System.out.println("Añadido exitosamente.");
			} else {
				System.out.println("Ya existe un empleado con ese dni.");
			}

			System.out.println("Quieres seguir introduciendo empleados?");
			seguir = scanner.next().equalsIgnoreCase("SI");
		}
	}

	private static int buscarEmpleado(ArrayList<Empleado> empleados, String dni) {
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getDniEmpleado().equalsIgnoreCase(dni)) {
				return 0;
			}
		}
		return -1;
	}

}

package herencia;

import java.time.LocalDate;
import java.util.Scanner;

public class Empleado {
	//Scanner
	Scanner sc = new Scanner(System.in);	
	
	//Atributos
	private String dniEmpleado;
	private String nombreEmpleado;
	private int mesEntrado;
	private int anioEntrado;
	private float porcentaje;	
	private final static String NOMBRE_EMPRESA="ElecticaSA";
	private float sueldoBase;
	private int fechaActual=(LocalDate.now().getYear());
	private int mesActual=(LocalDate.now().getMonthValue());
	
	//Getters & Setters
	public String getDniEmpleado() {
		return dniEmpleado;
	}


	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}


	public String getNombreEmpleado() {
		return nombreEmpleado;
	}


	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}


	public int getMesEntrado() {
		return mesEntrado;
	}


	public void setMesEntrado(int mesEntrado) {
		this.mesEntrado = mesEntrado;
	}


	public int getAnioEntrado() {
		return anioEntrado;
	}


	public void setAnioEntrado(int anioEntrado) {
		this.anioEntrado = anioEntrado;
	}


	public float getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}


	public float getSueldoBase() {
		return sueldoBase;
	}


	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}


	public int getFechaActual() {
		return fechaActual;
	}


	public void setFechaActual(int fechaActual) {
		this.fechaActual = fechaActual;
	}


	public static String getNombreEmpresa() {
		return NOMBRE_EMPRESA;
	}

	

	public Empleado() {

		this.sueldoBase=1000;
	}


	// Metodos
		public float incremento (){
			sueldoBase+=(sueldoBase*porcentaje)/100;
			if (fechaActual-anioEntrado>6) {
				sueldoBase+=100;
			}
				if (fechaActual-anioEntrado==6) {
					if (mesEntrado>=mesActual) {
						sueldoBase=+100;
					}
				}
			return sueldoBase;
			
		} 
	
	
	@Override
	public String toString() {
		return "Empleado [dniEmpleado=" + dniEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", mesEntrado="
				+ mesEntrado + ", anioEntrado=" + anioEntrado + ", porcentaje=" + porcentaje + ", sueldoBase="
				+ incremento() + ", anituguedad=" + (fechaActual-anioEntrado) + "]";
	}


	public void setDatos (String dni) {
		dniEmpleado=dni;
		System.out.println("Introduce el nombre: ");
		nombreEmpleado=sc.next();
		System.out.println("Introduce el mes de entrada: ");
		mesEntrado=sc.nextInt();
		System.out.println("Introduce el año de entrada: ");
		anioEntrado=sc.nextInt();
		System.out.println("Introduce el porcentaje de beneficio: ");
		porcentaje=sc.nextFloat();
	}

	
	
}

package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.Gestor;
import cr.ac.ucenfotec.ui.UI;

import java.io.IOException;
import java.time.LocalDate;

public class Controller {

    private UI interfaz = new UI();
    private Gestor controllerGestor = new Gestor();

    public Controller(){
    }
    public void start() throws IOException {
        int opcion = -1;
        do{
            interfaz.mostrarMenu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);
        }
        while (opcion!=-0);
    }

    public void procesarOpcion(int pOpcion) throws java.io.IOException
    {
        switch (pOpcion)
        {
            case 1:
                registrarUsuario();
                break;
            case 2:
                //listarUsuarios();
                break;
            case 3:
                //registrarMaterial();
                break;
            case 4:
                //listarMateriales();
                break;
            case 5:
                //registrarPrestamo();
                break;
            case 6:
                //realizarDevolucionPrestamo();
                break;
            case 7:
                interfaz.imprimirMensaje( "Fin !!");
                break;
            default:
                interfaz.imprimirMensaje("Opcion inválida");
                break;
        }
    }

    public void registrarUsuario()throws IOException {
        String nombre;
        String apellido;
        interfaz.imprimirMensaje("Digite el nombre del nuevo usuario");
        nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el apellido");
        apellido = interfaz.leerTexto();
        String mensaje = "Seleccione el tipo de usuario que desea registrar: \n";
        mensaje+= "1. Administrativo\n";
        mensaje+= "2. Profesor\n";
        mensaje+= "3. Estudiante\n";
        interfaz.imprimirMensaje(mensaje);
        int tipoUsuario = Integer.parseInt(interfaz.leerTexto());
        procesarOpcionUsuario(tipoUsuario, nombre, apellido);
    }

    private void procesarOpcionUsuario(int tipoUsuario, String nombre, String apellido) throws IOException{
        switch (tipoUsuario)
        {
            case 1:
                registrarAdministrativo(nombre, apellido);
                break;
            case 2:
                //registrarProfesor(nombre, apellido);
                break;
            case 3:
                registrarEstudiante(nombre, apellido);
                break;
            default:
                interfaz.imprimirMensaje("Opcion inválida");
                break;
        }
    }

    public void registrarAdministrativo(String nombre, String apellido) throws IOException {
        String identificacion;
        String tipoNombramiento;
        int cantHorasAsignadas;
        interfaz.imprimirMensaje("Digite la identificación");
        identificacion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el tipo de nombramiento");
        tipoNombramiento = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite la cantidad de horas asignadas a el nuevo administrativo");
        cantHorasAsignadas = Integer.parseInt(interfaz.leerTexto());
        controllerGestor.registrarAdministativo(nombre,apellido, identificacion, tipoNombramiento, cantHorasAsignadas);
    }

   /* public void registrarProfesor(String nombre, String apellido) throws IOException {
        String identificacion;
        String tipoContrato;
        LocalDate fechaContratacion;
        interfaz.imprimirMensaje("Digite la identificación");
        identificacion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el tipo de contrato");
        tipoContrato = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite la fecha de contratacion \n");
        interfaz.imprimirMensaje("Digite el año \n");
        int anio = Integer.parseInt(interfaz.leerTexto());
        interfaz.imprimirMensaje("Digite el mes \n");
        int mes = Integer.parseInt(interfaz.leerTexto());
        interfaz.imprimirMensaje("Digite el día \n");
        int dia =Integer.parseInt(interfaz.leerTexto());
        fechaContratacion = new LocalDate(anio, mes, dia);
        controllerGestor.registrarProfesor(nombre, apellido, identificacion, tipoContrato, fechaContratacion);
    }*/

    public void registrarEstudiante(String nombre, String apellido) throws IOException {
        int numCarnet;
        String carrera;
        int creditosMatriculados;
        interfaz.imprimirMensaje("Digite el número de carnet");
        numCarnet = Integer.parseInt(interfaz.leerTexto());
        interfaz.imprimirMensaje("Digite la carrera que cursa el estudiante");
        carrera = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite los créditos matriculados");
        creditosMatriculados = Integer.parseInt(interfaz.leerTexto());
        controllerGestor.registrarEstudiante(nombre, apellido, numCarnet, carrera, creditosMatriculados);
    }

    /*public void listarPersonas(){
        String[] lista = controllerGestor.listarPersonas();
        for(String dato: lista){
            interfaz.imprimirMensaje(dato);
        }
    }*/
}

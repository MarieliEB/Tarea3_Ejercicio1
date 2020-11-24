package cr.ac.ucenfotec.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class UI {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintStream out = System.out;


    public void mostrarMenu(){
        out.println("---- BIENVENIDO ---- !!");
        out.println("MENÚ PRINCIPAL");
        out.println("1.Registrar usuario");
        out.println("2.Listar usuarios");
        out.println("3.Registrar material");
        out.println("4.Listar materiales");
        out.println("5.Registrar préstamo");
        out.println("6.Realizar devolución de un préstamo");
        out.println("7.Salir");
    }

    public int leerOpcion() throws IOException {
        out.println("Digite la opción");
        return Integer.parseInt(in.readLine());
    }

    public void imprimirMensaje(String msj){
        out .println(msj);
    }

    public String leerTexto() throws IOException{
        return in.readLine();
    }
}


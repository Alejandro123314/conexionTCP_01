package conexiones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto = MiProtocolo.PUERTO;
		
		try {
			ServerSocket server = new ServerSocket(puerto);
			Socket socket = server.accept();
			System.out.println("Socket Abierto.");
			BufferedReader entrada = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			Writer salida = new OutputStreamWriter(
					socket.getOutputStream());
			
			System.out.println("Recibid: ");
			String linea = entrada.readLine();
			System.out.println(linea);
						
			double total = 0.0;
			while (linea != null) {
				Scanner sc = new Scanner(linea);
				total += sc.nextDouble();
			}
				
			
			String resultado = String.format("%.2f", total);
			System.out.println("Enviado: " + resultado);
			salida.write(resultado+"\n");
			salida.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

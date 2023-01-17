package conexiones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto = MiProtocolo.PUERTO;

		try {
			Socket socket = new Socket(servidor, puerto);
			System.out.println("Socket Abierto");
			BufferedReader entrada = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			Writer salida = new OutputStreamWriter(socket.getOutputStream());
			
			String linea = "3 5,5";
			System.out.println("Enviado: " + linea);
			salida.write(linea+"\n");
			salida.flush();
			
			linea = entrada.readLine();
			System.out.println("Recibido: ");
			System.out.println(linea);
			
			entrada.close();
			salida.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Coneactate para que funcione");
		}

	}

}

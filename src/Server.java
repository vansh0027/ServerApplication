import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(8000);

		while (true) {
			try {
				Socket socket = serverSocket.accept();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				Scanner scanner = new Scanner(System.in);
				while (true) {
					String message = bufferedReader.readLine();
					System.out.println(message);
					bufferedWriter.write("received");
					bufferedWriter.newLine();
					bufferedWriter.flush();
					if (message.equalsIgnoreCase("quit")) {
						break;
					}

				}
				socket.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

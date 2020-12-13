import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class EchoServer{
    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Сервер запущен, ожидаем подключение...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true){
                String str = in.readUTF();
                if(str.equals("end")){
                    break;
                }
                out.writeUTF("Эхо: " + str);
            }

        }catch (IOException e){

        }

    }
}

class EchoClient {
    public static void main(String[] args) {
        // Подключаемся к серверу
        try (Socket socket = new Socket("localhost", 8000)) {
            //Создаем обертки над потоками данных
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            //Читаем консоль и отправляем строки на сервер
            String line;
            Scanner scanner = new Scanner(System.in);
            do{
                line = scanner.nextLine();
                dataOutputStream.writeUTF(line);
                System.out.println(dataInputStream.readUTF());
            } while (!line.equals("stop"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
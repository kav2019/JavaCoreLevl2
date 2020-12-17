import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class EchoServer{
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            Socket socket = serverSocket.accept();
            new Worker(socket, "Клиент");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8081);
            new Worker(socket, "Сервер");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class Worker{

    public Worker(Socket socket, String name){
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Thread threadMess = new Thread(() -> {
                while (true){
                    try {
                        String str = in.readUTF();
                        if(str.equals("/stop")){
                            break;
                        }
                        System.out.println(name + ": " + str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread threadAnswer = new Thread(() -> {
                while (true){
                    try {
                        String answer = scanner.nextLine();
                        out.writeUTF( answer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadAnswer.start();
            threadMess.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCPServer {//读 && 写 到客户端

    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket socket =ss.accept();

            in = socket.getInputStream();
            out = socket.getOutputStream();
            DataInputStream dis = new DataInputStream(in);
            DataOutputStream dos = new DataOutputStream(out);

            String s = null;
            if( (s = dis.readUTF() )!= null){ //读dis
                System.out.println(s);
                System.out.println("From: " + socket.getInetAddress());
                System.out.println("Port: " + socket.getPort());
            }

            dos.writeUTF("Hello!");//写dos
            dos.close();
            socket.close();

        }catch (ConnectException e){
            e.printStackTrace();
            System.out.println("服务器连接失败！");
        }catch (IOException e1){
            e1.printStackTrace();
        }


    }
}
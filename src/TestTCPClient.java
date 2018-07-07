import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class TestTCPClient {

    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        try {
            Socket socket = new Socket("127.0.0.1",6666);

            in = socket.getInputStream();
            out = socket.getOutputStream();
            DataInputStream dis = new DataInputStream(in);
            DataOutputStream dos = new DataOutputStream(out);

            dos.writeUTF("Hey!");//写dos
            String s = null;
            if( (s=dis.readUTF()) != null){
                ;
            }
            System.out.println(s);


            dos.close();
            dis.close();
            socket.close();
        }catch (ConnectException e){
            e.printStackTrace();
            System.err.println("服务器连接失败！");
        }catch (IOException e1){
            e1.printStackTrace();
        }

    }


}
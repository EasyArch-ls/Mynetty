package zerocopy;

import io.netty.channel.ServerChannel;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-15
 */
public class Server {
    public static void main(String[] args)throws Exception {
        ServerSocketChannel serverChannel=ServerSocketChannel.open();
        InetSocketAddress socketAddress=new InetSocketAddress(8999);
        ServerSocket serverSocket=serverChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(socketAddress);
        ByteBuffer byteBuffer=ByteBuffer.allocate(4096);
        while (true){
            SocketChannel socketChannel=serverChannel.accept();
            socketChannel.configureBlocking(true);
            int readline=0;
            while (-1!=readline){
                readline = socketChannel.read(byteBuffer);
                System.out.println(readline);
                byteBuffer.rewind();
            }
        }

    }
}

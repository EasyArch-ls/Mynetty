package zhanbao.jiejue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-17
 */
public class MyzhanCientHandle extends SimpleChannelInboundHandler<Person> {
    private int count=1;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Person person) throws Exception {
        int length=person.getLength();
        byte[] bytes=person.getBytes();
        String message=new String(bytes, Charset.forName("utf-8"));
        System.out.println("客户端收到： "+message);
        System.out.println("客户端收到的长度： "+length);
        System.out.println("客户端收到的消息条数  "+this.count++);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String message="send from client";
            Person person=new Person();
            person.setLength(message.getBytes("utf-8").length);
            person.setBytes(message.getBytes("utf-8"));
            ctx.channel().writeAndFlush(person);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
        ctx.close();
    }
}

package zhanbao.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-17
 */
public class MyZhanHandle extends SimpleChannelInboundHandler<ByteBuf> {
    private int count=1;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
        byte[] bytes=new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        String message=new String(bytes, Charset.forName("utf-8"));
        System.out.println("服务端收到： "+message);
        System.out.println("服务端收到的消息条数  "+this.count++);
        ByteBuf buf= Unpooled.copiedBuffer(UUID.randomUUID().toString(),Charset.forName("UTF-8"));
        ctx.channel().writeAndFlush(buf);

    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
        ctx.close();
    }


}

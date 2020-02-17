package zhanbao.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-17
 */
public class MyzhanCientHandle extends SimpleChannelInboundHandler<ByteBuf> {
    private int count=1;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        byte[] bytes=new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        String message=new String(bytes, Charset.forName("utf-8"));
        System.out.println("客户端收到： "+message);
        System.out.println("客户端收到的消息条数"+this.count++);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ByteBuf buf= Unpooled.copiedBuffer("send from client", Charset.forName("utf-8"));
            ctx.writeAndFlush(buf);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
        ctx.close();
    }
}

package xintiao;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-14
 */
public class MyserverInityializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline=socketChannel.pipeline();
        channelPipeline.addLast(new IdleStateHandler(7,5,10, TimeUnit.SECONDS));
        channelPipeline.addLast(new MyservreHandler());
    }
}

package xintiao;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-14
 */
public class MyservreHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
         if (evt instanceof IdleStateEvent){
             IdleStateEvent idleStateEvent= (IdleStateEvent) evt;
             String eventType=null;
             switch (idleStateEvent.state()){
                 case ALL_IDLE:
                     eventType="读写空闲";
                     break;
                 case WRITER_IDLE:
                     eventType="写空闲";
                     break;
                 case READER_IDLE:
                     eventType="读空闲";
                     break;
             }
             System.out.println(ctx.channel().remoteAddress()+"超时事件：  "+eventType);
             ctx.channel().writeAndFlush("超时事件：  "+eventType);
             ctx.channel().close();
         }
    }

}

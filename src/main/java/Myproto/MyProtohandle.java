package Myproto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Demo class
 *
 * @author ls
 * @date 20-2-15
 */
public class MyProtohandle extends SimpleChannelInboundHandler<Mypersion.Mymessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Mypersion.Mymessage msg) throws Exception {
        if (msg.getDataType()== Mypersion.Mymessage.DataType.PersonType){
            Mypersion.Person person=msg.getPerson();
            System.out.println(person.getEmail());
            System.out.println(person.getId());
            System.out.println(person.getName());
        }else {
            Mypersion.Student student=msg.getStudent();
            System.out.println(student.getGrade());
            System.out.println(student.getId());
            System.out.println(student.getName());
        }

    }

}

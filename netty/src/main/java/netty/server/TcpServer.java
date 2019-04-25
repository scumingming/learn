package netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import netty.handler.TcpServerHandler;


/**
 * Created by wangmingming on 2019/4/24.
 */
public class TcpServer {
    private static final int PORT = 7777;

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            /**
             * 服务端可以使用handler和childHandler
             *  .handler针对boss group起作用
             *  .childerHanlder针对worker group起作用
             * 客户端只能使用handler
             */
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
//                    .childOption(ChannelOption.TCP_NODELAY, Boolean.TRUE)
//                    .childOption(ChannelOption.SO_REUSEADDR, Boolean.TRUE)
//                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline
//                                    .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0 , 4))
//                                    .addLast(new LengthFieldPrepender(4))
                                    .addLast(new StringDecoder(CharsetUtil.UTF_8))  //解码
                                    .addLast(new StringEncoder(CharsetUtil.UTF_8)) //编码
                                    .addLast(new TcpServerHandler()); //

                        }
                    });

            ChannelFuture future = serverBootstrap.bind(PORT).sync();
            future.channel().closeFuture().sync();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}

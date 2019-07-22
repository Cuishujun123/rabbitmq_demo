package demo;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author CuiShujun
 * @Date 2019/5/30
 */

public class producer {

    private final static String EXCHANGE_NAME = "durable";
    private final static String QUEUE_NAME = "nice";

    public static void main(String[] args) {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        // 绑定主机、用户名
        factory.setHost("127.0.0.1");
        factory.setUsername("developer");
        factory.setPassword("123456");
        try {
            // 获取连接
            Connection connection = factory.newConnection();
            // 创建通道
            Channel channel = connection.createChannel();
            // 设置 exchange 持久化
            channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
            // b:true 开启队列持久化
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            // 发送消息
            String message = "nice to meet you!";
            // 消息持久化
            AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().deliveryMode(2).build();
            channel.basicPublish("", QUEUE_NAME, basicProperties, message.getBytes());

            // 关闭管道和连接
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}

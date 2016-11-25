package service.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import service.demo.Column;

public class HelloServiceClient {
    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("localhost", 6666);
            transport.open();
            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            // 调用服务的 helloVoid 方法
            client.helloVoid();
            int clientInt = client.helloInt(2);
            Column column = client.getColumn();
            System.out.println(column);
            client.helloString("hello world");
            System.out.println(clientInt);

            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
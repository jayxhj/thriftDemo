package service.demo;

import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

public class HelloServiceImpl implements Hello.Iface {
    @Override
    public Column getColumn() throws TException {
        System.out.println(getCurrentMethodName());
        Column column = new Column();
        column.setTimestamp(100000L);
        column.setTtl(100);
        column.setName("name");
        column.setValue("xuhaojie");
        System.out.println(column);
        return column;
    }

    @Override
    public String helloString(String para) throws TException {
        System.out.println(getCurrentMethodName());
        return para;
    }

    @Override
    public int helloInt(int para) throws TException {
        System.out.println(getCurrentMethodName());
        return para;
    }

    @Override
    public boolean helloBoolean(boolean para) throws TException {
        System.out.println(getCurrentMethodName());
        return false;
    }

    @Override
    public void helloVoid() throws TException {
        System.out.println(getCurrentMethodName());
    }

    @Override
    public String helloNull() throws TException {
        System.out.println(getCurrentMethodName());
        return null;
    }

    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}

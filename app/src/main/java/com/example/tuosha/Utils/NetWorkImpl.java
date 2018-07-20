package com.example.tuosha.Utils;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by admin on 2014/7/9.
 */
public class NetWorkImpl {

    public byte[] getByteData(Object o) throws Exception {
        if (o == null){
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(o);
        byte[] ndata = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return ndata;
    }

    public Object getObj(byte[] data) throws Exception{
        if (data == null){
            return null;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = objectInputStream.readObject();
        objectInputStream.close();
        return o;
    }
}

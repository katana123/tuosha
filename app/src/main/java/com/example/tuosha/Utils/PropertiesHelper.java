package com.example.tuosha.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by admin on 2014/7/8.
 */
public class PropertiesHelper {
    private Properties properties;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private String propertiesFile;

    public PropertiesHelper(String propertiesFile) throws Exception {
        properties = null;
        fileInputStream = null;
        fileOutputStream = null;

        this.propertiesFile = propertiesFile;
        File file = new File(propertiesFile);
        if (!file.exists()) {
            throw new Exception(".config file not exists!");
        }

        fileInputStream = new FileInputStream(propertiesFile);
        properties = new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
        fileInputStream = null;
    }

    public String getValue(String key, String defaultValue) throws Exception {
			/* ����Ҫ�ر�ע�⣬��Ϊ properties ����Ĭ�ϲ��� ISO-8859-1 �����ȡ�����ļ������Ա������ת��
			 * ���������ļ��к������ľͱ�Ȼ�����롣���ﲻ��Ҫ�Զ�ȡֵ���б���ת������Ҫע��� key ��ֵҲҪ��
			 * �б���ת�������� properties ���޷��ҵ���Ӧ key �ģ�
			 */
        if (key == null) return null;

        String encodedKey = new String(key.getBytes(System.getProperty("file.encoding")), "ISO-8859-1");
        String encodedDefaultValue = "unknown";

        if (defaultValue != null) {
            encodedDefaultValue = new String(defaultValue.getBytes(System.getProperty("file.encoding")), "ISO-8859-1");
        }

        return new String(properties.getProperty(encodedKey, encodedDefaultValue).getBytes("ISO-8859-1"), System.getProperty("file.encoding"));
    }

    // ֱ�ӷ����ַ�����ֵ�����͹�ϣ��
    public HashMap<String, String> getHashMap() throws Exception {
        if (properties == null) return null;

            /* ��Ϊ properties ʵ���� Map<Object, Object> �ӿڣ�������ֱ��
             * return new HashMap<Object, Object>(properties); ���ַ�ʽ��
             * HashMap ���캯�����Խ��� Map��������ΪҪ���ص����ַ�����ֵ��
             * ���͹�ϣ�����Ի��ǽ����˱������ַ�����ֵ������ת������������
             * �� entrySet ��ʽ��һ����ת�����ٶ���죡�� keySet Ҫǿ̫���ˣ�
             */

			/* ����Ҫ�ر�ע�⣬ת��Ϊ HashMap ʱҪע���ַ����������⣬��Ϊ properties
			 * ������ ISO-8859-1 ��������ģ�����Ҫע��������⣡����Ҫ�� key �� value
			 * �����б���ת�����У�
			 */
        HashMap<String, String> hashMap = new HashMap<String, String>();

        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            String encodedKey = null;
            String encodedValue = null;
            if (key != null) encodedKey = new String(key.getBytes("ISO-8859-1"), System.getProperty("file.encoding"));
            if (value != null)
                encodedValue = new String(value.getBytes("ISO-8859-1"), System.getProperty("file.encoding"));
            hashMap.put(encodedKey, encodedValue);
        }

        return hashMap;
    }

    public void setValue(String key, String newValue) throws Exception {
        if (newValue != null)
            properties.setProperty(key, newValue);
        else
            properties.setProperty(key, "unknown");
    }

    public void update() throws Exception {
        fileOutputStream = new FileOutputStream(propertiesFile);
        properties.store(fileOutputStream, "modified by the program");
        fileOutputStream.close();
    }
}

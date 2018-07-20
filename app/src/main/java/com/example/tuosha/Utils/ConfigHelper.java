package com.example.tuosha.Utils;

/**
 * Created by admin on 2014/10/24.
 */
public class ConfigHelper {
    private PropertiesHelper propertiesHelper;
    private String TCPServerAddress;
    private int TCPServerPort;
    private String connection_url;
    private String connection_driver_class;
    private String connection_username;
    private String connection_password;
    private String DX_HOST;
    private String fileAddress;
    private String fileAddressyb;
    private String htmlpath;
    private String htmlpath2;
    private String addressRoot1;
    private String addressRoot2;

    public ConfigHelper(PropertiesHelper propertiesHelper) {
        this.propertiesHelper = propertiesHelper;
    }

    public ConfigHelper(String propertiesFileName) throws Exception {
        propertiesHelper = new PropertiesHelper(propertiesFileName);
    }

    public void getConfig() throws Exception {
        if (propertiesHelper != null) {
            TCPServerAddress = propertiesHelper.getValue("TCPServerAddress", "0.0.0.0");
            TCPServerPort = Integer.parseInt(propertiesHelper.getValue("TCPServerPort", "9888"));
            connection_url = propertiesHelper.getValue("connection_url", "jdbc:mysql://10.9.7.88:3306/INFOCLT?useUnicode=true&amp;characterEncoding=UTF-8&amp;autoReconnect=true&&zeroDateTimeBehavior=convertToNull");
            connection_driver_class = propertiesHelper.getValue("connection_driver_class", "com.mysql.jdbc.Driver");
            connection_username = propertiesHelper.getValue("connection_username", "root");
            connection_password = propertiesHelper.getValue("connection_password", "wlzx1158");
            DX_HOST = propertiesHelper.getValue("DX_HOST", "119.36.93.174:8088");
            fileAddress = propertiesHelper.getValue("fileAddress", "D:\\\\DW\\\\GWGL\\\\DB\\\\");
            fileAddressyb = propertiesHelper.getValue("fileAddressyb", "D:\\\\DW\\\\GWGL\\\\YB\\\\");
            htmlpath = propertiesHelper.getValue("htmlpath", "D:\\\\tools\\\\apache-tomcat-6.0.36-windows-x86\\\\apache-tomcat-6.0.36\\\\webapps\\\\FolderS\\\\");
            htmlpath2 = propertiesHelper.getValue("htmlpath2", "D:\\\\tools\\\\apache-tomcat-6.0.36-windows-x86\\\\apache-tomcat-6.0.36\\\\webapps\\\\OfficialDocument\\\\");
            addressRoot1 = propertiesHelper.getValue("addressRoot1", "D:\\\\tools\\\\apache-tomcat-6.0.36-windows-x86\\\\apache-tomcat-6.0.36\\\\webapps\\\\FolderS\\\\");
            addressRoot2 = propertiesHelper.getValue("addressRoot2", "D:\\\\tools\\\\apache-tomcat-6.0.36-windows-x86\\\\apache-tomcat-6.0.36\\\\webapps\\\\OfficialDocument\\\\");
        } else {
            TCPServerAddress = "0.0.0.0";
            TCPServerPort = Integer.parseInt("9200");
            connection_url = "jdbc:mysql://10.9.7.88:3306/INFOCLT?useUnicode=true&amp;characterEncoding=UTF-8&amp;autoReconnect=true&&zeroDateTimeBehavior=convertToNull";
            connection_driver_class = "com.mysql.jdbc.Driver";
            connection_username = "root";
            connection_password = "wlzx1158";
            DX_HOST = "119.36.93.174:8088";
            fileAddress = "D:\\\\DW\\\\GWGL\\\\DB\\\\";
            fileAddressyb = "D:\\\\DW\\\\GWGL\\\\YB\\\\";
            htmlpath = "D:\\\\tools\\\\apache-tomcat-6.0.36-windows-x86\\\\apache-tomcat-6.0.36\\\\webapps\\\\FolderS\\\\";
            htmlpath2 = "D:\\\\tools\\\\apache-tomcat-6.0.36-windows-x86\\\\apache-tomcat-6.0.36\\\\webapps\\\\OfficialDocument\\\\";
            addressRoot1 = "D:\\\\tools\\\\apache-tomcat-6.0.36-windows-x86\\\\apache-tomcat-6.0.36\\\\webapps\\\\FolderS\\\\";
            addressRoot2 = "D:\\\\tools\\\\apache-tomcat-6.0.36-windows-x86\\\\apache-tomcat-6.0.36\\\\webapps\\\\OfficialDocument\\\\";
        }
    }

    public void updateConfig() throws Exception {
        if (propertiesHelper != null) {
            propertiesHelper.setValue("TCPServerAddress", TCPServerAddress);
            propertiesHelper.setValue("TCPServerPort", Integer.toString(TCPServerPort));
            propertiesHelper.setValue("connection_url", connection_url);
            propertiesHelper.setValue("connection_driver_class", connection_driver_class);
            propertiesHelper.setValue("connection_username", connection_username);
            propertiesHelper.setValue("connection_password", connection_password);
            propertiesHelper.setValue("DX_HOST", DX_HOST);
            propertiesHelper.setValue("fileAddress", fileAddress);
            propertiesHelper.setValue("fileAddressyb", fileAddressyb);
            propertiesHelper.setValue("htmlpath", htmlpath);
            propertiesHelper.setValue("htmlpath2", htmlpath2);
            propertiesHelper.setValue("addressRoot1", addressRoot1);
            propertiesHelper.setValue("addressRoot2", addressRoot2);
            propertiesHelper.update();
        }
    }

    public PropertiesHelper getPropertiesHelper() {
        return propertiesHelper;
    }

    public void setPropertiesHelper(PropertiesHelper propertiesHelper) {
        this.propertiesHelper = propertiesHelper;
    }

    public String getTCPServerAddress() {
        return TCPServerAddress;
    }

    public void setTCPServerAddress(String TCPServerAddress) {
        this.TCPServerAddress = TCPServerAddress;
    }

    public int getTCPServerPort() {
        return TCPServerPort;
    }

    public void setTCPServerPort(int TCPServerPort) {
        this.TCPServerPort = TCPServerPort;
    }

    public String getConnection_url() {
        return connection_url;
    }

    public void setConnection_url(String connection_url) {
        this.connection_url = connection_url;
    }

    public String getConnection_driver_class() {
        return connection_driver_class;
    }

    public void setConnection_driver_class(String connection_driver_class) {
        this.connection_driver_class = connection_driver_class;
    }

    public String getConnection_username() {
        return connection_username;
    }

    public void setConnection_username(String connection_username) {
        this.connection_username = connection_username;
    }

    public String getConnection_password() {
        return connection_password;
    }

    public void setConnection_password(String connection_password) {
        this.connection_password = connection_password;
    }

    public String getDX_HOST() {
        return DX_HOST;
    }

    public void setDX_HOST(String DX_HOST) {
        this.DX_HOST = DX_HOST;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getFileAddressyb() {
        return fileAddressyb;
    }

    public void setFileAddressyb(String fileAddressyb) {
        this.fileAddressyb = fileAddressyb;
    }

    public String getHtmlpath() {
        return htmlpath;
    }

    public void setHtmlpath(String htmlpath) {
        this.htmlpath = htmlpath;
    }

    public String getHtmlpath2() {
        return htmlpath2;
    }

    public void setHtmlpath2(String htmlpath2) {
        this.htmlpath2 = htmlpath2;
    }

    public String getAddressRoot1() {
        return addressRoot1;
    }

    public void setAddressRoot1(String addressRoot1) {
        this.addressRoot1 = addressRoot1;
    }

    public String getAddressRoot2() {
        return addressRoot2;
    }

    public void setAddressRoot2(String addressRoot2) {
        this.addressRoot2 = addressRoot2;
    }
}
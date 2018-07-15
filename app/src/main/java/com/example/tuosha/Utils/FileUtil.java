package com.example.tuosha.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/6/10.
 */
public class FileUtil {
    public static void writeAdvice(String msg,String cuid){
        final String path = System.getProperty("user.dir");
        File file = new File(String.format("%s%s%s",path,File.separator,"advice.txt"));
        if(!file.exists()){
            try {
                boolean b =file.createNewFile();
                if(!b){
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter fw = null;
        try{
            fw = new FileWriter(file,true);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            String date = df.format(new Date());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cuid);
            stringBuilder.append("\r\n");
            stringBuilder.append(date);
            stringBuilder.append("\r\n");
            stringBuilder.append(msg);
            stringBuilder.append("\r\n");
            stringBuilder.append("\r\n");
            fw.write(stringBuilder.toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fw!=null){
                try {
                    fw.flush();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

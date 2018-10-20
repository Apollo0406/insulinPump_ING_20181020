package service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
    private static String file_name = "D://log";
    private static Logger logger;

    private  LoggerUtil(){
    }

    public static Logger getLogger(){
        if(logger == null){
            logger = Logger.getLogger("a");
            setLoggingProoerties(logger,Level.ALL);
        }
        return logger;
    }

    //得到日志的路径以及日志的名称
    private static String getLogName(){
        StringBuffer logPath = new StringBuffer();
        logPath.append(file_name);
        File file = new File(logPath.toString());
        if(!file.exists()){
            file.mkdir();
        }
        logPath.append("\\"+(new SimpleDateFormat("yyyy-MM-dd")).format((new Date()))+".log");
        return logPath.toString();
    }

    //配置Logger对象输出日志文件路径
    private static void setLoggingProoerties(Logger logger,Level level){
        FileHandler fh;
        try{
            fh = new FileHandler(getLogName(),true);
            logger.addHandler(fh);
            logger.setLevel(level);
            fh.setFormatter(new SimpleFormatter());
        }catch(SecurityException se){
            logger.log(Level.SEVERE,"安全性错误",se);
        }catch (IOException ioe){
            logger.log(Level.SEVERE,"读取日志文件错误",ioe);
        }
    }
}

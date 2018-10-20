package controller;

import service.LoggerUtil;
import service.bloodSugarInit;
import service.compare;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;

//level_3 :加入日志功能
public class insulinPumpController {
    public static void main(String[] args) throws InterruptedException{
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                    LoggerUtil.getLogger().log(Level.INFO,"check over");
                    bloodSugarInit bsi = new bloodSugarInit();
                    bsi.setBloodSugar();
                    long l = bsi.getBloodSugar();
                    System.out.println("bloodSugar:"+l);
                    if(compare.compare(l) == 1)
                        pumpController.inject(l);
                    else if(compare.compare(l) == -1)
                        System.out.println("血糖过低");
                    else
                        System.out.println("正常");

                    System.out.println("-------------------");
                }

                };
        timer.schedule(timerTask,1000,5000); //1s=1000ms  1min=60s=60000ms
        while(true){
            Thread.sleep(300);
        }
    }
}

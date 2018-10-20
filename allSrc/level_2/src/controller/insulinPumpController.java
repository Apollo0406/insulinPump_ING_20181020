package controller;

import service.bloodSugarInit;
import service.compare;

import java.util.Timer;
import java.util.TimerTask;

//level_2 :加入定时任务
public class insulinPumpController {
    public static void main(String[] args) throws InterruptedException{
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                    System.out.println("-------------------");
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
                }
                };
        timer.schedule(timerTask,1000,5000); //1s=1000ms  1min=60s=60000ms
        while(true){
            Thread.sleep(300);
        }
    }
}

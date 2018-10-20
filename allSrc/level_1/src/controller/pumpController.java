package controller;

import service.insulinPump;

public class pumpController {
    static insulinPump ip = new insulinPump();
    static long insulinPump;
    public static void inject(long l){
        long needInject;
        needInject = l - 140;
        System.out.println("needInject:"+needInject);
        insulinPump= ip.getInsulin() - needInject;
        System.out.println("insulinNow:"+insulinPump);
    }
}

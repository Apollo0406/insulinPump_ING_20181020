package controller;

import service.bloodSugarInit;
import service.compare;

public class insulinPumpController {
    public static void main(String[] args) {
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
}

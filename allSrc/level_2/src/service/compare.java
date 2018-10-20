package service;

public class compare {
    public static int compare(long bloodSugar){
        if(bloodSugar<70)
            return -1;
        else if(bloodSugar>140)
            return 1;
        else
            return 0;
    }
}

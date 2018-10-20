package service;

public class bloodSugarInit {
    long bloodSugar;


    public bloodSugarInit(long bloodSuagr) {
        this.bloodSugar = bloodSuagr;
    }

    public bloodSugarInit() {
    }

    public long getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar() {
        bloodSugar = (long)(Math.round(Math.random()*180+20));
    }
}

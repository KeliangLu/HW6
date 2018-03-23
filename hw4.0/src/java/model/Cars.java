
package model;

public class Cars {
    private int CARID;
    private String CARNAME;
    private int CARYEAR;
    private String CARMODEL;
    private String CARCOLOR;

    public Cars() {
        this.CARID = 0;
        this.CARNAME = "";
        this.CARYEAR = 0;
        this.CARMODEL = "";
        this.CARCOLOR = "";
    }
    
    
    public Cars(int CARID, String CARNAME, int CARYEAR, String CARMODEL, String CARCOLOR) {
        this.CARID = CARID;
        this.CARNAME = CARNAME;
        this.CARYEAR = CARYEAR;
        this.CARMODEL = CARMODEL;
        this.CARCOLOR = CARCOLOR;
    }
    
    public int getCARID() {
        return CARID;
    }

    public void setCARID(int CARID) {
        this.CARID = CARID;
    }

    public String getCARNAME() {
        return CARNAME;
    }

    public void setCARNAME(String CARNAME) {
        this.CARNAME = CARNAME;
    }

    public int getCARYEAR() {
        return CARYEAR;
    }

    public void setCARYEAR(int CARYEAR) {
        this.CARYEAR = CARYEAR;
    }

    public String getCARMODEL() {
        return CARMODEL;
    }

    public void setCARMODEL(String CARMODEL) {
        this.CARMODEL = CARMODEL;
    }

    public String getCARCOLOR() {
        return CARCOLOR;
    }

    public void setCARCOLOR(String CARCOLOR) {
        this.CARCOLOR = CARCOLOR;
    }

    @Override
    public String toString() {
        return "Cars{" + "CARID=" + CARID + ", CARNAME=" + CARNAME + ", CARYEAR=" + CARYEAR + ", CARMODEL=" + CARMODEL + ", CARCOLOR=" + CARCOLOR + "}";
    }
        


}

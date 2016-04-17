package lyn.librpump.kernel.heatExchanger;

import lyn.librpump.kernel.formular.Formular;

/**
 * Created by lyn on 16/4/11.
 */
public class HeatExchanger {

    Formular formular = new Formular();

    double XL,XH;
    double deltaT_h = 17;
    double T7o,P7o,H7o,X7o;
    double T8o,P8o,H8o,X8o;

    public HeatExchanger(double T2o, double X2o, double X4o, double H4o, double H2o, double deltaT_h){

        setDeltaT_h(deltaT_h);

        this.XL = X2o;
        this.XH = X4o;

        this.X7o = XL;
        this.X8o = XH;

        this.T8o = calT8o(T2o);

        this.H8o = calH8o(T8o, X8o);

        this.H7o = calH7o(H4o, H2o);

        this.T7o = calT7o(H7o, X7o);

    }


    public double calT8o(double t){
        return (t + this.deltaT_h);
    }

    public double calH8o(double t, double x){
        return formular.enthalpyLiBrSolution(t, x);
    }

    public double calH7o(double h4, double h2){
        return (h4-this.H8o) * (this.XL / this.XH) + h2;
    }

    public double calT7o(double H7o, double X7o){
        return formular.temperaturLiBrSolution(H7o, X7o);
    }

    void setDeltaT_h(double h){
        this.deltaT_h = h;
    }

    public double getH7o(){
        return this.H7o;
    }

    public double getH8o(){
        return this.H8o;
    }

    public void printHeatExchanger(){
        System.out.println("\t溶液热交换器状态参数如下所示:\n");

        System.out.println("\t  假定:" );
        System.out.println("\t    ∆T_h = "+deltaT_h+"˚C");

        System.out.println("\t  求得:" );
        System.out.println("\t    T7o = " +T7o+"˚C" );
        System.out.println("\t    P7o = " +"--" );
        System.out.println("\t    H7o = " +H7o+"kJ/kg" );
        System.out.println("\t    X7o = " +X7o+"%" );

        System.out.println("\t    T8o = " +T8o+"˚C" );
        System.out.println("\t    P8o = " +"--" );
        System.out.println("\t    H8o = " +H8o+"kJ/kg" );
        System.out.println("\t    X8o = " +X8o+"%" );

    }

    public double getT7o() {
        return T7o;
    }

    public double getP7o() {
        return P7o;
    }

    public double getX7o() {
        return X7o;
    }

    public double getT8o() {
        return T8o;
    }

    public double getP8o() {
        return P8o;
    }

    public double getX8o() {
        return X8o;
    }
}

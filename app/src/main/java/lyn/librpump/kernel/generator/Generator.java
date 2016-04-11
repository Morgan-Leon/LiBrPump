package lyn.librpump.kernel.generator;

import lyn.librpump.kernel.formular.Formular;

/**
 * Created by lyn on 16/4/11.
 */
public class Generator {

    Formular formular;

    double T4wo,P4wo,H4wo,X4wo;
    double T4o,P4o,H4o,X4o;
    double T5i,P5i,H5i,X5i;

    public Generator(){
        this.T4o = calT4o(75, 62.6386);
    }

//发生器中的三个点的压力均相同 且都由冷凝器的压力决定（认为两者压力差极小，可忽略）
    public Generator(double T3o, double P3o, double X2o, double X6i){

        //T4wo为过热水蒸气温度，等于溴化锂水溶液露点温度
        //其浓度按照出口稀溶液浓度和入口浓溶液浓度的平均值计算
        this.T4wo = calT4wo(T3o, (X6i + X2o)/2);

        this.P4wo = P3o;
        this.H4wo = calH4wo(T3o, T4wo);
        this.X4wo = 0;

        this.P4o = P3o;
        this.T4o = calT4o(T3o, X6i);
        this.X4o = X6i;
        this.H4o = calH4o(T4o, X4o);

        this.P5i = P3o;
        this.T5i = calT5i(T3o,X2o);
        this.X5i = X2o;
        this.H5i = calH5i(T5i, X5i);

    }

    public double calH4wo(double saturationTemperatureH2O_C,double saturationTemperatureLiBr_C){
        return formular._H2OHeat_enthalpy(saturationTemperatureH2O_C, saturationTemperatureLiBr_C);
    }

    public double calT4wo(double t, double x){
        return formular.dewTLiBr(t, x);
    }

    public double calT4o(double t, double x){
        return formular.dewTLiBr(t, x);
    }

    public double calT5i(double t, double x){
        return formular.dewTLiBr(t, x);
    }

    public double calH4o(double t, double x){
        return formular.enthalpyLiBrSolution(t, x);
    }

    public double calH5i(double t, double x){
        return formular.enthalpyLiBrSolution(t, x);
    }

    public double getX4o(){
        return this.X4o;
    }

    public double getH4o(){
        return this.H4o;
    }

    public double getH4wo(){
        return this.H4wo;
    }

    public void printGenerator(){
        System.out.println("\t发生器状态参数如下所示:" );

//    cout + "\t    Twei = "+Twei+"˚C");
//    cout + "\t    Tweo = "+Tweo+"˚C");
//
//    cout + "\t  假定:" );
//    cout + "\t    ∆Te  = " +deltaT_e+"˚C");

        System.out.println("\t  求得:" );
        System.out.println("\t    T4wo  = " +T4wo +"˚C");
        System.out.println("\t    P4wo  = " +P4wo +"kPa");
        System.out.println("\t    H4wo  = " +H4wo +"kJ/kg");
        System.out.println("\t    X4wo  = " +X4wo +"%");
        System.out.println("\t    T4o  = " +T4o +"˚C");
        System.out.println("\t    P4o  = " +P4o +"kPa");
        System.out.println("\t    H4o  = " +H4o +"kJ/kg");
        System.out.println("\t    X4o  = " +X4o +"%");
        System.out.println("\t    T5i  = " +T5i +"˚C");
        System.out.println("\t    P5i  = " +P5i +"kPa");
        System.out.println("\t    H5i  = " +H5i +"kJ/kg");
        System.out.println("\t    X5i  = " +X5i +"%");
    }
}

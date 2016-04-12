package lyn.librpump.kernel.condenser;

import lyn.librpump.kernel.formular.Formular;

/**
 * Created by lyn on 16/4/11.
 */


/*
 溴化锂吸收式热泵的冷凝器（Condenser）。
 冷凝器:
 已知量为二次水的出口温度Twco = 70˚C,以及∆T = 5
 所求
 状态点    物质       位置          温度/˚C      压力/kPa       焓/(kJ/kg)   质量分数（LiBr）%
 3        水        冷凝器出口      T3o         P3o           H3o          X3o
 */

public class Condenser {

    Formular formular = new Formular();

    //冷凝器出口水温要略高于二次水出口，其大小由冷凝管决定（3-5˚C）
    double deltaT_c = 5;

    double Twco = 70;

    double T3o,P3o,H3o,X3o;

    public Condenser(){
        this.T3o = Twco + deltaT_c;
    }

    public Condenser(double Twco, double deltaT_c){
        this.deltaT_c = deltaT_c;
        this.T3o = Twco + deltaT_c;
        this.P3o = calP3o(T3o);
        this.X3o = 0;
        this.H3o = calH3o(T3o);

    }

    //三步法计算水的饱和蒸汽压力
    public double calP3o(double t){
        double lgP3o = formular.lgsvp(formular.conversionT_C2K(t));
        return formular.conversion_P_lgmmHg2kPa(lgP3o);
    }

    public double calH3o(double t){
        return formular._H2O_enthalpy(t);
    }

    public double setDeltaT_C(double deltaT_C){
        return deltaT_C;
    }

    public double setTwco(double Twco){
        return Twco;
    }

    public double getP3o(){
        return this.P3o;
    }

    public double getT3o(){
        return this.T3o;
    }

    public double getH3o(){
        return this.H3o;
    }


    public void printCondenser(){

        System.out.println("\t冷凝器状态参数如下所示:");

        System.out.println("\t  已知:" );
        System.out.println("\t    Twco = "+Twco+"˚C");

        System.out.println("\t  假定:" );
        System.out.println("\t    ∆Tc  = " +deltaT_c+"˚C");

        System.out.println("\t  求得:" );
        System.out.println("\t    T3o  = " +T3o +"˚C");
        System.out.println("\t    P3o  = " +P3o +"kPa");
        System.out.println("\t    H3o  = " +H3o +"kJ/kg");
        System.out.println("\t    X3o  = " +X3o +"%");

    }
}

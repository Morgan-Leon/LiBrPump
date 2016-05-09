package lyn.librpump.kernel.evaporator;

import static lyn.librpump.kernel.formular.Formular.*;

/**
 * Created by lyn on 16/4/11.
 */

/*
 溴化锂吸收式热泵的蒸发器（Evaporator）。
 蒸发器:

 所求
 状态点    物质       位置          温度/˚C      压力/kPa       焓/(kJ/kg)   质量分数（LiBr）%
 1        水        蒸发器入口      T1i         P1i           H1i         X1i
 1`       水蒸气     蒸发器出口      T1o         P1o           H1o         X1o

 ∆: /'delta/

 */
public class Evaporator {



    double Twei;
    double Tweo;
    double deltaT_e;

    double T1i,T1o;
    double P1i,P1o;
    double H1i,H1o;
    double X1i,X1o;

    public Evaporator(){
        T1i = calT1i();
        P1i = calP1i(T1i);

    }

    public Evaporator(double Twei,double Tweo,double deltaT_e){
        this.Twei = Twei;
        this.Tweo = Tweo;
        this.deltaT_e = deltaT_e;
        T1i = calT1i();
        P1i = calP1i(T1i);
        P1o = P1i;
        //此处令蒸发器入口温度等于蒸发器出口温度
        //假设水的焓值升高只来自于水物态变化即蒸发吸热
        T1o = T1i;
        H1i = calH1i(T1i);
        H1o = calH1o(T1o);

        //此处为水
        X1i = 0;
        //此处为水蒸气
        X1o = 0;
    }

    public double calT1i(){
        return Tweo - deltaT_e;
    }

    /*
     三步计算水的饱和蒸汽压力：
        1、将设施温度换算为开氏温度；
        2、计算lgp;(mmHg);
        3、将mmHg换算为kPa;
     */
    public double calP1i(double T1i_C){
        double T1i_K = conversionT_C2K(T1i_C);
        double lgP1i = lgsvp(T1i_K);
        return conversion_P_lgmmHg2kPa(lgP1i);

    }

    /*
     计算水的焓值
     */
    public double calH1i(double T1i_C){
        return _H2O_enthalpy(T1i_C);
    }

    /*
     计算水蒸气的焓值
     */
    public double calH1o(double T1o_C){
        return _H2OVapor_enthalpy(T1o_C);
    }

    public double getTwei(){
        return Twei;
    }

    public double getTweo(){
        return Tweo;
    }

    public double getT1i(){
        return T1i;
    }

    public double getT1o(){
        return T1o;
    }

    public double getP1i(){
        return P1i;
    }

    public double getP1o(){
        return P1o;
    }

    public double getH1i(){
        return H1i;
    }

    public double getH1o() {
        return H1o;
    }


    public double getX1i(){
        return X1i;
    }

    public double getX1o(){
        return X1o;
    }

    public void printEvaporator(){
        System.out.println("\t蒸发器状态参数如下所示:" );

        System.out.println("\t  已知:" );
        System.out.println("\t    Twei = "+Twei+"˚C");
        System.out.println("\t    Tweo = "+Tweo+"˚C");

        System.out.println("\t  假定:" );
        System.out.println("\t    ∆Te  = " +deltaT_e+"˚C");

        System.out.println("\t  求得:" );
        System.out.println("\t    T1i  = " +T1i +"˚C");
        System.out.println("\t    P1i  = " +P1i +"kPa");
        System.out.println("\t    H1i  = " +H1i +"kJ/kg");
        System.out.println("\t    X1i  = " +X1i +"%");
        System.out.println("\t    T1o  = " +T1o +"˚C");
        System.out.println("\t    P1o  = " +P1o +"kPa");
        System.out.println("\t    H1o  = " +H1o +"kJ/kg");
        System.out.println("\t    X1o  = " +X1o +"%");
    }

}

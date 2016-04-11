package lyn.librpump.kernel.absorber;

import lyn.librpump.kernel.formular.Formular;

/**
 * Created by lyn on 16/4/11.
 */

/*
 溴化锂吸收式热泵的吸收器（Absorber）。
 吸收器:
 已知量为二次水的入口温度 Twai = 50˚C、二次水的出口温度 Twco = 70˚C,以及∆T
 所求
 状态点    物质       位置          温度/˚C      压力/kPa       焓/(kJ/kg)   质量分数（LiBr）%
 2        稀溶液      吸收器出口      T2o         P2o           H2o         X2o
 6        浓溶液      吸收器入口      T6i         P6i           H6i         X6i

 ∆: /'delta/

 */

public class Absorber {

        Formular formular;

        //二次水入口温度及二次水出吸收器的温度
        double Twai,Twao;
        //二次水在吸收器中升温幅度
        double deltaTw1;
        //出口稀溶液温升
        double deltaT_a = 6;

        //再循环倍率（circulationRate） f = M/(ML-MH) 即单位质量流量的水蒸气需要稀溶液的质量流量
        double circulationRate_a = 30;

        double T2o,P2o,H2o,X2o;
        double T6i,P6i,H6i,X6i;



//各参数意义：吸收器入口二次水温度， 二次水在吸收器中的升温程度,
        public Absorber(double Twai,double deltaT_w1,double deltaT_a,double p_a,double deltaX_a){
            this.Twai = Twai;
            this.deltaTw1 = deltaT_w1;
            this.deltaT_a = deltaT_a;
            this.Twao = calTwao();
            this.T2o  = calT2o();
            this.P2o = p_a;
            this.X2o = calX2o();
            this.H2o = calH2o();

            this.P6i = p_a;
            this.X6i = X2o  +  deltaX_a * 100;
            this.T6i = calT6i();
            this.H6i = calH6i();
        }

        public double calTwao(){
            return this.Twai  +  this.deltaTw1;
        }

        public double calT2o(){
            return Twao  +  deltaT_a;
        }

        public double calX2o(){
            return formular._concentration_LiBrSolution(T2o, P2o);
        }

        public double calH2o(){
            return formular.enthalpyLiBrSolution(T2o, X2o);
        }

        public double calT6i(){
        double temperatureForWater = formular.saturationTemperatureH2O(P6i);
            return formular.dewTLiBr(temperatureForWater, X6i);
        }

        public double calH6i(){
            return formular.enthalpyLiBrSolution(T6i, X6i);
        }

        public double getX2o(){
            return this.X2o;
        }

        public double getT2o(){
            return this.T2o;
        }

        public double getX6i(){
            return this.X6i;
        }

        public double getH2o(){
            return this.H2o;
        }

        public void printAbsorber(){

            System.out.println("\t吸收器状态参数如下所示:\n");

            System.out.println("\t  已知:");
            System.out.println("\t    Twai = " + Twai + "˚C");
            System.out.println("\t    Twao = " + Twao + "˚C");

            System.out.println("\t  假定:" );
            System.out.println("\t    ∆Tw1 = " + deltaTw1 + "˚C");

            System.out.println("\t  求得:" );
            System.out.println("\t    T2o = "  + T2o + "˚C" );
            System.out.println("\t    P2o = "  + P2o + "kPa" );
            System.out.println("\t    H2o = "  + H2o + "kJ/kg" );
            System.out.println("\t    X2o = "  + X2o + "%" );

            System.out.println("\t    T6o = "  + T6i + "˚C" );
            System.out.println("\t    P6i = "  + P6i + "kPa" );
            System.out.println("\t    H6i = "  + H6i + "kJ/kg" );
            System.out.println("\t    X6i = "  + X6i + "%" );
        }


}

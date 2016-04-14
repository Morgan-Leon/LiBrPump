package lyn.librpump.kernel.pump;

import lyn.librpump.kernel.absorber.Absorber;
import lyn.librpump.kernel.condenser.Condenser;
import lyn.librpump.kernel.evaporator.Evaporator;
import lyn.librpump.kernel.generator.Generator;
import lyn.librpump.kernel.heatExchanger.HeatExchanger;

/**
 * Created by lyn on 16/4/11.
 */
public class Pump {

    //thermal load : 热负荷Q（KW）
    double thermalLoad = 5000;
    //tdr: Temperature difference ratio 温差比
    //吸收器与冷凝器的温差比
    double a_tdr = 1.3/2.4;
    double c_tdr = 1.1/2.4;

    //驱动热源温度 Twgi = 150˚C
    double Twgi = 150;

    //低品质热源温度：
    double Twei =45,Tweo = 30, deltaT_e=3.00000;
    //所制取热水温度：
    double Twco = 70,Twai = 50;

    //二次水的温差
    double deltaT_w;
    //二次水在吸收器中的升温程度
    double deltaT_w1;
    //二次水在冷凝器中的升温程度
    double deltaT_w2;

    //默认出口稀溶液温升
    double deltaT_a = 6.000;

    //蒸发器与吸收器间的压力差(13.3-65)Pa
    double deltaP_e = 25;

    //吸收器进口浓溶液与稀溶液间的浓度差(XH-XL) = 0.03至0.06
    double deltaX_a = 0.04;

    //冷凝器出口水温要略高于二次水出口，其大小由冷凝管决定（3-5˚C）
    double deltaT_c = 5;

    //T8o 与冷端(T2o)温差通常控制在5˚C以上（5-25˚C），即∆T_h = 17（5至25之间）
    double deltaT_h = 17;

    //XH:溴化锂浓溶液浓度 XL:溴化锂稀溶液浓度
    double XH, XL;

    //循环倍率（circulationRate）：a = XH/(XH-XL)
    double circulationRate;

    /*
    Q_e: 蒸发器吸热量 = h1o - h3o
    Q_c: 冷凝器放热量 = h4wo - h3o
    Q_a: 吸收器放热量 = h1o + (a - 1) * h8o - a * h2o
    Q_g: 发生器耗热量 = (a - 1) * h4o + h4wo - a * h7o
    Q_ex: 溶液热交换器的换热量 = a * (h7o - h2o)
    */
    double Q_e, Q_c, Q_a, Q_g, Q_ex;


    public Evaporator e;
    public Absorber a;
    public Condenser c;
    public Generator g;
    public HeatExchanger h;

    //热能效率
    double cop;

    public Pump(){

        pumpInit(this.Twai, this.Twco, this.a_tdr, this.c_tdr);

        this.e = new Evaporator(Twei,Tweo,deltaT_e);
        System.out.println("蒸发器构建成功");
        e.printEvaporator();

        double p_a = calPressrueOfAbsorber(e.getP1o(), this.deltaP_e);
        //默认吸收器与冷凝器温度差为6摄氏度
        this.a = new Absorber(Twai, deltaT_w1,deltaT_a,p_a, deltaX_a);
        System.out.println("\n吸收器构建成功");
        a.printAbsorber();

        this.c = new Condenser(Twco,deltaT_c);
        System.out.println("\n冷凝器构建成功");
        c.printCondenser();

        //构造发生器需要吸收器入口温度浓度和冷凝器出口温度
        this.g = new Generator(c.getT3o(),c.getP3o(),a.getX2o(),a.getX6i());
        System.out.println("\n发生器构建成功");
        g.printGenerator();

        this.XL = a.getX2o();
        this.XH = g.getX4o();

        this.circulationRate = calCirculationRate(XL, XH);

        //构造溶液热交换器需要吸收器稀溶液出口温度和浓度以及发生器浓溶液出口浓度
        this.h = new HeatExchanger(a.getT2o(),XL, XH, g.getH4o(),a.getH2o(), this.deltaT_h);
        System.out.println("\n溶液热交换器构造成功");
        h.printHeatExchanger();

        calCOP();

    }


    public Pump(double Twai, double Twco, double Twei, double Tweo, double deltaT_e
            ,double a_tdr, double c_tdr, double deltaT_a
            ,double deltaP_e ,double deltaX_a
            ,double deltaT_c, double deltaT_h){
        pumpInit(Twco,Twai,a_tdr,c_tdr);

        this.e = new Evaporator(Twei,Tweo,deltaT_e);
        System.out.println("蒸发器构建成功");
        e.printEvaporator();
        //由蒸发器决定吸收器压强
        double p_a = calPressrueOfAbsorber(e.getP1o(), this.deltaP_e);
        //默认吸收器与冷凝器温度差为6摄氏度
        this.a = new Absorber(Twai, deltaT_w1,deltaT_a, p_a, deltaX_a);
        System.out.println("\n吸收器构建成功");
        a.printAbsorber();

        this.c = new Condenser(Twco,deltaT_c);
        System.out.println("\n冷凝器构建成功");
        c.printCondenser();

        //构造发生器需要吸收器入口温度浓度和冷凝器出口温度
        this.g = new Generator(c.getT3o(),c.getP3o(),a.getX2o(),a.getX6i());
        System.out.println("\n发生器构建成功");
        g.printGenerator();

        this.XL = a.getX2o();
        this.XH = g.getX4o();

        this.circulationRate = calCirculationRate(XL, XH);

        //构造溶液热交换器需要吸收器稀溶液出口温度和浓度以及发生器浓溶液出口浓度
        this.h = new HeatExchanger(a.getT2o(),XL, XH, g.getH4o(),a.getH2o(), deltaT_h);
        System.out.println("\n溶液热交换器构造成功");
        h.printHeatExchanger();

        this.circulationRate = calCirculationRate(XL, XH);

        calCOP();

    }

    public Pump(double Twai, double Twco, double Twei, double Tweo){
        pumpInit(Twco,Twai,a_tdr,c_tdr);

        this.e = new Evaporator(Twei,Tweo,deltaT_e);
        System.out.println("蒸发器构建成功");
        e.printEvaporator();
        //由蒸发器决定吸收器压强
        double p_a = calPressrueOfAbsorber(e.getP1o(), this.deltaP_e);
        //默认吸收器与冷凝器温度差为6摄氏度
        this.a = new Absorber(Twai, deltaT_w1,deltaT_a, p_a, deltaX_a);
        System.out.println("\n吸收器构建成功" );
        a.printAbsorber();

        this.c = new Condenser(Twco,deltaT_c);
        System.out.println("\n冷凝器构建成功" );
        c.printCondenser();

        //构造发生器需要吸收器入口温度浓度和冷凝器出口温度
        this.g = new Generator(c.getT3o(),c.getP3o(),a.getX2o(),a.getX6i());
        System.out.println("\n发生器构建成功" );
        g.printGenerator();

        this.XL = a.getX2o();
        this.XH = g.getX4o();

        this.circulationRate = calCirculationRate(XL, XH);

        //构造溶液热交换器需要吸收器稀溶液出口温度和浓度以及发生器浓溶液出口浓度
        this.h = new HeatExchanger(a.getT2o(),XL, XH, g.getH4o(),a.getH2o(), deltaT_h);
        System.out.println("\n溶液热交换器构造成功" );
        h.printHeatExchanger();

        this.circulationRate = calCirculationRate(XL, XH);

        calCOP();

    }

/*
 吸收器和冷凝器 二次水温差
*/

    public void pumpInit(double Twai, double Twco, double a_tdr, double c_tdr){

        this.deltaT_w = Twco - Twai;
        this.deltaT_w1 = this.deltaT_w*a_tdr;
        this.deltaT_w2 = this.deltaT_w*c_tdr;
    }


    public double calCirculationRate(double XL, double XH){
        this.circulationRate = XH / (XH - XL);
        return this.circulationRate;
    }

    public double calPressrueOfAbsorber(double p1o,double deltaP_e){
        return p1o-(deltaP_e/1000);
    }

    public double getCirculationRate(){
        return this.circulationRate;
    }

    public void set_tdrAC(double a,double b){
        this.a_tdr = a/(a+b);
        this.c_tdr = b/(a+b);
        this.deltaT_w1 = this.deltaT_w * this.a_tdr;
        this.deltaT_w2 = this.deltaT_w * this.c_tdr;
    };

    public double calQe(){
        this.Q_e = e.getH1o() - c.getH3o();
        return this.Q_e;
    }

    public double calQc(){
        this.Q_c = g.getH4wo() - c.getH3o();
        return this.Q_c;
    }

    public double calQa(){
        double a = getCirculationRate();
        this.Q_a = e.getH1o() + (a - 1) * h.getH8o() - a * this.a.getH2o();
        return this.Q_a;
    }

    public double calQg(){
        double a = getCirculationRate();
        this.Q_g = (a - 1) * g.getH4o() + g.getH4wo() - a * h.getH7o();
        return this.Q_g;
    }

    public double calQex(){
        double a = getCirculationRate();
        this.Q_ex = a * (h.getH7o() - this.a.getH2o());
        return this.Q_ex;
    }

    public double calCOP(){
        calQa();
        calQc();
        calQe();
        calQex();
        calQg();
        System.out.println("Qg + Qe = " + Q_g + Q_e);
        System.out.println("Qc + Qa = " + Q_c + Q_a);
        this.cop = (Q_c + Q_a) / Q_g;
        System.out.println("COP = " +cop );
        return cop;
    }

    public double getCOP () {
        return this.cop;
    }

    public double getA_tdr() {
        return a_tdr;
    }

    public double getC_tdr() {
        return c_tdr;
    }

    public double getTwgi() {
        return Twgi;
    }

    public double getTwei() {
        return Twei;
    }

    public double getTweo() {
        return Tweo;
    }

    public double getDeltaT_e() {
        return deltaT_e;
    }

    public double getTwco() {
        return Twco;
    }

    public double getTwai() {
        return Twai;
    }

    public double getDeltaT_w() {
        return deltaT_w;
    }

    public double getDeltaT_w1() {
        return deltaT_w1;
    }

    public double getDeltaT_w2() {
        return deltaT_w2;
    }

    public double getDeltaT_a() {
        return deltaT_a;
    }

    public double getDeltaP_e() {
        return deltaP_e;
    }

    public double getDeltaX_a() {
        return deltaX_a;
    }

    public double getDeltaT_c() {
        return deltaT_c;
    }

    public double getDeltaT_h() {
        return deltaT_h;
    }

    public double getXH() {
        return XH;
    }

    public double getXL() {
        return XL;
    }

    public double getQ_e() {
        return Q_e;
    }

    public double getQ_c() {
        return Q_c;
    }

    public double getQ_a() {
        return Q_a;
    }

    public double getQ_g() {
        return Q_g;
    }

    public double getQ_ex() {
        return Q_ex;
    }
}

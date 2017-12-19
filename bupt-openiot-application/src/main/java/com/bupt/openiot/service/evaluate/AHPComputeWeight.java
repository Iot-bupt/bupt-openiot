package com.bupt.openiot.service.evaluate;

import java.math.BigDecimal;


public class AHPComputeWeight {
    /**
     * @param args
     */

    public static void main(String[] args) {
        //是否报修 可使用
        /** a为N*N矩阵 */
        int i,j;
        double[] w = new double[]{7,6,1,3};
        double[][] k = new double[4][5];//5代表有多少个设备 ，4代表每个设备的属性个数，从数据库中读取存入
    	/*
    	 *     设备1 设备2
    	 * 速度
    	 * 高度
    	 * 加速度
    	 */
        int e=1; //如果属性值为0 如何处理 先做判断？？如果该能力所需的属性均不为零则纳入可选择 还是直接建表 ，在注册设备的时候就进行分表，根据能力查相应的表
        k[0][0]=2.5;
        k[1][0]=80;
        k[2][0]=20;
        k[3][0]=80;


        k[0][1]=6;
        k[1][1]=80;
        k[2][1]=25;
        k[3][1]=80;


        k[0][2]=15;
        k[1][2]=80;
        k[2][2]=25;
        k[3][2]=90;


        k[0][3]=10;
        k[1][3]=80;
        k[2][3]=23;
        k[3][3]=90;


        k[0][4]=35;
        k[1][4]=100;
        k[2][4]=27;
        k[3][4]=200;



        AHPComputeWeight instance = AHPComputeWeight.getInstance();
        instance.AHPQ(w,k);

        //( System.out.println(Arrays.toString(weight));
    }

    // 单例      
    private static final AHPComputeWeight acw = new AHPComputeWeight();

    // 平均随机一致性指针      
    private double[] RI = { 0.00, 0.00, 0.58, 0.90, 1.12, 1.21, 1.32, 1.41,
            1.45, 1.49 };

    // 随机一致性比率      
    private double CR = 0.0;

    // 最大特征值      
    private double lamta = 0.0;

    /**
     * 私有构造   
     */
    private AHPComputeWeight() {

    }

    /**
     * 返回单例   
     *
     * @return
     */
    public static AHPComputeWeight getInstance() {
        return acw;
    }

    /**
     * 计算权重   
     *
     * @param a
     * @param weight
     * @param N
     */
    public void AHPQ(double[] w,double[][] k){
        double num ;
        int N = w.length;
        double[] weight = new double[N];
        double[][] a = new double[N][N];
        double[][] b = new double[5][5]; //设备个数
        System.out.println("A=");
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++){
                num =w[i]/w[j];
                a[i][j] = num;
                if(j==N-1){
                    System.out.println(num + " ");
                }
                else System.out.print(num + " ");
            }
        System.out.println();
        System.out.println();
        System.out.print("W0=");
        weight = weight(a,N);
        for (int i = 0; i < N; i++) {

            System.out.print(weight[i] + " ");
        }
        System.out.println();
        System.out.println();System.out.println();System.out.println();
   	     /* k[0][0]/k[0][0] k[0][0]/k[0][1]
		  * k[0][1]/k[0][0] k[0][1]/k[0][1]
		  
   
    	for(int m=0;m<4;m++){
    	for(int i=0;i<2;i++)
    	for(int j=0;j<2;j++){
    	num=k[m][i]/k[m][j];
    	b[i][j]=num;
    	}
    	double[] w = new double[2];  
    	weight(b,w,2);
    	}
    	*/
        double[][] wk= new double[N][];

        for(int m=0;m<4;m++){//shuxing数
            System.out.println("B"+(m+1)+"=");
            for(int i=0;i<5;i++)//shebeishu
                for(int j=0;j<5;j++){
                    num=k[m][i]/k[m][j];
                    b[i][j]=num;
                    if(j==3){
                        System.out.println(num + " ");
                    }
                    else System.out.print(num + " ");
                }
            wk[m] = new double[5];  //shebeishu
            //double[] wk = new double[2];
            wk[m] = weight(b,5);//shebeishu
            System.out.print("W"+(m+1)+"=");
            for (int i = 0; i < 5; i++) {   //shebeishu

                System.out.print(wk[m][i] + " ");
            }
            System.out.println();
        }
         
    	/*weight[0]*wk[0][0]+weight[1]*wk[1][0]+weight[2]*wk[2][0]+weight[3]*wk[3][0]   -weight[4]*wk[4][i]*/
        for(int i=0;i<5;i++)
            System.out.println("P"+(i+1)+"="+(weight[0]*wk[0][i]+weight[1]*wk[1][i]+weight[2]*wk[2][i]-weight[3]*wk[3][i] ));
    }
    public double[] weight(double[][] a, int N) {
        // 初始向量Wk      
        double[] w0 = new double[N];

        for (int i = 0; i < N; i++) {
            w0[i] = 1.0 / N;
        }

        // 一般向量W（k+1）      
        double[] w1 = new double[N];

        // W（k+1）的归一化向量      
        double[] w2 = new double[N];

        double sum = 1.0;

        double d = 1.0;

        // 误差      
        double delt = 0.00001;

        while (d > delt) {
            d = 0.0;
            sum = 0;

            // 获取向量      
            //int index = 0;      
            for (int j = 0; j < N; j++) {
                double t = 0.0;
                for (int l = 0; l < N; l++)
                    t += a[j][l] * w0[l];
                // w1[j] = a[j][0] * w0[0] + a[j][1] * w0[1] + a[j][2] * w0[2];      
                w1[j] = t;
                sum += w1[j];
            }

            // 向量归一化      
            for (int k = 0; k < N; k++) {
                w2[k] = w1[k] / sum;

                // 最大差值      
                d = Math.max(Math.abs(w2[k] - w0[k]), d);

                // 用于下次迭代使用      
                w0[k] = w2[k];
            }
        }

        // 计算矩阵最大特征值lamta，CI，RI      
        lamta = 0.0;

        for (int k = 0; k < N; k++) {
            lamta += w1[k] / (N * w0[k]);
        }

        double CI = (lamta - N) / (N - 1);

        if (RI[N - 1] != 0) {
            CR = CI / RI[N - 1];
        }

        // 四舍五入处理      
        lamta = round(lamta, 3);
        CI = round(CI, 3);
        CR = round(CR, 3);

        for (int i = 0; i < N; i++) {
            w0[i] = round(w0[i], 4);
            w1[i] = round(w1[i], 4);
            w2[i] = round(w2[i], 4);
        }

        return w2;

    }

    /**
     * 四舍五入   
     *
     * @param v
     * @param scale
     * @return
     */
    public double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 返回随机一致性比率   
     *
     * @return
     */
    public double getCR() {
        return CR;
    }
}   
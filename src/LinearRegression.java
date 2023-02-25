public class LinearRegression {

    public static void main(String[] args) {
        double[][] table = {{10,100}, {11,114},{12,118},{13,130},{14,139},{15,141}};
        print2DArray(table);
        System.out.println("-".repeat(10)+"\n");
        double a = calculateA(table);
        double b = calculateB(a, table);
        System.out.printf("The result equation is Y = %.2fX + %.2f",a,b);


    }
    public static void print2DArray(double [][] table){
        for(int i =0; i< table.length; i++){
            for(int j = 0; j <table[0].length; j++){
                System.out.print(!(j == table[0].length-1)?table[i][j] + "  ":table[i][j]+"\n");
            }
        }
    }
    public static double calculateA(double[][] table){
        if((table.length ==0) || table[0].length ==0) return 0;
        double sumX =0;
        double sumY = 0;
        double xSquared = 0;
        double xTimesY= 0;
        for(int i =0; i< table.length; i++){
            for(int j = 0; j <table[0].length-1; j++){
                xTimesY +=(table[i][j] *table[i][j+1]);
                xSquared += Math.pow(table[i][j],2);
                sumX += table[i][j];
                sumY += table[i][j+1];
            }
        }
        return((table.length*(xTimesY)-(sumX*sumY))/(table.length*(xSquared) -Math.pow(sumX,2)));
    }
    public static double calculateB(double a, double[][]table){
        double sumY = 0;
        double sumX = 0;
        for(int i =0; i< table.length; i++){
            for(int j = 0; j <table[0].length-1; j++){
                sumX += table[i][j];
                sumY += table[i][j+1];
            }
        }
        return (sumY/table.length)- a*(sumX/ table.length);
    }

}

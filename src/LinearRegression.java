import java.util.Scanner;

public class LinearRegression {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double[][] table = { { 0.2, 1.5 }, { 2.7, 1.8 }, { 4.5, 3.1 }, { 5.9, 2.6 }, { 7.2, 3.6 }};

        print2DArray(table);
        separate();
        double r = linearCorrelationCoefficient(table);
        double r2 = r * r;
        double a = calculateA(table);
        double b = calculateB(a, table);
        double sqr = sumOfResidualSquared(a, b, table);
        double aic = akaikeInfoCriteria(sqr, table);
        System.out.println(a);
        System.out.println(b);
        System.out.printf("The sum of residual squared is %.3f %n",sqr);
        System.out.printf("The result equation is Y = %.2fX + (%.2f)%n", a, b);
        separate();
        System.out.printf("The Linear Correlation Coefficient is %.2f%n", (r));
        System.out.printf("The relationship between the two variables explain %.2f of the variation in the data%n",
                (r2));
        System.out.printf("The akaike criteria is: %.4f" , aic);

    }

    public static void print2DArray(double[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(!(j == table[0].length - 1) ? table[i][j] + "  " : table[i][j] + "\n");
            }
        }
    }

    public static double calculateA(double[][] table) {
        if ((table.length == 0) || table[0].length == 0)
            return 0;
        double sumX = 0;
        double sumY = 0;
        double xSquared = 0;
        double xTimesY = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length - 1; j++) {
                xTimesY += (table[i][j] * table[i][j + 1]);
                xSquared += Math.pow(table[i][j], 2);
                sumX += table[i][j];
                sumY += table[i][j + 1];
            }
        }
        return ((table.length * (xTimesY) - (sumX * sumY)) / (table.length * (xSquared) - Math.pow(sumX, 2)));
    }

    public static double calculateB(double a, double[][] table) {
        double sumY = 0;
        double sumX = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length - 1; j++) {
                sumX += table[i][j];
                sumY += table[i][j + 1];
            }
        }
        return (sumY / table.length) - a * (sumX / table.length);

    }

    public static double linearCorrelationCoefficient(double[][] values) {
        if ((values.length == 0) || values[0].length == 0)
            return 0;
        double sumX = 0;
        double sumY = 0;
        double xSquared = 0;
        double ySquared = 0;
        double xTimesY = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length - 1; j++) {
                xTimesY += (values[i][j] * values[i][j + 1]);
                xSquared += Math.pow(values[i][j], 2);
                sumX += values[i][j];
                sumY += values[i][j + 1];
                ySquared += Math.pow(values[i][j + 1], 2);
            }
        }
        double denominator = ((values.length * xSquared) - Math.pow(sumX, 2))
                * ((values.length * ySquared) - (sumY * sumY));
        return (values.length * xTimesY - (sumX * sumY)) / (Math.sqrt(denominator));
    }

    public static void separate() {
        System.out.println("--------\n".repeat(4));
    }

    public static double sumOfResidualSquared(double a, double b, double[][]table){
        double sqr = 0;
        double diff =0;
        for(int i =0; i<table.length; i++){
            for(int j = 0; j<table[0].length-1; j++){
                diff =(table[i][j+1]) - (table[i][j]*a + b);
                sqr += Math.pow((diff), 2);
            }
        }
    return sqr;
    } 

    public static double akaikeInfoCriteria(double sqr, double[][] table ){
        double length = table.length;
        double fHalf = (table.length)*Math.log((sqr/table.length));
        double sHalf = (2.0*2.0)*(length/(length-2-1));
        return(fHalf + sHalf);
    }

    

    // public static Double[][] createEmpty2DArray(int row, int column) {
    // Double[][] empty = new Double[row][column];

    // }
}

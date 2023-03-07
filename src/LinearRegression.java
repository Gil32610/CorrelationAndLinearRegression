import java.util.Scanner;

public class LinearRegression {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double[][] table = { { 5, 6 }, { 8, 9 }, { 7, 8 }, { 10, 10 }, { 6, 5 }, { 7, 7 }, { 9, 8 }, { 3, 4 }, { 8, 6 },
                { 2, 2 } };

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length - 1; j++) {
                System.out.println("Value of X: ");

            }
        }
        print2DArray(table);
        separate();
        double r = linearCorrelationCoefficient(table);
        double r2 = r * r;
        double a = calculateA(table);
        double b = calculateB(a, table);
        System.out.printf("The result equation is Y = %.2fX + (%.2f)%n", a, b);
        separate();
        System.out.printf("The Linear Correlation Coefficient is %.2f%%%n", (r * 100));
        System.out.printf("The relationship between the two variables explain %.2f%% of the variation in the data",
                (r2 * 100));

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

        // public static Double[][] createEmpty2DArray(int row, int column) {
        //     Double[][] empty = new Double[row][column];

        // }
}

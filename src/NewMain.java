public class NewMain {
    public static void main(String[] args) {
        double[][] bidimensionalArray = new double [10][2];
        print2DArray(bidimensionalArray);
    }
    public static void print2DArray(double[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(!(j == table[0].length - 1) ? table[i][j] + "  " : table[i][j] + "\n");
            }
        }
    }
}

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        new Main();
    }

    public Main() {
        /**
         *  Mátrix mérete
         */
        int n = 3;

        /**
         * Fajl beolvasa (txt)
         */
        ArrayList<String> arrayList = Fajl.beolvaso();
        /**
         * Nyeregpont megkeresése
         */
        nyeregPontKereses(matrix(arrayList, n));
    }

    /**
     * Matrix megalkotasa
     */
    private double[][] matrix(ArrayList<String> arrayList, int n) {
        double[][] matrix = new double[n][n];
        String[] elem;
        for (int i = 0; i < n; i++) {
            elem = arrayList.get(i).split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Double.parseDouble(elem[j]);
            }
        }
        return matrix;
    }

    private void nyeregPontKereses(double[][] matrix) {
        boolean nemLetezikNyeregPont = true;
        for (int i = 0; i < matrix.length; i++) {
            boolean letezikNyeregPont = true;
            double minimum = matrix[i][0];
            int sorMinimumIndex = 0;

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < minimum) {
                    minimum = matrix[i][j];
                    sorMinimumIndex = j;
                }
            }

            for (int j = 0; j < matrix.length; j++) {
                if (minimum < matrix[j][sorMinimumIndex]) {
                    letezikNyeregPont = false;
                    break;
                }
            }
            if (letezikNyeregPont) {
                System.out.println("Létezik nyeregpont ami a : " + minimum);
                nemLetezikNyeregPont=false;
            }
        }
        if (nemLetezikNyeregPont) {
            System.out.println("Nem létezik nyeregpont.");
        }
    }
}

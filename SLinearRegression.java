package example.behaviours;

import java.util.Scanner;

public class SLinearRegression {
    
    private static double[][] dataSet = null;
    private static double beta0 = 0.0;
    private static double beta1 = 0.0;

    public static void main(String[] args) {
       
        mostrar();  
    }

    public static void mostrar() {

        Scanner leer = new Scanner(System.in);
        double x = 0;

        ConjuntoDatos();
        System.out.println("Ecuacion: y = " + beta0 + " + " + beta1 + " * x");

        System.out.print("Valor de x:");
        x=leer.nextDouble();
        System.out.println("Prediccion:"+(beta0 + beta1*x));
    }
    
    public static void prediccion(double x) {
        System.out.println("Prediccion:"+(beta0 + beta1*x));
    }

    private static void ConjuntoDatos() {
        dataSet = new double[2][9];
        dataSet[0][0] = 23.0;   dataSet[0][1] = 26.0;   dataSet[0][2] = 30.0;
        dataSet[0][3] = 34.0;   dataSet[0][4] = 43.0;   dataSet[0][5] = 48.0;
        dataSet[0][6] = 52.0;   dataSet[0][7] = 57.0;   dataSet[0][8] = 58.0;
        dataSet[1][0] = 651.0;  dataSet[1][1] = 762.0;  dataSet[1][2] = 856.0;
        dataSet[1][3] = 1063.0; dataSet[1][4] = 1190.0; dataSet[1][5] = 1298.0;
        dataSet[1][6] = 1421.0; dataSet[1][7] = 1440.0; dataSet[1][8] = 1518.0;
        calcularBeta0(9);
        calcularBeta1(9);
    }

    private static double Suma(int row, int i, int n) {
        double suma = 0.0;
        for(int j = i - 1; j <= n - 1; j++) 
            suma += dataSet[row][j];
        return suma;
    }

    private static double SumaProd(int row1, int row2, int i, int n) {
        double suma = 0.0;
        for(int j = i - 1; j <= n - 1; j++) 
            suma += dataSet[row1][j] * dataSet[row2][j];
        return suma;
    }

    private static double calcularBeta0(int n) {
        beta0 = (Suma(1, 1, 9) / n) - (calcularBeta1(n) * (Suma(0, 1, 9) / n));
        return beta0;
    }

    private static double calcularBeta1(int n) {
        beta1 = (n * SumaProd(0, 1, 1, 9) - Suma(0, 1, 9) * Suma(1, 1, 9)) / (n * SumaProd(0, 0, 1, 9) - Math.pow(Suma(0, 1, 9), 2.0));
        return beta1;
    }
}

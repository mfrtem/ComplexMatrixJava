import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ComplexMatrix matrixA = null;
        ComplexMatrix matrixB = null;

        while (true) {

        System.out.println("1. Create matrix A");
        System.out.println("2. Create matrix B");
        System.out.println("3. A = A+B");
        System.out.println("4. A = A*B");
        System.out.println("5. A = A/B");
        System.out.println("6. Transpose A");
        System.out.println("7. Determinant A");
        System.out.println("8. Show matrix A");
        System.out.println("0. Exit");
        
        int choice = scanner.nextInt();

            try {

                switch (choice){
                    case 1:
                        System.out.println("Create matrix A");

                        System.out.print("Rows: ");
                        int rows = scanner.nextInt();

                        System.out.print("Columns: ");
                        int columns = scanner.nextInt();

                        matrixA = new ComplexMatrix(rows, columns);
                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < columns; j++) {
                                System.out.print("Real part: ");
                                double real = scanner.nextDouble();

                                System.out.print("Imaginary part: ");
                                double imaginary = scanner.nextDouble();

                                matrixA.set(i, j, new Complex(real, imaginary));
                            }
                        }

                        break;
                    
                    case 2:
                        System.out.println("Create matrix B");

                        System.out.print("Rows: ");
                        int rowsB = scanner.nextInt();

                        System.out.print("Columns: ");
                        int columnsB = scanner.nextInt();

                        matrixB = new ComplexMatrix(rowsB, columnsB);

                        for (int i = 0; i < rowsB; i++) {
                            for (int j = 0; j < columnsB; j++) {
                                System.out.print("Real part: ");
                                double real = scanner.nextDouble();

                                System.out.print("Imaginary part: ");
                                double imaginary = scanner.nextDouble();

                                matrixB.set(i, j, new Complex(real, imaginary));
                            }
                        }

                        break;

                    case 3:
                        System.out.println("Add matrices");

                        if (matrixA == null || matrixB == null) {
                            System.out.println("Create both matrices first");
                            break;
                        }

                        matrixA = matrixA.add(matrixB);

                        System.out.println("Matrix A:");
                        System.out.println(matrixA);

                        break;
                    
                    case 4:
                        System.out.println("Multiply matrices");

                        if (matrixA == null || matrixB == null) {
                            System.out.println("Create both matrices first");
                            break;
                        }

                        matrixA = matrixA.multiply(matrixB);

                        System.out.println("Matrix A:");
                        System.out.println(matrixA);

                        break;

                    case 5:
                        System.out.println("Divide matrices");

                        if (matrixA == null || matrixB == null) {
                            System.out.println("Create both matrices first");
                            break;
                        }

                        matrixA = matrixA.divide(matrixB);

                        System.out.println("Matrix A:");
                        System.out.println(matrixA);

                        break;

                    case 6:
                        System.out.println("Transpose matrix A");

                        if (matrixA == null) {
                            System.out.println("Create matrix A first");
                            break;
                        }

                        matrixA = matrixA.transpose();

                        System.out.println("Matrix A:");
                        System.out.println(matrixA);

                        break;
                    
                    case 7:
                        System.out.println("Determinant of matrix A");

                        if (matrixA == null) {
                            System.out.println("Create matrix A first");
                            break;
                        }

                        Complex result7 = matrixA.determinant();

                        System.out.println("Determinant: " + result7);

                        break;
                        
                    case 8:
                        if (matrixA == null) {
                            System.out.println("create matrix A first");
                            break;
                        }

                        System.out.println("Current matrix A:");
                        System.out.println(matrixA);
                        break;

                    case 0:
                        System.out.println("Exit");
                        return;

                    default:
                        System.out.println("Unknown operation"); 
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
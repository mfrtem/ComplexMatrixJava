import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ComplexMatrix matrixA = null;
        ComplexMatrix matrixB = null;

        while (true) {

        System.out.println("1. Create matrix A");
        System.out.println("2. Create matrix B");
        System.out.println("3. A+B");
        System.out.println("4. A*B");
        System.out.println("5. A/B");
        System.out.println("6. Transpose A");
        System.out.println("7. Determinant A");
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

                        ComplexMatrix result3 = matrixA.add(matrixB);

                        System.out.println("Result:");
                        System.out.println(result3);

                        break;
                    
                    case 4:
                        System.out.println("Multiply matrices");

                        if (matrixA == null || matrixB == null) {
                            System.out.println("Create both matrices first");
                            break;
                        }

                        ComplexMatrix result4 = matrixA.multiply(matrixB);

                        System.out.println("Result:");
                        System.out.println(result4);

                        break;

                    case 5:
                        System.out.println("Divide matrices");

                        if (matrixA == null || matrixB == null) {
                            System.out.println("Create both matrices first");
                            break;
                        }

                        ComplexMatrix result5 = matrixA.divide(matrixB);

                        System.out.println("Result:");
                        System.out.println(result5);

                        break;

                    case 6:
                        System.out.println("Transpose matrix A");

                        if (matrixA == null) {
                            System.out.println("Create matrix A first");
                            break;
                        }

                        ComplexMatrix result6 = matrixA.transpose();

                        System.out.println("Result:");
                        System.out.println(result6);

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
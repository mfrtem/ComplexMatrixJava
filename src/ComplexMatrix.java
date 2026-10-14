public class ComplexMatrix {
    private Complex[][] data;

    public ComplexMatrix(int rows, int columns){
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException(
                "Rows and columns must be positive"
            );
        }

        data = new Complex[rows][columns];
    }

    public void set(int row, int column, Complex value){
        data[row][column] = value;
    }

    public Complex get(int row, int column) {
        return data[row][column];
    }

    public int getRows() {
        return data.length;
    }

    public int getColumns(){
        return data[0].length;
    }

    public ComplexMatrix add(ComplexMatrix other) {
        if (getRows() != other.getRows() ||
            getColumns() != other.getColumns()) {
            throw new IllegalArgumentException("Matrix sizes must be equal");
        }

        ComplexMatrix result = new ComplexMatrix(getRows(), getColumns());
        
        for (int i=0; i < getRows(); i++){
            for (int j=0; j < getColumns(); j++){
                result.set(i, j, this.get(i, j).add(other.get(i, j)));
            }
        }
        return result;
    }

    public ComplexMatrix multiply(ComplexMatrix other) {
        if (getColumns() != other.getRows()){
            throw new IllegalArgumentException(
                "Number of columns in first matrix must equal numbers of rows in second matrix"
            );
        }

        ComplexMatrix result = new ComplexMatrix(
            getRows(),
            other.getColumns()
        );

        for (int i = 0; i < getRows(); i++){
            for (int j = 0; j < other.getColumns(); j++){
                Complex sum = new Complex(0, 0);

                for (int k = 0; k < getColumns(); k++){
                    sum = sum.add(this.get(i, k).multiply(other.get(k, j)));
                }

                result.set(i, j, sum);
            }
        }

        return result;
    }

    public ComplexMatrix transpose(){
        ComplexMatrix result = new ComplexMatrix(getColumns(), getRows());

        for (int i = 0; i < getRows(); i++){
            for (int j = 0; j < getColumns(); j++){
                result.set(j, i, this.get(i, j));
            }
        }
        return result;
    }

    private ComplexMatrix minor(int row, int column){
        ComplexMatrix result = new ComplexMatrix(
            getRows() - 1,
            getColumns() - 1
        );

        int resultRow = 0;

        for (int i = 0; i < getRows(); i++){
            if (i == row) {
                continue;
            }

            int resultColumn = 0;

            for (int j = 0; j < getColumns(); j++){
                if (j == column) {
                    continue;
                }

                result.set(resultRow, resultColumn, get(i, j));
                resultColumn++;
            }

            resultRow++;
        }

        return result;
    }

    public Complex determinant(){
        if (getRows() != getColumns()){
            throw new IllegalArgumentException("Matrix must be square");
        }
        
        int n = getRows();

        if (n == 1) {
            return get(0, 0);
        }

        if (n == 2) {
            return get(0, 0).multiply(get(1 , 1))
                    .subtract(get(0, 1).multiply(get(1, 0)));
        }
        
        Complex result = new Complex(0, 0);

        for (int j = 0; j < n; j++) {
            Complex cofactor = get(0, j).multiply(minor(0, j).determinant());

            if (j%2==0){
                result = result.add(cofactor);
            } else {
                result = result.subtract(cofactor);
            }
        }

        return result;
    }

    public ComplexMatrix inverse(){
        if (getRows() != getColumns()) {
            throw new IllegalArgumentException("Matrix must be square");
        }

        Complex det = determinant();

        if (det.getReal() ==0 && det.getImaginary() ==0){
            throw new ArithmeticException("Matrix is not invertible");
        }

        int n = getRows();
        ComplexMatrix result = new ComplexMatrix(n, n);

        if (n == 1) {
            result.set(0, 0, new Complex(1, 0).divide(get(0,0)));
            return result;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                Complex cofactor = minor(i, j).determinant();

                if ((i+j)%2!=0){
                    cofactor =new Complex(0, 0).subtract(cofactor);
                }

                result.set(j, i, cofactor.divide(det));
            }
        }
        return result;
    }

    public ComplexMatrix divide(ComplexMatrix other){
        return this.multiply(other.inverse());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < getRows(); i++){
            for (int j = 0; j < getColumns(); j++){
                result.append(get(i, j)).append("\t");
            }
            result.append("\n");
        }

        return result.toString();
    }

}
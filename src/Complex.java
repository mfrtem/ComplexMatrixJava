public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal(){
        return real;
    }

    public double getImaginary(){
        return imaginary;
    }

    public Complex add(Complex other){
        return new Complex(
            this.real + other.real,
            this.imaginary + other.imaginary
        );
    }

    public Complex subtract(Complex other){
        return new Complex(
            this.real - other.real,
            this.imaginary - other.imaginary
        );
    }

    public Complex multiply(Complex other){
        return new Complex(
            this.real * other.real - this.imaginary * other.imaginary,
            this.real * other.imaginary + this.imaginary * other.real
        );
    }

    public Complex divide(Complex other){
        double denominator = other.real * other.real 
        + other.imaginary * other.imaginary;

        if (denominator == 0){
            throw new ArithmeticException("Division by zero");
        }

        return new Complex(
            (this.real * other.real + this.imaginary * other.imaginary) / denominator,
            (this.imaginary * other.real - this.real * other.imaginary) / denominator
        );
    }

    @Override
    public String toString(){
        if (imaginary < 0) {
            return real + " - " + (-imaginary) + "i";
        }
        
        return real + " + " + imaginary + "i";
    }
}
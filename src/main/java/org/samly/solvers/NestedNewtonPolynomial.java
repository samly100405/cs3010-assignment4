package org.samly.solvers;

public class NestedNewtonPolynomial implements Evaluable{
    private final double[] x;
    private final double[] a;

    public NestedNewtonPolynomial(double[] xi, double[] yi) {
        x = xi.clone();
        a = yi.clone();
        // divided difference
        for (int j = 1; j < a.length; j++) {
            for (int i = a.length-1; i >= j; i--) {
                a[i] = (a[i] - a[i-1]) / (x[i] - x[i-j]);
            }
        }
    }


    @Override
    public double evaluate(double in) {
        double v = a[a.length-1];

        for (int i = a.length-2; i >= 0; i--) {
            v = v * (in - x[i]) + a[i];
        }

        return v;
    }


}

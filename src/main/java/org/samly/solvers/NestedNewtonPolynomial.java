package org.samly.solvers;

public class NestedNewtonPolynomial implements Evaluable{
    private final double[] x;
    private final double[] a;

    public NestedNewtonPolynomial(double[] xi, double[] yi) {
        long start = System.nanoTime();
        x = xi.clone();
        a = yi.clone();
        // divided difference

        for (int j = 1; j < a.length; j++) {
            for (int i = a.length-1; i >= j; i--) {
                a[i] = (a[i] - a[i-1]) / (x[i] - x[i-j]);
            }
        }
        long end = System.nanoTime();
        // for some reason having this timer function in main makes it 10x slower.
        System.out.println("Successfully interpolated points. Runtime: " + (end-start));
    }


    @Override
    public double evaluate(double in) {
        long start = System.nanoTime();
        double v = a[a.length-1];

        for (int i = a.length-2; i >= 0; i--) {
            v = v * (in - x[i]) + a[i];
        }

        long end = System.nanoTime();
        // for some reason having this timer function in main makes it 10x slower.
        System.out.println("Successfully evaluated. Runtime: " + (end-start));
        return v;
    }


}

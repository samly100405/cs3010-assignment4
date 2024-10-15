package org.samly;

import com.beust.jcommander.JCommander;
import org.samly.cli.Args;
import org.samly.solvers.NestedNewtonPolynomial;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Args a = new Args();
        JCommander.newBuilder()
                .addObject(a)
                .build()
                .parse(args);

        try {
            Scanner fileScanner = new Scanner(a.getFile());
            ArrayList<Double> nums = new ArrayList<>();
            while (fileScanner.hasNextDouble()) {
                nums.add(fileScanner.nextDouble());
            }

            double[] x = new double[nums.size()/2];
            double[] y = new double[nums.size()/2];
            for (int i = 0; i < nums.size()/2; i++) {
                x[i] = nums.get(i);
            }
            for (int i = nums.size()/2; i < nums.size(); i++) {
                y[i-nums.size()/2] = nums.get(i);
            }

            NestedNewtonPolynomial p;
            p = new NestedNewtonPolynomial(x, y);

            Scanner userScanner = new Scanner(System.in);
            System.out.println("Evaluating the interpolated polynomial. Enter a real number, or 'q' to quit.");
            while (true) {
                String s = userScanner.next();

                if (s.equals("q")) break;

                try {
                    double in = Double.parseDouble(s);
                    double sol = p.evaluate(in);
                    System.out.println("P(" + in + ") = " + sol);
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid number or 'q' to quit.");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

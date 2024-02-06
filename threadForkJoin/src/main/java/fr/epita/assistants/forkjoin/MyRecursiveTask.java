package fr.epita.assistants.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask {

    final private double[][] matrix;
    final private int xLowerBound;
    final private int xUpperBound;
    final private int yLowerBound;
    final private int yUpperBound;

    public MyRecursiveTask(double[][] matrix, int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound) {
        this.matrix = matrix;
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
    }

    @Override
    public Double compute()
    {
        if (xUpperBound - xLowerBound <= 5 && yUpperBound - yLowerBound <= 5)
        {
            double res = 0;
            int size = Math.abs(xUpperBound - xLowerBound) * Math.abs(yUpperBound - yLowerBound);
            if (size == 0)
            {
                return 0.0;
            }
            for (int i = xLowerBound; i < xUpperBound; i++)
            {
                for (int j = yLowerBound; j < yUpperBound; j++)
                {
                    res += matrix[j][i];
                }
            }
            return res/size;
        }
        else {
            var a1 = new MyRecursiveTask(matrix, xLowerBound, (xUpperBound-xLowerBound) / 2 + xLowerBound, yLowerBound, (yUpperBound - yLowerBound) / 2 + yLowerBound).fork();

            var a2 = new MyRecursiveTask(matrix, xLowerBound, (xUpperBound-xLowerBound) / 2 + xLowerBound, (yUpperBound - yLowerBound) / 2 + yLowerBound, yUpperBound).fork();

            var a3 = new MyRecursiveTask(matrix, (xUpperBound-xLowerBound) / 2 + xLowerBound, xUpperBound, yLowerBound, (yUpperBound - yLowerBound) / 2 + yLowerBound).fork();

            double q4 = new MyRecursiveTask(matrix, (xUpperBound-xLowerBound) / 2 + xLowerBound, xUpperBound, (yUpperBound - yLowerBound) / 2 + yLowerBound, yUpperBound).compute();

            double v = (((double) a1.join() + (double) a2.join() + (double) a3.join() + q4) / 4.);
            return v;
        }
    }
}

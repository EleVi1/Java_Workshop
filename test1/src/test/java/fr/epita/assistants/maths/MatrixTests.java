package fr.epita.assistants.maths;

import fr.epita.assistants.maths.Matrix;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTests {

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMatrixConstructor1NUll() {
        int[][] arr = {};
        Matrix mat = new Matrix(arr);
        assertEquals(0, mat.getMatrix().length, "Invalid size");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMatrixConstructor2() {
        int[][] arr1 = {{1, 2, 3, 4, 5}};
        Matrix mat1 = new Matrix(arr1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, mat1.getMatrix()[0], "Invalid row");
        assertEquals(5, mat1.getMatrix()[0].length * mat1.getMatrix()[1].length, "Invalid size");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMatrixConstructor3() {
        int[][] arr2 = {{3, 4, 5}, {1, 2}};
        Matrix mat2 = new Matrix(arr2);
        assertArrayEquals(new int[]{1, 2}, mat2.getMatrix()[1], "Invalid row");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMatrixConstructor4() {
        int[][] arr3 = {{1}, {2}, {3}, {4}};
        Matrix mat3 = new Matrix(arr3);
        assertEquals(Integer.valueOf(4), mat3.getMatrix()[0].length*mat3.getMatrix()[1].length, "Invalid size");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testEqual1() {
        int[][] arr1 = {{1, 2, 3}, {1, 2, 3}};
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {{1, 2, 3}, {1, 2, 3}};
        Matrix mat2 = new Matrix(arr2);
        assertEquals(true, mat1.equals(mat2), "Invalid result");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testEqual2() {
        int[][] arr1 = {{1, 2}, {1, 3}};
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {{1, 2, 3}, {1, 2, 3}};
        Matrix mat2 = new Matrix(arr2);
        assertEquals(false, mat1.equals(mat2), "Invalid result");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testEqual3() {
        int[][] arr1 = {{1, 2, 3}, {1, 2, 3}};
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {{1, 2, 3}, {1, 0, 3}, {2, 4, 5}};
        Matrix mat2 = new Matrix(arr2);
        assertEquals(false, mat1.equals(mat2), "Invalid result");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testEqual4() {
        int[][] arr1 = {};
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {};
        Matrix mat2 = new Matrix(arr2);
        assertEquals(true, mat1.equals(mat2), "Invalid result");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testEqual5() {
        int[][] arr1 = {};
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        Matrix mat2 = new Matrix(arr2);
        assertEquals(false, mat1.equals(mat2), "Invalid result");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testEqual6() {
        int[][] arr1 = {{1, 2, 3}, {1, 2, 3}};
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        Matrix mat2 = new Matrix(arr2);
        assertThrows(ClassCastException.class, () -> arr1.equals(mat2));
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMultiply1() {
        int[][] arr1 = null;
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {{1, 1}, {2, 2}, {3, 3}};
        Matrix mat2 = new Matrix(arr2);
        assertThrows(NullPointerException.class, () -> mat1.multiply(mat2));
    }
    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMultiply2() {
        int[][] arr1 = {{1, 2, 3}, {1, 2, 3}};
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {{1, 1}, {2, 2}, {3, 3}};
        Matrix mat2 = new Matrix(arr2);
        mat1.multiply(mat2);
        assertEquals(14, mat1.getMatrix()[1][1], "Invalid result");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMultiply3() {
        int[][] arr1 = {{1, 2, 3}, {1, 2, 3}};
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {{1, 2, 3}, {1, 2, 3}};
        Matrix mat2 = new Matrix(arr2);
        mat1.multiply(mat2);
        assertEquals(14, mat1.getMatrix()[1][1], "Invalid result");
    }

    @Test
    @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void testMultiply4() {
        int[][] arr1 = {};
        Matrix mat1 = new Matrix(arr1);

        int[][] arr2 = {};
        Matrix mat2 = new Matrix(arr2);
        mat1.multiply(mat2);
        assertEquals(0, mat1.getMatrix().length, "Invalid result");
    }
}

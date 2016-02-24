
/**
 * Created by Elena on 22.02.2016.
 */
public class Matrix2x2 {

    private double[][] matrix = new double[2][2];

    public Matrix2x2() {

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public Matrix2x2(double n) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                matrix[i][j] = n;
            }
        }
    }

    public Matrix2x2(double[][] m) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                matrix[i][j] = m[i][j];
            }
        }
    }

    public Matrix2x2(double n1, double n2, double n3, double n4) {
        matrix[0][0] = n1;
        matrix[0][1] = n2;
        matrix[1][0] = n3;
        matrix[1][1] = n4;
    }

    public void setMatrix(double m[][]) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                this.matrix[i][j] = m[i][j];
            }
        }
    }

    public double getMatrix(int i, int j) {
        return matrix[i][j];
    }

    public Matrix2x2 add(Matrix2x2 m) {
        Matrix2x2 newMatrix = new Matrix2x2();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                newMatrix.matrix[i][j] = m.getMatrix(i, j) + this.matrix[i][j];
            }
        }
        return newMatrix;
    }

    public void add2(Matrix2x2 m) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                this.matrix[i][j] = m.getMatrix(i, j) + this.matrix[i][j];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 m) {
        Matrix2x2 newMatrix = new Matrix2x2();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                newMatrix.matrix[i][j] = this.matrix[i][j]- m.getMatrix(i, j);
            }
        }
        return newMatrix;
    }

    public void sub2(Matrix2x2 m) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                this.matrix[i][j] = this.matrix[i][j]- m.getMatrix(i, j);
            }
        }
    }

    public Matrix2x2 multNumber(double n) {
        Matrix2x2 newMatrix = new Matrix2x2();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                newMatrix.matrix[i][j] = this.matrix[i][j] * n;
            }
        }
        return newMatrix;
    }

    public void multNumber2(double n) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                this.matrix[i][j] = this.matrix[i][j] * n;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 m) {
        Matrix2x2 newMatrix = new Matrix2x2();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                newMatrix.matrix[i][j] = 0;
                for (int k = 0; k <= 1; k++)
                    newMatrix.matrix[i][j] += this.matrix[i][k]*m.getMatrix(k,j);
            }
        }
        return newMatrix;
    }

    public void mult2(Matrix2x2 m) {
        Matrix2x2 newMatrix = new Matrix2x2();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                newMatrix.matrix[i][j] = 0;
                for (int k = 0; k <= 1; k++)
                    newMatrix.matrix[i][j] += this.matrix[i][k]*m.getMatrix(k,j);
            }
        }
        this.matrix[0][0]=newMatrix.matrix[0][0];
        this.matrix[0][1]=newMatrix.matrix[0][1];
        this.matrix[1][0]=newMatrix.matrix[1][0];
        this.matrix[1][1]=newMatrix.matrix[1][1];

    }

    public double det() {
        double det = this.matrix[0][0]*this.matrix[1][1] - this.matrix[0][1]*this.matrix[1][0];
        return det;
    }

    public void transpon() {
        for (int i = 1; i <= 1; i++) {
            for (int j = 0; j < 1; j++) {
                double a = this.matrix[i][j];
                this.matrix[i][j] = this.matrix[j][i];
                this.matrix[j][i] = a;
            }
        }
    }

    public Matrix2x2 inverseMatrix() throws ZeroDetException{
        Matrix2x2 newMatrix = new Matrix2x2();
        if (this.det() == 0)
            throw new ZeroDetException();
        else{
            double det1 = 1 / this.det();
            newMatrix.matrix[0][0] = this.matrix[1][1] * det1;
            newMatrix.matrix[0][1] = this.matrix[1][0] * (-1) * det1;
            newMatrix.matrix[1][0] = this.matrix[0][1] * (-1) * det1;
            newMatrix.matrix[1][1] = this.matrix[0][0] * det1;
            newMatrix.transpon();
        }
        return newMatrix;
        }


    public Matrix2x2 equivalentDiagonal() {
        double c = this.matrix[1][0] / this.matrix[0][0];
        this.matrix[1][0] = this.matrix[1][0] - c * this.matrix[0][0];
        this.matrix[1][1]=this.matrix[1][1]- c*this.matrix[0][1];
        c = this.matrix[0][1] / this.matrix[1][1];
        this.matrix[0][1] = this.matrix[0][1] - c*this.matrix[1][1];
        return this;
    }

    public Vector2D multVector(Vector2D vector) {
        double x = this.matrix[0][0] * vector.getX() + this.matrix[0][1] * vector.getY();
        double y = this.matrix[1][0] * vector.getX() + this.matrix[1][1] * vector.getY();
        Vector2D newVector = new Vector2D(x, y);
        return newVector;

    }
}

package algLin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antoine Chauvin
 */
public class HelderTest {

    @Test
    public void testFactorLDR() throws Exception {
        Matrice A = new Matrice(new double[][]{
                {1, 1, -2},
                {4, -2, 1},
                {3, -1, 3},
        });
        Matrice L = new Matrice(new double[][]{
                {1, 0, 0},
                {4, 1, 6},
                {3, (2.0/3), 1},
        });
        Matrice D = new Matrice(new double[][]{
                {1, 0, 0},
                {0, -6, 0},
                {0, -0, 3},
        });
        Matrice R = new Matrice(new double[][]{
                {1, 1, -2},
                {0, 1, 3.0/2},
                {0, 0, 1},
        });

        Helder helder = new Helder(A, null);
        helder.factorLDR();

        assertEquals("L", L, helder.L);
        assertEquals("D", D, helder.D);
        assertEquals("R", R, helder.R);
    }
}
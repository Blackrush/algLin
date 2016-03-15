package algLin;

/**
 * This class contains some useful operations (mainly described as static)
 * for linear computation (based on mathematical vectors and matrices).
 * It's not expected to be instanciated but to be used by its static methods.
 *
 * @author Cyrille Bertelle & Rawan Ghnemat
 */
public class Op {

    /**
     * This static method return the addition of the 2 Mvecteur in parameter.<br>
     * We consider her that the 2 MVecteur can be added and so are of the same dimension
     *
     * @param x the first MVecteur to add
     * @param y the second MVecteur to add
     * @return
     */

    public static MVecteur add(MVecteur x, MVecteur y) {
        MVecteur z = new MVecteur(x.dim());
        for (int i = 0; i < x.dim(); i++)
            z.setCoef(i, x.getCoef(i) + y.getCoef(i));
        return z;
    }


    public static MVecteur productVector(MVecteur mv1, MVecteur mv2) {
        MVecteur z = new MVecteur(mv1.dim());
        for (int i = 0; i < mv1.dim(); i++) {
            z.setCoef(i, mv1.getCoef(i) * mv2.getCoef(i));
        }
        return z;
    }

    public static MVecteur productScalVector(double scal, MVecteur mv1) {
        MVecteur z = new MVecteur(mv1.dim());
        for (int i = 0; i < mv1.dim(); i++) {
            z.setCoef(i, scal * mv1.getCoef(i));
        }
        return z;
    }

    public static MVecteur produitMatColVec(Matrice m1, MVecteur v1) {
        MVecteur v0 = new MVecteur(m1.nbLignes());
        for (int x = 0; x < m1.nbColonnes(); x++) {
            int nb = 0;
            for (int y = 0; y < m1.nbLignes(); y++) {
                nb += m1.getCoef(y, x) * v1.getCoef(y);
            }
            v0.setCoef(x, nb);
        }
        return v0;
    }

    public static Matrice matriceAddition(Matrice m1, Matrice m2) {
        Matrice m3 = new Matrice(m1.nbLignes(), m1.nbColonnes());
        for (int i = 0; i < m1.nbLignes(); i++) {
            for (int j = 0; j < m1.nbColonnes(); j++) {
                m3.setCoef(i, j, m1.getCoef(i, j) + m2.getCoef(i, j));
            }
        }
        return m3;
    }

    public static Matrice matriceSoustraction(Matrice m1, Matrice m2) {
        Matrice m3 = new Matrice(m1.nbLignes(), m1.nbColonnes());
        for (int i = 0; i < m1.nbLignes(); i++) {
            for (int j = 0; j < m1.nbColonnes(); j++) {
                m3.setCoef(i, j, m1.getCoef(i, j) - m2.getCoef(i, j));
            }
        }
        return m3;
    }

    public static Matrice matriceProduct(Matrice m1, Matrice m2) {
        Matrice m3 = new Matrice(m1.nbLignes(), m1.nbColonnes());
        for (int i = 0; i < m1.nbLignes(); i++) {
            for (int j = 0; j < m1.nbColonnes(); j++) {
                m3.setCoef(i, j, m1.getCoef(i, j) * m2.getCoef(j, i));
            }
        }
        return m3;
    }

    public static Matrice productScalMatrice(double scal, Matrice m2) {
        Matrice m3 = new Matrice(m2.nbLignes(), m2.nbColonnes());
        for (int i = 0; i < m2.nbLignes(); i++) {
            for (int j = 0; j < m2.nbColonnes(); j++) {
                m3.setCoef(i, j, m2.getCoef(i, j) * scal);
            }
        }
        return m3;
    }

    public static Matrice matriceDivision(Matrice m1, Matrice m2) {
        Matrice m3 = new Matrice(m1.nbLignes(), m1.nbColonnes());
        for (int i = 0; i < m1.nbLignes(); i++) {
            for (int j = 0; j < m1.nbColonnes(); j++) {
                m3.setCoef(i, j, m1.getCoef(i, j) / m2.getCoef(j, i));
            }
        }
        return m3;
    }

/**** TO COMPLETE ****/


    /**
     * This main method is just a test program for the class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        //Matrice 1
        Matrice m1 = new Matrice(2, 2);
        m1.setCoef(0, 0, 3);
        m1.setCoef(0, 1, 4);
        m1.setCoef(1, 0, 5);
        m1.setCoef(1, 1, 6);

        //Matrice 2
        Matrice m2 = new Matrice(2, 2);
        m2.setCoef(0, 0, 2);
        m2.setCoef(0, 1, 2);
        m2.setCoef(1, 0, 2);
        m2.setCoef(1, 1, 2);

        //Test Opérations matrice
        System.out.println(matriceAddition(m1, m2));
        System.out.println(matriceSoustraction(m1, m2));
        System.out.println(matriceProduct(m1, m2));
        System.out.println(matriceDivision(m1, m2));

        System.out.println("\n-----------------------------\n");

        //Vecteur 1
        MVecteur mv1 = new MVecteur(3);
        mv1.setCoef(0, 1);
        mv1.setCoef(1, 2);
        mv1.setCoef(2, 3);

        //Vecteur 2
        MVecteur mv2 = new MVecteur(3);
        mv2.setCoef(0, 2);
        mv2.setCoef(1, 2);
        mv2.setCoef(2, 2);

        //Vecteur 3
        MVecteur mv3 = new MVecteur(2);
        mv3.setCoef(0, 2);
        mv3.setCoef(1, 2);

        //Test Opération vecteurs
        System.out.println(add(mv1, mv2));
        System.out.println(productVector(mv1, mv2));
        System.out.println(productScalVector(3.5, mv1));
        System.out.println(produitMatColVec(m1, mv3));


    }

}

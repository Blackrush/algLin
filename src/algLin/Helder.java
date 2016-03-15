package algLin;

public class Helder extends SysLin {
    Matrice L, D, R;

    public Helder(Matrice m1, MVecteur v1) throws IrregularSysLinException {
        super(m1, v1);

        int n = m1.nbLignes();
        L = new Matrice(n, n);
        D = new Matrice(n, n);
        R = new Matrice(n, n);
    }

    public void factorLDR() {
        final Matrice A = getMatriceSystem();
        final int n = A.nbLignes();

        int acc, i, j, k;

        for (i = 0; i < n; i++) {
            for (j = 0; j < (i - 1); j++) {
                acc = 0;
                for (k = 0; k < (j - 1); k++) {
                    acc += L.getCoef(i, k) * D.getCoef(k, k) * R.getCoef(k, j);
                }
                L.setCoef(i, j, (A.getCoef(i, j) - acc) / D.getCoef(j, j));
            }

            acc = 0;
            for (k = 0; k < (i - 1); k++) {
                acc += L.getCoef(i, k) * D.getCoef(k, k) * R.getCoef(k, j);
            }
            D.setCoef(i, i, A.getCoef(i, i) - acc);

            for (j = i + 1; j < n; j++) {
                acc = 0;
                for (k = 0; k < (i - 1); k++) {
                    acc += L.getCoef(i, k) * D.getCoef(k, k) * R.getCoef(k, j);
                }
                R.setCoef(i, j, (A.getCoef(i, j) - acc) / D.getCoef(i, i));
            }
        }
    }

    public MVecteur resolutionPartielle() throws IrregularSysLinException {
        return null;
    }

    @Override
    public MVecteur resolution() throws IrregularSysLinException {
        factorLDR();
        return resolutionPartielle();
    }

    public static void main(String[] args) throws IrregularSysLinException {
        Helder h0 = new Helder(new Matrice("files/MatDiago.txt"), new MVecteur("files/vec1.txt"));
        System.out.println(h0.resolution());

        //---------------------------------------------------------------------------------------//

        Helder h1 = new Helder(new Matrice("files/MatDiago.txt"), new MVecteur("files/vec1.txt"));
        h1.factorLDR();
        System.out.println(h1.resolutionPartielle());
    }
}

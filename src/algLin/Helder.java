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
        Matrice A = getMatriceSystem();
        int n = A.nbLignes();
        double acc;

        for (int i = 0; i < n; i++) {
            L.setCoef(i,i, 1.0);
            R.setCoef(i,i, 1.0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                acc = 0;
                for (int k = 0; k < j; k++) {
                    acc += L.getCoef(i,k) * D.getCoef(k,k) * R.getCoef(k,j);
                }
                L.setCoef(i,j, (A.getCoef(i,j) - acc) / D.getCoef(j,j));
            }

            acc = 0;
            for (int k = 0; k < i + 1; k++) {
                acc += L.getCoef(i, k) * D.getCoef(k, k) * R.getCoef(k, i);
            }
            D.setCoef(i, i, A.getCoef(i,i) - acc);

            for (int j = i; j < n; j++) {
                acc = 0;
                for (int k = 0; k < i; k++) {
                    acc += L.getCoef(i,k) * D.getCoef(k,k) * R.getCoef(k,j);
                }
                R.setCoef(i,j, (A.getCoef(i,j) - acc) / D.getCoef(i,i));
            }
        }
    }

    /**
     * For a Ax=b linear resolution system, take A & b in input, and ouput x
     * @param A square matrix
     * @param b vector
     * @return resolved vector
     */
    private static MVecteur resolve(Matrice A, MVecteur b) {
        throw new RuntimeException("not implemented");
    }

    public MVecteur resolutionPartielle() throws IrregularSysLinException {
        return resolve(R, resolve(D, resolve(L, getSecondMembre())));
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

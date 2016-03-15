package algLin;

public class SysDiagonal extends SysLin {

    public SysDiagonal(Matrice m1, MVecteur v1) throws IrregularSysLinException {
        super(m1, v1);
    }

    public MVecteur resolution() throws IrregularSysLinException {
        MVecteur vRetour = new MVecteur(this.getOrdre());
        for (int i = 0; i < this.getOrdre(); i++) {
            if (this.getMatriceSystem().getCoef(i, i) == 0) {
                throw new IrregularSysLinException("La matrice contient un 0 sur sa diagonale");
            }
            vRetour.setCoef(i, (this.getSecondMembre().getCoef(i) / this.getMatriceSystem().getCoef(i, i)));
        }
        return vRetour;
    }

    public static void main(String[] a) {
        Matrice mat = new Matrice("files/MatDiago.txt");
        MVecteur vect = new MVecteur("files/vec1.txt");

        try {
            SysDiagonal sD = new SysDiagonal(mat, vect);
            System.out.println(sD.resolution());
        } catch (IrregularSysLinException x) {
            System.out.println(x);
        }
    }
}
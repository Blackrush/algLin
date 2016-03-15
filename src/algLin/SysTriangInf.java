package algLin;

public class SysTriangInf extends SysLin {

    public SysTriangInf(Matrice m1, MVecteur v1) throws IrregularSysLinException {
        super(m1, v1);
    }

    public MVecteur resolution() throws IrregularSysLinException {
        MVecteur retour = new MVecteur(getSecondMembre().dim());
        for (int i = 0; i < retour.dim(); i++) {
            double s = 0;
            for (int j = 0; j < i; j++) {
                s += getMatriceSystem().getCoef(i, j) * retour.getCoef(j);
            }
            double a = getMatriceSystem().getCoef(i, i);
            double b = getSecondMembre().getCoef(i);
            double x = (b - s) / a;
            retour.setCoef(i, x);
        }
        return retour;
    }
}

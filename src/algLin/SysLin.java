package algLin;

public abstract class SysLin {
    public static final double eps = 1e-7;

    protected int ordre;
    protected Matrice matriceSystem;
    protected MVecteur secondMembre;

    public SysLin(Matrice m1, MVecteur v1) throws IrregularSysLinException {
        this.matriceSystem = m1;
        this.secondMembre = v1;

        this.ordre = m1.nbLignes();
    }

    public int getOrdre() {
        return ordre;
    }

    public Matrice getMatriceSystem() {
        return matriceSystem;
    }

    public MVecteur getSecondMembre() {
        return secondMembre;
    }

    abstract public MVecteur resolution() throws IrregularSysLinException;
}
	
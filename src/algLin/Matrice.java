package algLin;

import java.util.*;
import java.io.*;

public class Matrice {

    private double[][] coef;     //pour stocker les coefficients d'une matrice

    /**
     * Construit une matrice aux dimensions des paramètres
     * param dim1 premiere dimension de la matrice
     * param dim2 deuxieme dimension de la matrice
     */
    public Matrice(int dim1, int dim2) {
        coef = new double[dim1][dim2];
    }


    /**
     * pour contruire une matrice dont les coefficients correspondent au paramètre tableau
     * param tableau
     */
    public Matrice(double tableau[][]) {
        coef = new double[tableau.length][tableau[0].length];

        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[0].length; j++) {
                coef[i][j] = tableau[i][j];
            }
        }
    }


    /**
     * pour construire une matrice à partir d'un nom de fichier texte.
     * On utilisera un objet de la classe Scanner. On s'inspirera de la classe analogue écrite pour la 	classe Mvecteur.
     */
    public Matrice(String nomFichier) {
        try {
            Scanner sc = new Scanner(new File(nomFichier));
            sc.useLocale(Locale.US);
            int dim1 = sc.nextInt();
            int dim2 = sc.nextInt();
            coef = new double[dim1][dim2];
            for (int i = 0; i < dim1; i++) {
                for (int j = 0; j < dim2; j++) {
                    coef[i][j] = sc.nextDouble();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("fichier inexistant");
        }
    }

    /**
     * pour renvoyer le nombre de lignes de la matrice ;
     */
    public int nbLignes() {
        return coef.length;
    }

    /**
     * pour renvoyer le nombre de colonne de la matrice ;
     */
    public int nbColonnes() {
        return coef[0].length;
    }

    /**
     * : pour renvoyer le coefficient (i,j) à la ligne i et à la colonne j ;
     */
    public double getCoef(int i, int j) {
        return coef[i][j];
    }

    /**
     * pour changer la valeur du coefficient (i,j) par x ;
     */
    public void setCoef(int i, int j, double x) {
        this.coef[i][j] = x;
    }

    /**
     * pour renvoyer un contenu affichable de la matrice
     */
    public String toString() {

        String s = "";
        for (int i = 0; i < coef.length; i++) {
            for (int j = 0; j < coef[0].length; j++) {
                s += coef[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * pour recopier la matrice paramètre dans un nouveau tableau qui devra être alloué avec une
     * recopie des éléments un par un (on ne fera pas une simple copie de l'adresse
     * du tableau, ce qui reviendrait à affecter le nom du tableau des coefficients à un autre nom).
     */
    public void recopier(Matrice m) {
        coef = new double[m.nbLignes()][m.nbColonnes()];

        for (int i = 0; i < coef.length; i++) {
            for (int j = 0; j < coef[0].length; j++) {
                coef[i][j] = m.getCoef(i, j);
            }
        }


    }

    public boolean equals(Matrice other) {
        if (other.nbColonnes() != this.nbColonnes() || other.nbLignes() != this.nbLignes()) {
            return false;
        }

        for (int i = 0; i < nbLignes(); i++) {
            for (int j = 0; j < nbColonnes(); j++) {
                if (Math.abs(other.getCoef(i, j) - this.getCoef(i, j)) > SysLin.eps) {
                    return false;
                }
            }
        }

        return true;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != getClass()) return false;
        return equals((Matrice) obj);
    }

    /**
     * pour implémenter un programme principal qui sert de
     * programme de test de la classe
     */
    public static void main(String[] args) {
        //Code
        Matrice mat1 = new Matrice(2, 2);
        double[][] tableau = new double[2][2];
        Matrice mat2 = new Matrice(tableau);
        int nbLignes = mat1.nbLignes();
        int nbColonnes = mat2.nbColonnes();
        double coef = mat1.getCoef(1, 1);


        System.out.println("Matrice 1 : \n" + mat1.toString());
        System.out.println("Matrice 2 : \n" + mat2.toString());
        mat2.setCoef(1, 1, 20.0);
        System.out.println("nb lignes : " + nbLignes);
        System.out.println("nb colonne : " + nbColonnes);
        System.out.println("Matrice 2 : \n" + mat2.toString());
    }
}


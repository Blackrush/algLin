package algLin;

import java.util.*;
import java.io.*;

/**
 * Cette classe permet de représenter des vecteurs contenant
 * des coefficients réels (double)
 *
 * @author Cyrille Bertelle
 */
public class MVecteur {

    private double[] coef;

    /**
     * Construit un vecteur d'une taille donnée,
     * sans donner de valeur à ses coefficients
     *
     * @param dim taille du vecteur
     */
    public MVecteur(int dim) {
        coef = new double[dim];
    }

    /**
     * Construit un vecteur à partir d'un tableau de double
     *
     * @param tableau tableau des coefficients du vecteur
     */
    public MVecteur(double tableau[]) {
        coef = tableau;
    }

    /**
     * Construit un vecteur à partir d'un nom de fichier texte.
     * Le fichier texte est ouvert puis lu.
     * Le fichier texte contient d'abord la taille du vecteur,
     * puis tous ses coefficients au format décimal (exemple: 5.6).<br>
     * Par exemple, le fichier "vec.txt" sera de la forme<br>
     * 3<br>
     * 1.2   7.5   8.3
     *
     * @param nomFichier nom du fichier contenant la taille et les coefficients du vecteur
     */
    public MVecteur(String nomFichier) {
        try {
            Scanner sc = new Scanner(new File(nomFichier));
            sc.useLocale(Locale.US);
            int ndim = sc.nextInt();
            coef = new double[ndim];
            for (int i = 0; i < ndim; i++)
                coef[i] = sc.nextDouble();
        } catch (FileNotFoundException e) {
            System.out.println("fichier inexistant");
        }
    }

    /**
     * Construit un vecteur à partir d'un objet Scanner representant un fichier texte.
     * Le fichier texte est donc supposé déjà ouvert.
     * On lira d'abord la taille du vecteur,
     * puis tous ses coefficients au format décimal (exemple: 5.6).<br>
     * Par exemple, le fichier "vec.txt" sera de la forme<br>
     * 3<br>
     * 1.2   7.5   8.3
     *
     * @param sc object de la classe Scanner où est lu le vecteur
     */
    public MVecteur(Scanner sc) {
        int ndim = sc.nextInt();
        coef = new double[ndim];
        for (int i = 0; i < ndim; i++)
            coef[i] = sc.nextDouble();
    }


    /**
     * Renvoie la taille du vecteur
     *
     * @return nombre de coefficients du vecteur
     */
    public int dim() {
        return coef.length;
    }

    /**
     * Renvoie la valeur d'un coefficient du vecteur
     *
     * @param i index du coefficient à renvoyer
     * @return valeur du coefficient à la position i
     */
    public double getCoef(int i) {
        return coef[i];
    }

    /**
     * Modifie la valeur d'un coefficient du vecteur
     *
     * @param i index du coefficient à modifier
     * @param x valeur à affecter au coefficient
     */
    public void setCoef(int i, double x) {
        coef[i] = x;
    }

    /**
     * Surcharge de la méthode standard qui permet d'afficher le vecteur
     * dans une chaine de caratère. <br>
     * Typiquement dans une instruction du type <br>
     * <code>System.out.println("le vecteur vaut : "+x);</code><br>
     * si x est un MVecteur.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < dim(); i++) {
            s += getCoef(i) + ", ";
        }
        return s;
    }

    public static void main(String[] args) {

        double[] xtab = {1.0, 4.0, 2.0};
        MVecteur x1 = new MVecteur(xtab);
        System.out.println("Vecteur x1 :\n" + x1);

        // Saisie du vecteur au clavier avec la classe Scanner
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Donner la taille du vecteur :");
        MVecteur x2 = new MVecteur(sc.nextInt());
        System.out.println("Saisir les " + x2.dim() + " coefficients du vecteur");
        for (int i = 0; i < x2.dim(); i++)
            x2.setCoef(i, sc.nextDouble());
        System.out.println("Vecteur x2 :\n" + x2);

        // Saisie à partir d'un fichier
        MVecteur x3 = new MVecteur("vec1.txt");
        System.out.println("Vecteur x3 :\n" + x3);
    }

}

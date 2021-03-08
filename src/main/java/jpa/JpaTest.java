package jpa;

import Dao.FicheDao;
import Dao.SectionDao;
import Dao.TableauDao;
import Dao.UtilisateurDao;
import domain.Fiche;
import domain.Section;
import domain.Tableau;
import domain.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class JpaTest {

    UtilisateurDao uDao = new UtilisateurDao();
    FicheDao fDao = new FicheDao();
    SectionDao sDao = new SectionDao();
    TableauDao tableauDao=new TableauDao();

    public JpaTest() {
    }

    /**
     * Le main pour créer des instances et pouvoir les afficher
     * @param args
     */
    public static void main(String[] args) {

        JpaTest test = new JpaTest();
        //test.createUtilisateur();
        test.createSection();
        test.createFiche();
        test.createTableau();
        test.listUtilisateur();
        test.listSection();
        test.listFiche();


    }

    /**
     * Création des instances de Sections
     */
    public void createSection() {
        Section s1 = new Section("en attente");
        Section s2 = new Section("en cours");
        Section s3 = new Section("réalisé");
        sDao.save(s1);
        sDao.save(s2);
        sDao.save(s3);
    }
    public void createTableau() {
        Tableau t1 = new Tableau("Tableau1");
        Tableau t2 = new Tableau("Tableau2");
        Tableau t3 = new Tableau("Tableau3");
        tableauDao.save(t1);
        tableauDao.save(t2);
        tableauDao.save(t3);
    }

    /**
     * création des instances d'utilisateur
     */
    public void createUtilisateur() {
        //Création d'utilisateur
        //u1
        Utilisateur u1 = new Utilisateur();
        u1.setCodeUser("u1");
        u1.setNom("BOTON");
        u1.setPrenom("Olive");
        u1.setEmail("boton@gmail.com");
        uDao.save(u1);
        //u2
        Utilisateur u2 = new Utilisateur();
        u2.setCodeUser("u2");
        u2.setNom("GIROU");
        u2.setPrenom("Olivier");
        u2.setEmail("girou@gmail.com");
        uDao.save(u2);
        //u3
        Utilisateur u3 = new Utilisateur();
        u3.setCodeUser("u3");
        u3.setNom("MACHADI");
        u3.setPrenom("Anwar");
        u3.setEmail("anwar@gmail.com");
        uDao.save(u3);


    }

    /**
     * Création des instances de fiche
     */
    public void createFiche() {

        //Création d'utilisateur u
        //
        Utilisateur u4 = new Utilisateur();
        u4.setCodeUser("u");
        u4.setNom("Victor");
        u4.setPrenom("Hugo");
        u4.setEmail("victor@gmail.com");


        //Enregistrement fiche
        SimpleDateFormat formatDat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
        //Fiche 1
        Fiche f1 = new Fiche();
        try {
            f1.setDateButoire(formatDat.parse("07-02-2021"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        f1.setDelai(20);
        f1.setLibelle("Fiche 1");
        f1.setLieu("Ville jean");
        f1.setUrl("http:/www.toto.com");
        f1.setNoteExplicative("Backup cfg file-Cisco");
        f1.setUtilisateur(u4);

        uDao.save(u4);
        fDao.save(f1);
        Fiche f2 = new Fiche();
        try {
            f2.setDateButoire(formatDat.parse("07-02-2021"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        f2.setDelai(20);
        f2.setLibelle("Fiche 2");
        f2.setLieu("Ville jean");
        f2.setUrl("http:/www.momo.com");
        f2.setNoteExplicative("Creation d'un module");
        f2.setUtilisateur(u4);

    }

    /**
     * Affichage des instance de section créées
     */
    public void listSection() {
        System.out.println("Liste des Sections:");
        for (Section s : sDao.findAll()) {
            System.out.println(s.getLibelle());
        }

    }

    /**
     * Affichage des instance d'utilisateurs créés
     */
    public void listUtilisateur() {
        System.out.println("Liste de tous les utilisateu:");
        for (Utilisateur u : uDao.findAll()) {
           // System.out.println(u.getCodeUser() + " " + u.getNom() + " " + u.getPrenom() + " " + u.getEmail());
            System.out.println(u.toString());
        }

    }

    /**
     * Affichage de la liste des fiches présente dans la base de données
     */
    public void listFiche() {

        System.out.println("Liste de toutes les fiches:");
        for (Fiche f : fDao.findAll()) {
            System.out.println(f.getLibelle() + "| " + f.getNoteExplicative() + "|" + f.getDelai() + " | " + f.getLieu() + "| " + f.getUrl() + " |" + f.getUtilisateur().getCodeUser());
        }
    }

}

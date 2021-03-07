package jpa;

import Dao.FicheDao;
import Dao.SectionDao;
import Dao.UtilisateurDao;
import domain.Fiche;
import domain.Section;
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

    public JpaTest() {
    }

    /**
     * Le main pour créer des instances et pouvoir les afficher
     * @param args
     */
    public static void main(String[] args) {

        JpaTest test = new JpaTest();
        test.createUtilisateur();
        test.createSection();
        test.createFiche();
        test.listUtilisateur();
        test.listSection();
        test.listFiche();

    }

    /**
     * Création des instances de Sections
     */
    public void createSection() {
        //Création d'utilisateur u
        //u1
        Section s1 = new Section("en attente");
        Section s2 = new Section("en cours");
        Section s3 = new Section("réalisé");
        sDao.save(s1);
        sDao.save(s2);
        sDao.save(s3);
    }

    /**
     * création des instances d'utilisateur
     */
    public void createUtilisateur() {
        UtilisateurDao uDao = new UtilisateurDao();
        //Création d'utilisateur u
        //u1
        Utilisateur u1 = new Utilisateur();
        u1.setCode("u1");
        u1.setNom("BOTON");
        u1.setPrenom("Olive");
        u1.setEmail("boton@gmail.com");
        uDao.save(u1);
        //u2
        Utilisateur u2 = new Utilisateur();
        u2.setCode("u2");
        u2.setNom("GIROU");
        u2.setPrenom("Olive");
        u2.setEmail("boton@gmail.com");
        uDao.save(u2);
        //u3
        Utilisateur u3 = new Utilisateur();
        u3.setCode("u3");
        u3.setNom("MACHADI");
        u3.setPrenom("Anwar");
        u3.setEmail("boton@gmail.com");
        uDao.save(u3);


    }

    /**
     * Création des instances de fiche
     */
    public void createFiche() {

        //Création d'utilisateur u
        //u1
        Utilisateur u1 = new Utilisateur();
        u1.setCode("u1");
        u1.setNom("BOTON");
        u1.setPrenom("Olive");
        u1.setEmail("boton@gmail.com");
        uDao.save(u1);

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
        f1.setUtilisateur(u1);
        f1.setUtilisateur(u1);
        fDao.save(f1);

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
            System.out.println(u.getCode() + " " + u.getNom() + " " + u.getPrenom() + " " + u.getEmail());

        }

    }

    /**
     * Affichage de la liste des fiches présente dans la base de données
     */
    public void listFiche() {

        System.out.println("Liste de toutes les fiches:");
        for (Fiche f : fDao.findAll()) {
            System.out.println(f.getLibelle() + "| " + f.getNoteExplicative() + "|" + f.getDelai() + " | " + f.getLieu() + "| " + f.getUrl() + " |" + f.getUtilisateur().getCode());
        }
    }

}

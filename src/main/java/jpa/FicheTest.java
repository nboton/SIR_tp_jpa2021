package jpa;

import Dao.FicheDao;
import Dao.UtilisateurDao;
import domain.Fiche;
import domain.Utilisateur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FicheTest {
    public static void main(String[] args) throws ParseException {
        UtilisateurDao uDao = new UtilisateurDao();
        FicheDao fDao = new FicheDao();
        //Création d'utilisateur u
        //u1
        Utilisateur u1 = new Utilisateur();
        u1.setCode("u1");
        u1.setNom("BOTON");
        u1.setPrenom("Olive");
        u1.setEmail("boton@gmail.com");
        uDao.save(u1);

        //Enregistrement fiche
        SimpleDateFormat formatDat=new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
        //Fiche 1
        Fiche f1 = new Fiche();
        f1.setDateButoire(formatDat.parse("07-02-2021"));
        f1.setDelai(20);
        f1.setLibelle("Fiche 1");
        f1.setLieu("Ville jean");
        f1.setUrl("http:/www.toto.com");
        f1.setNoteExplicative("Backup cfg file-Cisco");
        f1.setUtilisateur(u1);
        f1.setUtilisateur(u1);
        fDao.save(f1);


        System.out.println("Liste de toutes les fiches:");
        for (Fiche f : fDao.findAll())
            System.out.println(f.getLibelle()+"| "+f.getNoteExplicative()+"|"+ f.getDelai()+" | "+f.getLieu()+"| "+f.getUrl()+" |"+f.getUtilisateur().getCode());



    }
}

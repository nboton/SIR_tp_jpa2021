package jpa;

import Dao.SectionDao;
import Dao.UtilisateurDao;
import domain.Section;
import domain.Utilisateur;

public class SectionTest {
    public static void main(String[] args) {
       SectionDao sDao = new SectionDao();
        //Création d'utilisateur u
        //u1
        Section s1 = new Section("en attente");
        Section s2 = new Section("en cours");
        Section s3 = new Section("réalisé");
        sDao.save(s1);
        sDao.save(s2);
        sDao.save(s3);

        System.out.println("Liste de tous les utilisateu:");
        for (Section s : sDao.findAll())
            System.out.println(s.getLibelle());

    }
}

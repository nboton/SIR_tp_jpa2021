package jpa;

import Dao.UtilisateurDao;
import domain.Utilisateur;

public class UtilisateurTest {
    public static void main(String[] args) {
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


        System.out.println("Liste de tous les utilisateu:");
        for (Utilisateur u : uDao.findAll())
            System.out.println(u.getCode()+" "+u.getNom()+" "+ u.getPrenom()+" "+u.getEmail());

        System.out.println("Liste des utilisateurs dont le prenom est nadh");
        for (Utilisateur u : uDao.findByFirstname("Olive"))
            System.out.println(u.getCode()+"| "+u.getNom()+"| "+ u.getPrenom()+"| "+u.getEmail());



    }
}

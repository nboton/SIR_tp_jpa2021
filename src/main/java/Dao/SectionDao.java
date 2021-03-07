package Dao;

import domain.Fiche;
import domain.Section;
import jpa.EntityManagerHelper;

import java.util.List;

public class SectionDao {
    public Section save(Section s ){
        EntityManagerHelper.beginTransaction();
        int number = EntityManagerHelper.getEntityManager().createQuery("Select a From Section a", Section.class).getResultList().size();
        if (number != 0) {
            EntityManagerHelper.getEntityManager().merge(s);

        } else {
            EntityManagerHelper.getEntityManager().persist(s);

        }
        EntityManagerHelper.commit();
        return s;

    }

    public void delete(String id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();
    }
    public Section findById(String id) {
        return EntityManagerHelper.getEntityManager().find(Section.class, id);

    }

    public List<Section> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select s from Section as s", Section.class)
                .getResultList();
    }

}

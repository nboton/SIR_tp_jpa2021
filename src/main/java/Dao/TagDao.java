package Dao;

import domain.Tableau;
import domain.Tag;
import jpa.EntityManagerHelper;

import java.util.List;

public class TagDao {
    public Tag save(Tag t ){
        EntityManagerHelper.beginTransaction();
        int number = EntityManagerHelper.getEntityManager().createQuery("Select a From Tag a", Tag.class).getResultList().size();
        if (number != 0) {
            EntityManagerHelper.getEntityManager().merge(t);

        } else {
            EntityManagerHelper.getEntityManager().persist(t);

        }
        EntityManagerHelper.commit();
        return t;

    }

    public void delete(String id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();
    }
    public Tag findById(String id) {
        return EntityManagerHelper.getEntityManager().find(Tag.class, id);

    }

    public List<Tag> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select t from Tag as t", Tag.class)
                .getResultList();
    }
}

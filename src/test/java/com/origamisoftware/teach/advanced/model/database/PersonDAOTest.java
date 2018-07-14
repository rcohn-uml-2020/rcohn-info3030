package com.origamisoftware.teach.advanced.model.database;

import com.origamisoftware.teach.advanced.util.LiveUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Verify the PersonDAO class
 */
public class PersonDAOTest extends AbstractBaseDAOTest {

    @Test
    public void testRead() {
        PersonDAO personDAO = LiveUtils.findUniqueResultBy("id", 1, PersonDAO.class, true);
        assertTrue("first PersonDAO found", personDAO.getId() == 1);
    }

    @Test
    public void testWrite() throws Exception {
        Session session = LiveUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PersonDAO personDAO = new PersonDAO();
        personDAO.setUserName("spencer");
        session.saveOrUpdate(personDAO);
        transaction.commit();
    }


}

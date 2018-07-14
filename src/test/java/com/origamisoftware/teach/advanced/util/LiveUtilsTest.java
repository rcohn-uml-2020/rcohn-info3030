package com.origamisoftware.teach.advanced.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *  Tests for the LiveUtils class
 */
public class LiveUtilsTest {

    @Test
    public void testGoodInitFile() throws Exception {
        LiveUtils.initializeDatabase(LiveUtils.initializationFile);
    }

    @Test
    public void testGetSessionFactory() throws Exception {
        SessionFactory sessionFactory = LiveUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }
    @Test(expected = LiveInitializationException.class)
    public void testBadInitFile() throws Exception {
        LiveUtils.initializeDatabase("bogus");
    }

    @Test
    public void testGetConnection() throws Exception{
        Connection connection = LiveUtils.getConnection();
        assertNotNull("verify that we can get a connection ok",connection);
    }

    @Test
    public void testGetConnectionWorks() throws Exception{
        Connection connection = LiveUtils.getConnection();
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("select * from quote");
        assertTrue("verify that we can execute a statement against quote table",execute);
        execute = statement.execute("select * from person");
        assertTrue("verify that we can execute a statement against person table",execute);
        execute = statement.execute("select * from stock_symbol");
        assertTrue("verify that we can execute a statement against stock_symbol table",execute);
        execute = statement.execute("select * from person_stocks");
        assertTrue("verify that we can execute a statement against person_stocks table",execute);

    }

}

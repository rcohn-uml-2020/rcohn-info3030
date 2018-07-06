package com.origamisoftware.teach.advanced.util;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *  Tests for the DatabaseUtils class
 */
public class DatabaseUtilsTest {
    
    @InjectMocks
    private DBConnection dbConnection;
    
    @Mock
    private Connection mockConnection;
    
    @Mock
    private Statement mockStatement;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    

    @Test
    public void testGetConnection() throws Exception{
        connection = DatabaseUtils.getConnection();
        assertNotNull("verify that we can get a connection ok",connection);
    }

    @Test
    public void testGetConnectionWorks() throws Exception{
        connection = DatabaseUtils.getConnection();
        statement = connection.createStatement();
        boolean execute = statement.execute("select * from quotes");
        assertTrue("verify that we can execute a statement",execute);
    }
}

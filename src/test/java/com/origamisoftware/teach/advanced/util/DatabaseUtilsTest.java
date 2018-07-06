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
    private DatabaseUtils dbUtils;
    
    @Mock
    private Connection mockConnection;
    
    @Mock
    private Statement mockStatement;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockGetConnection() throws Exception{
        assertNotNull("verify that we can get a connection ok", mockConnection);
    }

    @Test
    public void testMockGetConnectionWorks() throws Exception{
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
        assertTrue("verify that we can execute a statement",execute);
    }
}

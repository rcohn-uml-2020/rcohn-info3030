package com.origamisoftware.teach.advanced.model.database;

import com.origamisoftware.teach.advanced.util.LiveInitializationException;
import com.origamisoftware.teach.advanced.util.LiveUtils;
import org.junit.After;
import org.junit.Before;

/**
 * Base class that handles common setup and tear down task for DAO test classes.
 *
 * NOTE: package scope because only only DAO tests should extend from this class.
 *
 */
class AbstractBaseDAOTest {

    @Before
    public void setUp() throws LiveInitializationException {
        LiveUtils.initializeDatabase(LiveUtils.initializationFile);
    }

    @After
    public void tearDown() throws LiveInitializationException {
        LiveUtils.initializeDatabase(LiveUtils.initializationFile);
    }
}

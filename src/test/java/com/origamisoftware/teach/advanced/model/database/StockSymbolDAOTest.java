package com.origamisoftware.teach.advanced.model.database;

import com.origamisoftware.teach.advanced.util.LiveUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *  Verify the stockSymbolDAO class
 */
public class StockSymbolDAOTest extends AbstractBaseDAOTest {

    @Test
    public void testRead() {
        StockSymbolDAO stockSymbolDAO = LiveUtils.findUniqueResultBy("symbol", "APPL",
                StockSymbolDAO.class, true);
        assertTrue("APPL StockSymbolDAO found", stockSymbolDAO.getId() == 1);
    }


}

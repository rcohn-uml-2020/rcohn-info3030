package com.origamisoftware.teach.advanced.model.database;

import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *  Verify the stockSymbolDAO class
 */
public class StockSymbolDAOTest extends AbstractBaseDAOTest {

    @Test
    public void testRead() {
        StockSymbolDAO stockSymbolDAO = DatabaseUtils.findUniqueResultBy("symbol", "APPL",
                StockSymbolDAO.class, true);
        assertThat(stockSymbolDAO.getId(), is(equalTo(5)));
    }

}

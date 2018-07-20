package com.origamisoftware.teach.advanced.model.database;

import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *  Verify the QuoteDAO class
 */
public class QuoteDAOTest extends AbstractBaseDAOTest {

    @Test
    public void testRead() {
        QuoteDAO quoteDAO = DatabaseUtils.findUniqueResultBy("id", 1, QuoteDAO.class, true);
        assertThat( quoteDAO.getId(), is(equalTo(1)));
    }


}

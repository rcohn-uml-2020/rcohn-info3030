package com.origamisoftware.teach.advanced.model;

import java.text.SimpleDateFormat;

/**
 * Abstract Base class for classes that hold Person data.
 * Provides common code for such classes including date formatting.
 */
abstract class PersonData {

    /**
     * Provide a single SimpleDateFormat for consistency
     * and to avoid duplicated code.
     */
    SimpleDateFormat simpleDateFormat;

    /**
     * Base constructor for PersonData classes.
     * Initialize member data that is shared with sub classes.
     */
    StockData() {
        simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    }

}

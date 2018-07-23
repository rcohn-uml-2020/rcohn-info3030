package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockData;
import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.LiveInitializationException;
import com.origamisoftware.teach.advanced.util.Interval;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the LiveStockService
 */
public class LiveStockServiceTest {

   @Test
    public void testGetQuote() {
        String symbol = "APPL";
        StockQuote stockQuote = LiveStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }

    @Test
    public void testGetQuoteWithIntervalBasic() throws Exception {
        String symbol = "GOOG";
        String fromStringDate = "2000-02-10 00:00:01";
        String untilStringDate = "2015-02-03 00:00:01";

        Calendar fromCalendar = makeCalendarFromString(fromStringDate);
        Calendar untilCalendar = makeCalendarFromString(untilStringDate);

        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar, Interval.DAY);

        assertFalse("verify stock quotes where returned", stockQuotes.isEmpty());
    }

    /**
     * Handy dandy helper method that converts Strings in the format of   StockData.dateFormat
     * to Calendar instances set to the date expressed in the string.
     *
     * @param dateString a data and time in this format: StockData.dateFormat
     * @return a calendar instance set to the time in the string.
     * @throws ParseException if the string is not in the correct format, we can't tell what
     *                        time it is, and therefore can't make a calender set to that time.
     */
    private Calendar makeCalendarFromString(String dateString) throws ParseException {
        DateFormat format = new SimpleDateFormat(StockData.dateFormat, Locale.ENGLISH);
        Date date = format.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

}

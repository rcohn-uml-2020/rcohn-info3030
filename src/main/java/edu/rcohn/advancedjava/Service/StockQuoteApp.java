/**
 * @author rcohn
 * @version %I%, %G%
 */

package edu.rcohn.advancedjava.Service;

import edu.rcohn.advancedjava.Model.StockQuote;
import java.util.*;

/**
 *  the application that uses all of the <code>StockQuote</code> services
 */

public class StockQuoteApp {

    public static void main(String[] args){
        StockServiceFactory factory = new StockServiceFactory();

        StockService service = factory.create();

        GregorianCalendar today = new GregorianCalendar();

        GregorianCalendar earlier = (GregorianCalendar) today.clone();

        earlier.add(Calendar.DAY_OF_MONTH, -8);

        StockQuote quoteToday = service.getQuote("AAPL");

        List <StockQuote> quotePeriod = service.getQuote("AAPL", earlier, today);

        System.out.print(quoteToday);

        System.out.print("\n");

        System.out.print(quotePeriod);

        System.out.print("\n\n");

        earlier = (GregorianCalendar) today.clone();

        earlier.add(Calendar.MONTH, -8);

        quotePeriod = service.getQuote("AAPL", earlier, today, Interval.QUARTER);

        System.out.print(quotePeriod);

        System.out.print("\n");
    }

}

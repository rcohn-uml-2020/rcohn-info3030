/**
 * @author rcohn
 * @version %I%, %G%
 */

package edu.rcohn.advancedjava.Service;

/**
 * The class that creates a <code>BasicStockService</code> for use in the program.
 */


class StockServiceFactory {

        /**
         *
         * @return a new <code>BasicStockService</code>
         */

        StockService create() {return new BasicStockService(); }
}

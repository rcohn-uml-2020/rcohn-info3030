package com.origamisoftware.teach.advanced.util;

import com.origamisoftware.teach.advanced.xml.Stocks;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for XML utils.
 */
public class XMLUtilsTest {

    private static String xmlStocks = "xml/stock_info.xml";

    @Test
    public void testUnmarshall() throws Exception {
        Stocks stocks = XMLUtils.unmarshal(xmlStocks, Stocks.class);
        validateStocks(stocks);
    }

    @Test
    public void testUnmarshallWithSchemaValidation()throws Exception {
        Stocks stocks = XMLUtils.unmarshal(xmlStocks, Stocks.class, "/xml/stocks_info.xsd");
        validateStocks(stocks);
    }

    @Test
    public void testMarshall() throws Exception {
        Stocks stocks = XMLUtils.unmarshal(xmlStocks, Stocks.class, "/xml/stocks_info.xsd");
        String xml = XMLUtils.marshal(stocks);
        // input xml should be the same as output xml
        assertThat(xml.trim(), is(xmlStocks.trim()));
    }

    private void validateStocks(Stocks stocks) {
        assertThat("Father name is correct", stocks.getFather().getContent().equals(FATHERS_NAME));
        assertThat("Mother name is correct", stocks.getMother().getContent().equals(MOTHERS__NAME));
        assertThat("There are three kids", stocks.getKids().getChild().size() == 3);
    }

}

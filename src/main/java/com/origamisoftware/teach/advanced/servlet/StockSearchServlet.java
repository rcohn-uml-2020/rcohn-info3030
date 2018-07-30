package com.origamisoftware.teach.advanced.servlet;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.services.StockService;
import com.origamisoftware.teach.advanced.services.StockServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Simple Example of how a servlet can access form submission data
 * and act on it accordingly.
 */
public class StockSearchServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();

         /* Here is where use put an instance of Mood in the session.
          * The HTTP session contains a Map (it stores key value pairs)
          * You can put anything you like in that map.
          * When the session terminates the map goes away.
          *
          * You can also store key / values in the request.
          * However, those values will only be around for the duration of the
          * request and not the entire session.
          *
          */

        StockService stockService = ServiceFactory.getStockService();

        StockQuote stockquote = null;

        try{stockquote = stockService.getQuote("AAPL");} catch (StockServiceException e) {e.getMessage();}

        session.setAttribute("stockquote", stockquote);

        /* here is how a servlet can 'forward' to a specific JSP page
         * NOTE: you could easily have conditional code here that
         * directed to different pages based on values or business rules
         * related to the data this servlet is processing.
         *
         * e.g

          RequestDispatcher dispatcher;
          if (mood.getHappy()) {
             dispatcher = getServletContext().getRequestDispatcher("/goodMood.jsp");
          } else if (mood.getSad()) {
             dispatcher = getServletContext().getRequestDispatcher("/sadMood.jsp");
          } else {
             dispatcher = getServletContext().getRequestDispatcher("/confusedMood.jsp");
          }

         * However, in this example we only dispatch to one place the stockquoteResults.jsp page
         *
         */

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher =
                servletContext.getRequestDispatcher("/stockquoteResults.jsp");
        dispatcher.forward(request, response);

    }
}

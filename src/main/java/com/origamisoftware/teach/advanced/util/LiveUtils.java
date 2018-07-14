package com.origamisoftware.teach.advanced.util;

import java.util.List;

/**
 * A class that contains database related utility methods.
 */
public class LiveUtils {

    /**
     * @return a connection to the DBMS which is used for DBMS
     * @throws LiveConnectionException if a connection cannot be made.
     */
    public static Connection getConnection() throws LiveConnectionException {
        Connection connection = null;
        try {
            Class.forName(getPropFromConfig(JDBC_DRIVER_CLASS_PROPERTY_KEY));
            connection = DriverManager.getConnection(getPropFromConfig(DATABASE_URL),
                    getPropFromConfig(DATABASE_USER_NAME),
                    getPropFromConfig(DATABASE_USER_PASSWORD));
            // an example of throwing an exception appropriate to the abstraction.
        } catch (ClassNotFoundException | SQLException e) {
            String message = e.getMessage();
            throw new LiveConnectionException("Could not connection to database." + message, e);
        }
        return connection;
    }

    /**
     * A utility method that runs a db initialize script.
     *
     * @param initializationScript full path to the script to run to create the schema
     * @throws LiveInitializationException
     */
    public static void initializeDatabase(String initializationScript) throws LiveInitializationException {

        Connection connection = null;
        final StringBuilder errorLog = new StringBuilder();
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ScriptRunner runner = new ScriptRunner(connection, false, false);
            InputStream inputStream = new FileInputStream(initializationScript);

            InputStreamReader reader = new InputStreamReader(inputStream);

            runner.setErrorLogWriter(new PrintWriter(new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    errorLog.append((char) b);
                }
            }));
            runner.runScript(reader);

            reader.close();
            connection.commit();
            connection.close();

        } catch (LiveConnectionException | SQLException | IOException e) {
            throw new LiveInitializationException("Could not initialize db because of:"
                    + e.getMessage(), e);
        }
        // improvement - previous versions would not single errors in the SQL itself.
        if (errorLog.length() != 0) {
            throw new LiveInitializationException("SQL init script contained errors:" + errorLog.toString());


        }
    }

    /**
     * Execute SQL code
     *
     * @param someSQL the code to execute
     * @return true if the operation succeeded.
     * @throws LiveException if accessing and executing the sql failed in an unexpected way.
     */
    public static boolean executeSQL(String someSQL) throws LiveException {
        Connection connection = null;
        boolean returnValue = false;
        try {
            connection = LiveUtils.getConnection();
            Statement statement = connection.createStatement();
            returnValue = statement.execute(someSQL);
        } catch (LiveConnectionException | SQLException e) {
            throw new LiveException(e.getMessage(), e);
        }
        return returnValue;
    }


    /*
   * @return SessionFactory for use with database transactions
   */
    public static SessionFactory getSessionFactory() {

        // singleton pattern
        synchronized (LiveUtils.class) {
            if (sessionFactory == null) {

                Configuration configuration = getConfiguration();

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }
        }
        return sessionFactory;
    }

    /**
     * A generic finder method where the caller specifies the
     * property to match as a <CODE>String</CODE> and its value as an arbitrary <CODE>Object</CODE>
     * A specific entity will be returned as a domain model or null not entities matching
     * the search criteria are found.
     * <p/>
     * NOTE: the caller is responsible for closing the transaction.
     * This allows collections that are lazily initialized to read after calling this method.
     *
     * @param property          a member of the class that represents the column being search in.
     * @param value             the value that is being match against in the column
     * @param <T>               a class that implements DatabasesAccessObject
     * @param handleTransaction true, if this method should open and close transaction false
     *                          if calling code will be responsible for transaction management
     * @return an instance of T or NULL
     * if no value was found matching the criteria.
     */
    @SuppressWarnings("unchecked")  // API requires unchecked OK per guidelines
    public static <T extends DatabasesAccessObject> T findUniqueResultBy(String property,
                                                                         Object value,
                                                                         Class T,
                                                                         boolean handleTransaction) {
        T returnValue = null;
        Session session = null;
        try {
            Transaction transaction = null;
            session = getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(T);
            criteria = criteria.add(Restrictions.eq(property, value));

            returnValue = (T) criteria.uniqueResult();
            if (handleTransaction) {
                transaction.commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return returnValue;
    }

    /**
     * A generic finder  method where the caller specifies the
     * property to match as a <CODE>String</CODE> and its value as an <CODE>Object</CODE> which
     * contains that value.
     * <p/>
     * A list of the specified entity will be returned as a domain model or an empty list if no
     * entities matching the search criteria are found.
     * <p/>
     * NOTE: the caller is responsible for closing the transaction if handleTransaction is false.
     * This allows collections that are lazily initialized to read after calling this method.
     * <p/>
     *
     * @param property          a member of the class that represents the column being search in.
     * @param value             the value that is being match against in the column
     * @param <T>               a class that implements DatabasesAccessObject
     * @param handleTransaction true, if this method should open and close transaction false
     *                          if calling code will be responsible for transaction management
     * @return a list of type <T> objects
     * if no value was found matching the criteria.
     */
    @SuppressWarnings("unchecked")  // API requires unchecked OK per guidelines
    public static <T extends DatabasesAccessObject> List<T> findResultsBy(String property,
                                                                          Object value,
                                                                          Class T,
                                                                          boolean handleTransaction) {
        Session session = null;
        List<T> returnValue;
        try {
            Transaction transaction = null;
            session = getSessionFactory().openSession();
            if (handleTransaction) {
                transaction = session.beginTransaction();
            }
            Criteria criteria = session.createCriteria(T);
            criteria = criteria.add(Restrictions.eq(property, value));
            returnValue = (List<T>) criteria.list();
            if (handleTransaction) {
                transaction.commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return returnValue;
    }


}

package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The purpose of Connector is to create a connection to the SQL Database Server
 *
 * @author Gert Lehmann Madsen
 */
public class Connector {

    private static final String url = "jdbc:mysql://138.197.189.73:3306/lego";
    private static final String username = "legouser";
    private static final String password = "#lego!hus&bab!106#gplm#";

    private static Connection singleton;

    public static Connection connection() throws ClassNotFoundException, SQLException  {
        if ( singleton == null || singleton.isClosed()) {
            Class.forName( "com.mysql.jdbc.Driver" );
            singleton = DriverManager.getConnection( url, username, password );
        }
        return singleton;
    }

}

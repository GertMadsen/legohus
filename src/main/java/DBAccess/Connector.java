package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

    private static final String url = "jdbc:mysql://46.101.253.149:3306/useradmin";
    private static final String username = "doorkeeper";
    private static final String password = "bank3*andyouarein";

    private static Connection singleton;

    public static Connection connection() throws ClassNotFoundException, SQLException  {
        if ( singleton == null || singleton.isClosed()) {
            Class.forName( "com.mysql.jdbc.Driver" );
            singleton = DriverManager.getConnection( url, username, password );
        }
        return singleton;
    }

}

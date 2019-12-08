
package dao;

import java.sql.Connection;
import util.Connector;

public class AbstractDAO {

    private Connector connector;
    private Connection connection;

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }

}

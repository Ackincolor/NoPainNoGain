package Utils;
/*
 * @author lois Guillet-andre
 */
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
/*
 * An object that provides hooks for connection pool management. 
 * A PooledConnection object represents a physical connection to a data source. 
 * The connection can be recycled rather than being closed when an application is finished with it, thus reducing the number of connections that need to be made.
 * The list of connection can be stored in a ArrayList object 
 */
public interface PoolConnexion extends ConnectionEventListener {
	/*
	 * returns a Connection object that is a handle for the physical connection that this PooledConnection object represents.
	 */
	public Connection getConnexion() throws SQLException;
	/*
	 * Close the Used connection 
	 */
	public void close() throws SQLException;
	/*
	 * listen the connection for closing
	 * @param event Connection object to listen
	 */
	@Override
	public void connectionClosed(ConnectionEvent event);
	/*
	 * listen the connection for error
	 * @param event Connection object to listen
	 */
	@Override
	public void connectionErrorOccurred(ConnectionEvent event);
	
}

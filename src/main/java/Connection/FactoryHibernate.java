package Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Model.Favorite;
import Model.Share;
import Model.User;
import Model.Video;

import java.util.Properties;
public class FactoryHibernate {
	
	 private static final SessionFactory FACTORY;

	    static {
	        Configuration configuration = new Configuration();

	        Properties properties = new Properties();
	        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
	        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/assign");
	        properties.put(Environment.USER, "root");
	        properties.put(Environment.PASS, "10112002");
	        properties.put(Environment.SHOW_SQL, "true");

	        configuration.setProperties(properties);
	        configuration.addAnnotatedClass(User.class);
	        configuration.addAnnotatedClass(Video.class);
	        configuration.addAnnotatedClass(Favorite.class);
	        configuration.addAnnotatedClass(Share.class);
	        
	        
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties()).build();

	        FACTORY = configuration.buildSessionFactory(serviceRegistry);
	    }

	    public static SessionFactory getFACTORY() {
	        return FACTORY;
	    }
}

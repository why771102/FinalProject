package com.root.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class RootAppConfig {
	
	@Bean
	public DataSource dataSource() {			//建立連線用的基本資訊，會提供給factory製作session工廠
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setUser("sa");
		ds.setPassword("P@ssw0rd");
		
		try {
			ds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=JSPDB");
		ds.setInitialPoolSize(4);
		ds.setMaxPoolSize(8);
		return ds;
	}
	
	@Bean						//製作sesstionFactory，其他DAO要用的時候直接AutoWired即可
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] {
				"com.web.store.model"
		});
		factory.setHibernateProperties(additionalProperties());
		return factory;
	}
	
	@Bean(name="transactionManager")
	@Autowired									//使用sessionFactory製作交易管理器
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	
	
	private Properties additionalProperties() {			//設定factory用的屬性值
		Properties properties = new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServer2012Dialect.class);
		properties.put("hibernate.show_sql", Boolean.TRUE);
		properties.put("hibernate.format_sql", Boolean.TRUE);
		properties.put("default_batch_fecth_size", 10);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

}

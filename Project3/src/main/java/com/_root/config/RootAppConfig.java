package com._root.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class RootAppConfig {
	
	
	@Value("${spring.database.initialPoolSize}")
	int ips;

	@Value("${spring.database.maxPoolSize}")
	int mps;
	
	Environment env;
	
	@Autowired
	public void setEnv(Environment env) {
		this.env = env;
	}
	
	@Bean
	public DataSource dataSource() {			//建立連線用的基本資訊，會提供給factory製作session工廠
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setUser(env.getProperty("spring.database.user"));
		ds.setPassword(env.getProperty("spring.database.password"));
		
		try {
			ds.setDriverClass(env.getProperty("spring.database.driverclass"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl(env.getProperty("spring.database.url"));
		ds.setInitialPoolSize(ips);
		ds.setMaxPoolSize(mps);
		return ds;
	}
	
	@Bean						//製作sessionFactory，其他DAO要用的時候直接AutoWired即可
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] {
				"com.c.model",
				"com.a.model",
				"com.l.model",
				"com.p.model",
				"com.m.model",
				"com.z.model",
				"com.t.model"		
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

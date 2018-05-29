package my.pinkyo.demo;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Configuration
@MapperScan(value = "my.pinkyo.demo.mapper")
public class DemoConfiguration {
    @Autowired DataSource dataSource;

    static {
        LogFactory.useLog4JLogging();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPlugins(new Interceptor[]{new PageHelper()}); // set Pagination support.
        return sessionFactory.getObject();
    }

    @Bean
    JettyEmbeddedServletContainerFactory factory() {
        JettyEmbeddedServletContainerFactory factory =
                new JettyEmbeddedServletContainerFactory();
        factory.setThreadPool(new ExecutorThreadPool(
                50, 200, 15, TimeUnit.MINUTES));
        return factory;
    }
}

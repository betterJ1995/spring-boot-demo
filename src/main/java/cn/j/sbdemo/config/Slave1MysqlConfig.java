package cn.j.sbdemo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author J
 * @time 2018/10/1 14:28
 * @description 从数据源配置
 **/
@Configuration
@MapperScan(basePackages = "cn.j.sbdemo.db1", sqlSessionTemplateRef = "slave1SST")
public class Slave1MysqlConfig {

    @Bean(name = "slave1DataSource")
    @ConfigurationProperties(prefix = "slave1.datasource")
    public DataSource slave1DataSource() {
        //如是用了第三方的连接池 直接new 一个对应的对象返回即可
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "slave1SSF")
    public SqlSessionFactory slave1SqlSessionFactory(@Qualifier("slave1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //定义dao xml文件扫描地址
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper_db1/*.xml"));
        return bean.getObject();
    }

    //配置声明式事务管理器
    @Bean(name = "slave1TM")
    public PlatformTransactionManager slave1TransactionManager(@Qualifier("slave1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slave1SST")
    public SqlSessionTemplate slave1SqlSessionTemplate(
            @Qualifier("slave1SSF") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

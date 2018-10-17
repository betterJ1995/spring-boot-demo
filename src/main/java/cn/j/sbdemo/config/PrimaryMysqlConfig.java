package cn.j.sbdemo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author J
 * @time 2018/10/1 14:28
 * @description 主数据源配置
 **/
@Configuration
// 注意 这里的MapperScan 是tk.mapper的 不是mybatis的
@MapperScan(basePackages = "cn.j.sbdemo.sys", sqlSessionTemplateRef = "primarySST")
public class PrimaryMysqlConfig {


    @Bean(name = "primaryDataSource")
    @Primary // 定义主数据源
    @ConfigurationProperties(prefix = "primary.datasource")
    public DataSource primaryDataSource() {
        //如是用了第三方的连接池 可以直接new 一个对应的对象返回
        //也可以调用对应的builder
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "primarySSF")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //定义dao xml文件扫描地址
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper-demo-db/*.xml"));
        return bean.getObject();
    }

    //配置声明式事务管理器
    @Bean(name = "primaryTM")
    @Primary
    public PlatformTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "primarySST")
    public SqlSessionTemplate primarySqlSessionTemplate(
            @Qualifier("primarySSF") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

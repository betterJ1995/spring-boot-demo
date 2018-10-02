package cn.j.sbdemo.core.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author J
 * @time 2018/10/1 14:28
 * @description 主数据源配置
 **/
@Configuration
@MapperScan(basePackages = "cn.j.sbdemo.db2", sqlSessionTemplateRef = "slave2SST")
public class Slave2MysqlConfig {

    @Bean(name = "slave2DataSource")
    @ConfigurationProperties(prefix = "slave2.datasource")
    public DataSource slave2DataSource() {
        //如是用了第三方的连接池 直接new 一个对应的对象返回即可
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "slave2SSF")
    public SqlSessionFactory slave2SqlSessionFactory(@Qualifier("slave2DataSource") DataSource dataSource, @Qualifier("defaultGlobalConfig") GlobalConfig globalConfig)
            throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setGlobalConfig(globalConfig);

        //定义dao xml文件扫描地址
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper_db2/*.xml"));
        return bean.getObject();
    }

    //配置声明式事务管理器
    @Bean(name = "slave2TM")
    public PlatformTransactionManager slave2TransactionManager(@Qualifier("slave2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slave2SST")
    public SqlSessionTemplate slave2SqlSessionTemplate(
            @Qualifier("slave2SSF") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

package generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author kochun
 * @Description mybatis-plus代码生成器
 * @Date 2019/8/19 9:29
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://127.0.0.1/kochun-weixin?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
            .setUrl(dbUrl)
            .setUsername("root")
            .setPassword("root")
            .setDriverName("com.mysql.cj.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
            //.setInclude()//设置需要导出的表，多个表用逗号分隔
            .setCapitalMode(true)
            //这里结合了Lombok，所以设置为true，如果没有集成Lombok，可以设置为false
            .setEntityLombokModel(true)
            .setNaming(NamingStrategy.underline_to_camel);
        //这里因为我是多模块项目，所以需要加上子模块的名称，以便直接生成到该目录下，如果是单模块项目，可以将后面的去掉
        String projectPath = System.getProperty("user.dir") + "/viboot-mybatis-plus";
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/mapper/" + "user"
                    + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);

        //设置作者，输出路径，是否重写等属性
        config.setActiveRecord(false)
            .setEnableCache(false)
            .setAuthor("kochun")
            .setOutputDir(projectPath + "/src/main/java")
            .setFileOverride(true)
            .setServiceName("%sService");
        new AutoGenerator()
            .setGlobalConfig(config)
            .setDataSource(dataSourceConfig)
            .setStrategy(strategyConfig)
            .setTemplateEngine(new FreemarkerTemplateEngine())
            .setCfg(cfg)
            //这里进行包名的设置
            .setPackageInfo(
                new PackageConfig()
                    .setParent("com.kochun.wxmp.core")
                    .setController("controller")
                    .setEntity("entity")
                    .setMapper("mapper")
                    .setServiceImpl("service.impl")
                    .setService("service")
            ).execute();
    }

}

package com.aek.mybatis;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成
 */
public class Generator {
	/**
	 * 测试 run 执行
	 * <p>
	 * 配置方法查看
	 * </p>
	 */
	public static void main(String[] args) {
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("D://gencode");
		gc.setFileOverride(false);
		gc.setActiveRecord(false);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		gc.setAuthor("aek");
		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		 gc.setMapperName("%sMapper");
		 gc.setXmlName("%sMapper");
		 gc.setServiceName("%sService");
		 gc.setServiceImplName("%sServiceImpl");
		 gc.setControllerName("%sController");
		mpg.setGlobalConfig(gc);
		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("Aek56.com");
		dsc.setUrl("jdbc:mysql://192.168.1.135:3306/repair2_dev?characterEncoding=utf8");
		mpg.setDataSource(dsc);
		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
//		strategy.setTablePrefix("sys_");// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		 strategy.setInclude(new String[] { "rep_turn_orders" }); // 需要生成的表
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表
		// 字段名生成策略
		//strategy.setFieldNaming(NamingStrategy.underline_to_camel);
		// 自定义实体父类
		 strategy.setSuperEntityClass("com.aek.common.core.base.BaseModel");
		// 自定义实体，公共字段
		// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
		// 自定义 mapper 父类
		 strategy.setSuperMapperClass("com.aek.common.core.base.BaseMapper");
		// 自定义 service 父类
		 strategy.setSuperServiceClass("com.aek.common.core.base.BaseService");
		// 自定义 service 实现类父类
		 strategy.setSuperServiceImplClass("com.aek.common.core.base.BaseServiceImpl");
		// 自定义 controller 父类
		 strategy.setSuperControllerClass("com.aek.common.core.base.BaseController");
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuliderModel(true);
		mpg.setStrategy(strategy);
		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.aek.ebey");
		pc.setModuleName("repair");
		pc.setEntity("model");
		pc.setController("web.controller");
		mpg.setPackageInfo(pc);
		// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};
		mpg.setCfg(cfg);
		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
		// 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
		// TemplateConfig tc = new TemplateConfig();
		// tc.setController("...");
		// tc.setEntity("...");
		// tc.setMapper("...");
		// tc.setXml("...");
		// tc.setService("...");
		// tc.setServiceImpl("...");
		// mpg.setTemplate(tc);
		// 执行生成
		mpg.execute();
		// 打印注入设置
		System.err.println(mpg.getCfg().getMap().get("abc"));
	}
}

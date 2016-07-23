package com.myproject.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driverClass = null;
	//下面在静态代码块中加载配置文件和注册驱动。因为static中一开始就加载且只加载一次。后面的代码可以用到这些已初始化的东西
	static{
		try{
			Properties props = new Properties();
			//获得输入流读取文件。为了以后能在Web应用环境下正确的加载该文件，需要使用类路径的读取方式。
			InputStream is = JdbcUtils.class.getResourceAsStream("db.properties");
			//在项目中，配置文件要和该类在一个目录下
			//因为在代码运行时，会自动将这个文件复制到该类字节码文件路径下，就是bin\包名目录下
			//每次执行都会复制一次，所以直接执行、修改再直接在项目执行是没问题的
			//如果是Web项目，则会复制到WEB-INF/classes目录下。
			props.load(is);
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			driverClass = props.getProperty("driverClass");
			//注册驱动程序
			Class.forName(driverClass);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		//InputStream对象不要关闭，否则会产生问题
	}
	//获取连接对象
	public static Connection getConnection(){
		try{
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	//释放资源(传入要释放的资源)
	public static void close(Connection conn,Statement stmt){
		if(conn!=null){
			try{
				conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		if(stmt!=null){
			try{
				stmt.close();
			}  
			catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
}

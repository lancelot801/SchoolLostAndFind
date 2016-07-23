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
	//�����ھ�̬������м��������ļ���ע����������Ϊstatic��һ��ʼ�ͼ�����ֻ����һ�Ρ�����Ĵ�������õ���Щ�ѳ�ʼ���Ķ���
	static{
		try{
			Properties props = new Properties();
			//�����������ȡ�ļ���Ϊ���Ժ�����WebӦ�û�������ȷ�ļ��ظ��ļ�����Ҫʹ����·���Ķ�ȡ��ʽ��
			InputStream is = JdbcUtils.class.getResourceAsStream("db.properties");
			//����Ŀ�У������ļ�Ҫ�͸�����һ��Ŀ¼��
			//��Ϊ�ڴ�������ʱ�����Զ�������ļ����Ƶ������ֽ����ļ�·���£�����bin\����Ŀ¼��
			//ÿ��ִ�ж��Ḵ��һ�Σ�����ֱ��ִ�С��޸���ֱ������Ŀִ����û�����
			//�����Web��Ŀ����Ḵ�Ƶ�WEB-INF/classesĿ¼�¡�
			props.load(is);
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			driverClass = props.getProperty("driverClass");
			//ע����������
			Class.forName(driverClass);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		//InputStream����Ҫ�رգ�������������
	}
	//��ȡ���Ӷ���
	public static Connection getConnection(){
		try{
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	//�ͷ���Դ(����Ҫ�ͷŵ���Դ)
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

/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContextEvent
 *  javax.servlet.ServletContextListener
 */
package com.zyh.maple.framework.listener;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.csource.fastdfs.ClientGlobal;

import com.zyh.maple.framework.commons.SysParams;
import com.zyh.maple.redis.impl.RedisGlobalConfig;

public class SystemListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		InputStream sysInput = SystemListener.class.getResourceAsStream("/conf/properties/sys.properties");
		InputStream sqlInput = SystemListener.class.getResourceAsStream("/conf/properties/sqlID.properties");
		try {
			try {
				String fdfsConfPath;
				SysParams.sysProps.load(sysInput);
				SysParams.sqlIDProps.load(sqlInput);
				String confPath = SystemListener.class.getResource(SysParams.sysProps.getProperty("redis.confFilePath"))
						.getFile();
				System.out.println("confPath = " + confPath);
				if (confPath != null) {
					RedisGlobalConfig.init(confPath);
				}
				if ((fdfsConfPath = SystemListener.class
						.getResource(SysParams.sysProps.getProperty("fdfs.confFilePath")).getFile()) != null) {
					ClientGlobal.init(fdfsConfPath);
				}
				System.out.println("\u7cfb\u7edf\u52a0\u8f7d\u5b8c\u6210\uff01\uff01\uff01\uff01");
			} catch (Exception e) {
				e.printStackTrace();
				try {
					sysInput.close();
					sqlInput.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		} finally {
			try {
				sysInput.close();
				sqlInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

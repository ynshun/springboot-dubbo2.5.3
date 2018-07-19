package com.ynshun.common.config.mybatis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ynshun.common.enums.DataSourceType;

/**
 * 本地线程，数据源上下文
 * 
 * @author ynshun
 * @since 2018年6月30日
 * @version 1.0
 */
public class DataSourceContextHolder {

	private static Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);
	
	// 线程本地环境
	private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读库
     * 
     * @since 2018年6月30日
     * @auth ynshun
     * @version 1.0
     */
	public static void setRead() {
        local.set(DataSourceType.read.getType());
        log.info("数据库切换到读库...");
    }

    /**
     * 写库
     * 
     * @since 2018年6月30日
     * @auth ynshun
     * @version 1.0
     */
    public static void setWrite() {
        local.set(DataSourceType.write.getType());
        log.info("数据库切换到写库...");
    }

    public static String getReadOrWrite() {
        return local.get();
    }
    
    public static void clear(){
    	local.remove();
    }
}
/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.redis.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import redis.clients.jedis.JedisShardInfo;

public class RedisGlobalConfig {
    private static HashMap masterConsistencyInfoListMap = null;
    private static HashMap slaveConsistencyInfoListMap = null;
    private static int maxActive = 500;
    private static int maxIdle = 100;
    private static int minIdle = 20;
    private static long maxWait = -1;
    private static int numTestsPerEvictionRun = -1;
    private static long timeBetweenEvictionRunsMillis = 30000;
    private static boolean testWhileIdle = true;
    private static long minEvictableIdleTimeMillis = 60000;
    private static boolean testOnBorrow = false;
    private static boolean testOnReturn = false;
    private static byte whenExhaustedAction = 1;
    private static long softMinEvictableIdleTimeMillis = -1;
    private static HashMap masterHostInfoMap = null;
    private static HashMap slaveHostInfoMap = null;
    private static HashMap slaveHostInfoListMap = null;
    private static String NOPASSWORD = "noPassword";
    private static String NONAME = "noName";
    private static int jedisPoolTimeout = 8000;

    private RedisGlobalConfig() {
    }

    public static void init(String conf_filename) throws Exception {
        String[] sServers;
        String[] slaveInfo;
        IniFileReader iniReader = new IniFileReader(conf_filename);
        maxActive = iniReader.getIntValue("maxActive", maxActive);
        maxIdle = iniReader.getIntValue("maxIdle", maxIdle);
        minIdle = iniReader.getIntValue("minIdle", minIdle);
        maxWait = iniReader.getLongValue("maxWait", maxWait);
        numTestsPerEvictionRun = iniReader.getIntValue("numTestsPerEvictionRun", numTestsPerEvictionRun);
        timeBetweenEvictionRunsMillis = iniReader.getLongValue("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis);
        testWhileIdle = iniReader.getBoolValue("testWhileIdle", testWhileIdle);
        minEvictableIdleTimeMillis = iniReader.getLongValue("minEvictableIdleTimeMillis", minEvictableIdleTimeMillis);
        testOnBorrow = iniReader.getBoolValue("testOnBorrow", testOnBorrow);
        testOnReturn = iniReader.getBoolValue("testOnReturn", testOnReturn);
        softMinEvictableIdleTimeMillis = iniReader.getLongValue("softMinEvictableIdleTimeMillis", softMinEvictableIdleTimeMillis);
        jedisPoolTimeout = iniReader.getIntValue("jedisPoolTimeout", jedisPoolTimeout);
        String[] masterInfo = iniReader.getValues("masterHostInfo");
        if (masterInfo != null) {
            masterHostInfoMap = RedisGlobalConfig.parseSingleHostInfo(masterInfo);
        }
        if ((slaveInfo = iniReader.getValues("slaveHostInfo")) != null) {
            slaveHostInfoMap = RedisGlobalConfig.parseSingleHostInfo(slaveInfo);
        }
        if ((sServers = iniReader.getValues("masterConsistencyInfo")) != null) {
            masterConsistencyInfoListMap = RedisGlobalConfig.parseHostInfo(sServers);
        }
        if ((sServers = iniReader.getValues("slaveConsistencyInfo")) != null) {
            slaveConsistencyInfoListMap = RedisGlobalConfig.parseHostInfo(sServers);
        }
        if ((sServers = iniReader.getValues("moreSlaveHostInfo")) != null) {
            slaveHostInfoListMap = RedisGlobalConfig.parseHostInfo(sServers);
        }
    }

    private static HashMap parseHostInfo(String[] sServers) throws Exception {
        HashMap<String, List> map = null;
        if (sServers != null) {
            map = new HashMap<String, List>();
            int i = 0;
            while (i < sServers.length) {
                String[] parts = sServers[i].split("\\:", 5);
                if (parts.length != 5) {
                    throw new Exception("the value of item \"host info\" is invalid, the correct format is hostIp:port:password:hostName:groupName");
                }
                JedisShardInfo jsi = null;
                jsi = NONAME.equals(parts[3].trim()) ? new JedisShardInfo(parts[0].trim(), Integer.parseInt(parts[1].trim()), parts[3].trim()) : new JedisShardInfo(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                if (!NOPASSWORD.equals(parts[2].trim())) {
                    jsi.setPassword(parts[2].trim());
                }
                jsi.setTimeout(jedisPoolTimeout);
                String groupName = parts[4].trim();
                List list = null;
                list = map.get(groupName) != null ? (List)map.get(groupName) : new ArrayList();
                list.add(jsi);
                map.put(groupName, list);
                ++i;
            }
        }
        return map;
    }

    private static HashMap parseSingleHostInfo(String[] sServers) throws Exception {
        HashMap<String, JedisShardInfo> map = null;
        if (sServers != null) {
            map = new HashMap<String, JedisShardInfo>();
            int i = 0;
            while (i < sServers.length) {
                String[] parts = sServers[i].split("\\:", 4);
                if (parts.length != 4) {
                    throw new Exception("the value of item \"host info\" is invalid, the correct format is hostIp:port:password:groupName");
                }
                JedisShardInfo jsi = new JedisShardInfo(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                if (!NOPASSWORD.equals(parts[2].trim())) {
                    jsi.setPassword(parts[2].trim());
                }
                jsi.setTimeout(jedisPoolTimeout);
                String groupName = parts[3].trim();
                map.put(groupName, jsi);
                ++i;
            }
        }
        return map;
    }

    public static int getMaxActive() {
        return maxActive;
    }

    public static void setMaxActive(int maxActive) {
        RedisGlobalConfig.maxActive = maxActive;
    }

    public static int getMaxIdle() {
        return maxIdle;
    }

    public static void setMaxIdle(int maxIdle) {
        RedisGlobalConfig.maxIdle = maxIdle;
    }

    public static int getMinIdle() {
        return minIdle;
    }

    public static void setMinIdle(int minIdle) {
        RedisGlobalConfig.minIdle = minIdle;
    }

    public static long getMaxWait() {
        return maxWait;
    }

    public static void setMaxWait(long maxWait) {
        RedisGlobalConfig.maxWait = maxWait;
    }

    public static int getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }

    public static void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
        RedisGlobalConfig.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }

    public static long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public static void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        RedisGlobalConfig.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public static boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public static void setTestWhileIdle(boolean testWhileIdle) {
        RedisGlobalConfig.testWhileIdle = testWhileIdle;
    }

    public static long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public static void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
        RedisGlobalConfig.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public static boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public static void setTestOnBorrow(boolean testOnBorrow) {
        RedisGlobalConfig.testOnBorrow = testOnBorrow;
    }

    public static boolean isTestOnReturn() {
        return testOnReturn;
    }

    public static void setTestOnReturn(boolean testOnReturn) {
        RedisGlobalConfig.testOnReturn = testOnReturn;
    }

    public static byte getWhenExhaustedAction() {
        return whenExhaustedAction;
    }

    public static void setWhenExhaustedAction(byte whenExhaustedAction) {
        RedisGlobalConfig.whenExhaustedAction = whenExhaustedAction;
    }

    public static long getSoftMinEvictableIdleTimeMillis() {
        return softMinEvictableIdleTimeMillis;
    }

    public static void setSoftMinEvictableIdleTimeMillis(long softMinEvictableIdleTimeMillis) {
        RedisGlobalConfig.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis;
    }

	public static HashMap getMasterConsistencyInfoListMap() {
        return masterConsistencyInfoListMap;
    }

    public static void setMasterConsistencyInfoListMap(HashMap masterConsistencyInfoListMap) {
        RedisGlobalConfig.masterConsistencyInfoListMap = masterConsistencyInfoListMap;
    }

    public static HashMap getSlaveConsistencyInfoListMap() {
        return slaveConsistencyInfoListMap;
    }

    public static void setSlaveConsistencyInfoListMap(HashMap slaveConsistencyInfoListMap) {
        RedisGlobalConfig.slaveConsistencyInfoListMap = slaveConsistencyInfoListMap;
    }

    public static HashMap getSlaveHostInfoListMap() {
        return slaveHostInfoListMap;
    }

    public static void setSlaveHostInfoListMap(HashMap slaveHostInfoListMap) {
        RedisGlobalConfig.slaveHostInfoListMap = slaveHostInfoListMap;
    }

    public static HashMap getMasterHostInfoMap() {
        return masterHostInfoMap;
    }

    public static void setMasterHostInfoMap(HashMap masterHostInfoMap) {
        RedisGlobalConfig.masterHostInfoMap = masterHostInfoMap;
    }

    public static HashMap getSlaveHostInfoMap() {
        return slaveHostInfoMap;
    }

    public static void setSlaveHostInfoMap(HashMap slaveHostInfoMap) {
        RedisGlobalConfig.slaveHostInfoMap = slaveHostInfoMap;
    }

    public static int getJedisPoolTimeout() {
        return jedisPoolTimeout;
    }

    public static void setJedisPoolTimeout(int jedisPoolTimeout) {
        RedisGlobalConfig.jedisPoolTimeout = jedisPoolTimeout;
    }
}


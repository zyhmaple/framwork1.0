/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.redis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.pool.impl.GenericObjectPool;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

public class YaoHuaJedisPool{
	private static YaoHuaJedisPool instance = null;
	private HashMap masterConsistencyPoolMap = null;
	private HashMap slaveConsistencyPoolMap = null;
	private HashMap masterJedisPoolMap = null;
	private HashMap slaveJedisPoolMap = null;
	private HashMap moreSlavePoolMap = null;

	private YaoHuaJedisPool() {
		HashMap map;
		JedisPool jpool;
		JedisShardInfo jsi;
		ShardedJedisPool shardPool;
		String groupName;
		GenericObjectPool.Config conf = new GenericObjectPool.Config();
		conf.maxActive = RedisGlobalConfig.getMaxActive();
		conf.maxIdle = RedisGlobalConfig.getMaxIdle();
		conf.minIdle = RedisGlobalConfig.getMinIdle();
		conf.maxWait = RedisGlobalConfig.getMaxWait();
		conf.numTestsPerEvictionRun = RedisGlobalConfig.getNumTestsPerEvictionRun();
		conf.timeBetweenEvictionRunsMillis = RedisGlobalConfig.getTimeBetweenEvictionRunsMillis();
		conf.testWhileIdle = RedisGlobalConfig.isTestWhileIdle();
		conf.minEvictableIdleTimeMillis = RedisGlobalConfig.getMinEvictableIdleTimeMillis();
		conf.testOnBorrow = RedisGlobalConfig.isTestOnBorrow();
		conf.testOnReturn = RedisGlobalConfig.isTestOnReturn();
		conf.whenExhaustedAction = RedisGlobalConfig.getWhenExhaustedAction();
		conf.softMinEvictableIdleTimeMillis = RedisGlobalConfig.getSoftMinEvictableIdleTimeMillis();
		if (RedisGlobalConfig.getMasterConsistencyInfoListMap() != null
				&& RedisGlobalConfig.getMasterConsistencyInfoListMap().size() > 0) {
			this.masterConsistencyPoolMap = new HashMap();
			map = RedisGlobalConfig.getMasterConsistencyInfoListMap();
			for (Map.Entry<String, List> m : ((HashMap<String, List>) map).entrySet()) {
				groupName = (String) m.getKey();
				shardPool = new ShardedJedisPool(conf, (List) m.getValue());
				this.masterConsistencyPoolMap.put(groupName, shardPool);
			}
		}
		if (RedisGlobalConfig.getSlaveConsistencyInfoListMap() != null
				&& RedisGlobalConfig.getSlaveConsistencyInfoListMap().size() > 0) {
			this.slaveConsistencyPoolMap = new HashMap();
			map = RedisGlobalConfig.getSlaveConsistencyInfoListMap();
			for (Map.Entry m : ((HashMap<String, List>) map).entrySet()) {
				groupName = (String) m.getKey();
				shardPool = new ShardedJedisPool(conf, (List) m.getValue());
				this.slaveConsistencyPoolMap.put(groupName, shardPool);
			}
		}
		if (RedisGlobalConfig.getSlaveHostInfoListMap() != null
				&& RedisGlobalConfig.getSlaveHostInfoListMap().size() > 0) {
			this.moreSlavePoolMap = new HashMap();
			map = RedisGlobalConfig.getSlaveHostInfoListMap();
			for (Map.Entry m : ((HashMap<String, List>) map).entrySet()) {
				groupName = (String) m.getKey();
				shardPool = new ShardedJedisPool(conf, (List) m.getValue());
				this.moreSlavePoolMap.put(groupName, shardPool);
			}
		}
		if (RedisGlobalConfig.getMasterHostInfoMap() != null && RedisGlobalConfig.getMasterHostInfoMap().size() > 0) {
			this.masterJedisPoolMap = new HashMap();
			map = RedisGlobalConfig.getMasterHostInfoMap();
			for (Map.Entry m : ((HashMap<String, List>) map).entrySet()) {
				groupName = (String) m.getKey();
				jsi = (JedisShardInfo) m.getValue();
				jpool = new JedisPool(conf, jsi.getHost(), jsi.getPort(), jsi.getTimeout(), jsi.getPassword());
				this.masterJedisPoolMap.put(groupName, jpool);
			}
		}
		if (RedisGlobalConfig.getSlaveHostInfoMap() != null && RedisGlobalConfig.getSlaveHostInfoMap().size() > 0) {
			this.slaveJedisPoolMap = new HashMap();
			map = RedisGlobalConfig.getSlaveHostInfoMap();
			for (Map.Entry m : ((HashMap<String, List>) map).entrySet()) {
				groupName = (String) m.getKey();
				jsi = (JedisShardInfo) m.getValue();
				jpool = new JedisPool(conf, jsi.getHost(), jsi.getPort(), jsi.getTimeout(), jsi.getPassword());
				this.slaveJedisPoolMap.put(groupName, jpool);
			}
		}
	}

	/*
	 * WARNING - Removed try catching itself - possible behaviour change.
	 * Enabled force condition propagation Lifted jumps to return sites
	 */
	public static YaoHuaJedisPool getInstance() {
		if (instance != null)
			return instance;
		Class<YaoHuaJedisPool> class_ = YaoHuaJedisPool.class;
		synchronized (YaoHuaJedisPool.class) {
			if (instance != null)
				return instance;
			{
				instance = new YaoHuaJedisPool();
			}
			// ** MonitorExit[var0] (shouldn't be in output)
			return instance;
		}
	}

	public HashMap getMasterConsistencyPoolMap() {
		return this.masterConsistencyPoolMap;
	}

	public void setMasterConsistencyPoolMap(HashMap masterConsistencyPoolMap) {
		this.masterConsistencyPoolMap = masterConsistencyPoolMap;
	}

	public HashMap getSlaveConsistencyPoolMap() {
		return this.slaveConsistencyPoolMap;
	}

	public void setSlaveConsistencyPoolMap(HashMap slaveConsistencyPoolMap) {
		this.slaveConsistencyPoolMap = slaveConsistencyPoolMap;
	}

	public HashMap getMasterJedisPoolMap() {
		return this.masterJedisPoolMap;
	}

	public void setMasterJedisPoolMap(HashMap masterJedisPoolMap) {
		this.masterJedisPoolMap = masterJedisPoolMap;
	}

	public HashMap getSlaveJedisPoolMap() {
		return this.slaveJedisPoolMap;
	}

	public void setSlaveJedisPoolMap(HashMap slaveJedisPoolMap) {
		this.slaveJedisPoolMap = slaveJedisPoolMap;
	}

	public HashMap getMoreSlavePoolMap() {
		return this.moreSlavePoolMap;
	}

	public void setMoreSlavePoolMap(HashMap moreSlavePoolMap) {
		this.moreSlavePoolMap = moreSlavePoolMap;
	}
}

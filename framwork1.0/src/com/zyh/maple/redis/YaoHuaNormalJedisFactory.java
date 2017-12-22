/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.redis;

import com.zyh.maple.redis.impl.YaoHuaNormalGeneralJedis;
import com.zyh.maple.redis.impl.YaoHuaNormalShardJedis;
import com.zyh.maple.redis.impl.*;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedisPool;

public class YaoHuaNormalJedisFactory {
	public YaoHuaNormalJedis createJedis(boolean isConsistencyHash, boolean isMoreSlave, boolean isMaster,
			String groupName) {
		if (isConsistencyHash) {
			if (isMaster) {
				return new YaoHuaNormalShardJedis(
						(ShardedJedisPool) YaoHuaJedisPool.getInstance().getMasterConsistencyPoolMap().get(groupName));
			}
			return new YaoHuaNormalShardJedis(
					(ShardedJedisPool) YaoHuaJedisPool.getInstance().getSlaveConsistencyPoolMap().get(groupName));
		}
		if (isMoreSlave) {
			return new YaoHuaNormalShardJedis(
					(ShardedJedisPool) YaoHuaJedisPool.getInstance().getMoreSlavePoolMap().get(groupName));
		}
		if (isMaster) {
			return new YaoHuaNormalGeneralJedis(
					(JedisPool) YaoHuaJedisPool.getInstance().getMasterJedisPoolMap().get(groupName));
		}
		return new YaoHuaNormalGeneralJedis(
				(JedisPool) YaoHuaJedisPool.getInstance().getSlaveJedisPoolMap().get(groupName));
	}
}

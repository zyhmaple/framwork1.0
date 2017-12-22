/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.redis.util;

import com.zyh.maple.redis.YaoHuaNormalJedis;
import com.zyh.maple.redis.YaoHuaNormalJedisFactory;

public class RedisUtil {
	private static YaoHuaNormalJedis getJedis(boolean isConsistencyHash, boolean isMoreSlave, boolean isMaster,
			String groupName) throws Exception {
		YaoHuaNormalJedisFactory xhnjf = new YaoHuaNormalJedisFactory();
		YaoHuaNormalJedis jedis = xhnjf.createJedis(isConsistencyHash, isMoreSlave, isMaster, groupName);
		return jedis;
	}

	public static YaoHuaNormalJedis getOneMasterNoSlaveJedis(String groupName) throws Exception {
		YaoHuaNormalJedisFactory xhnjf = new YaoHuaNormalJedisFactory();
		YaoHuaNormalJedis jedis = xhnjf.createJedis(false, false, true, groupName);
		return jedis;
	}

	public static YaoHuaNormalJedis getOneSlaveJedis(String groupName) throws Exception {
		YaoHuaNormalJedisFactory xhnjf = new YaoHuaNormalJedisFactory();
		YaoHuaNormalJedis jedis = xhnjf.createJedis(false, false, false, groupName);
		return jedis;
	}

	public static YaoHuaNormalJedis getMoreMasterNoSlaveJedis(String groupName) throws Exception {
		YaoHuaNormalJedisFactory xhnjf = new YaoHuaNormalJedisFactory();
		YaoHuaNormalJedis jedis = xhnjf.createJedis(true, false, true, groupName);
		return jedis;
	}

	public static YaoHuaNormalJedis getMoreSlaveReadByMoreMasterWriteJedis(String groupName) throws Exception {
		YaoHuaNormalJedisFactory xhnjf = new YaoHuaNormalJedisFactory();
		YaoHuaNormalJedis jedis = xhnjf.createJedis(true, false, false, groupName);
		return jedis;
	}

	public static YaoHuaNormalJedis getMoreSlaveReadByOneMasterWriteJedis(String groupName) throws Exception {
		YaoHuaNormalJedisFactory xhnjf = new YaoHuaNormalJedisFactory();
		YaoHuaNormalJedis jedis = xhnjf.createJedis(false, true, false, groupName);
		return jedis;
	}
}

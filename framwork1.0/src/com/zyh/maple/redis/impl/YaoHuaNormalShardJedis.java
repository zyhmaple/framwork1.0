/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.redis.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zyh.maple.redis.YaoHuaNormalJedis;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

public class YaoHuaNormalShardJedis implements YaoHuaNormalJedis {
	private ShardedJedisPool pool = null;

	public YaoHuaNormalShardJedis(ShardedJedisPool pool) {
		this.pool = pool;
	}

	@Override
	public String set(String key, String value) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.set(key, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String get(String key) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.get(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public /* varargs */ Long del(String... fields) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				String[] arrstring = fields;
				int n = arrstring.length;
				int n2 = 0;
				while (n2 < n) {
					String field = arrstring[n2];
					result = jedis.del(field);
					++n2;
				}
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Boolean exists(String key) throws Exception {
		Boolean result;
		ShardedJedis jedis = null;
		result = false;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.exists(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String type(String key) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.type(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long expire(String key, int seconds) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.expire(key, seconds);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long expireAt(String key, long unixTime) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.expireAt(key, unixTime);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long ttl(String key) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.ttl(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Boolean setbit(String key, long offset, boolean value) throws Exception {
		Boolean result;
		ShardedJedis jedis = null;
		result = false;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.setbit(key, offset, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Boolean getbit(String key, long offset) throws Exception {
		Boolean result;
		ShardedJedis jedis = null;
		result = false;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.getbit(key, offset);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long setrange(String key, long offset, String value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.setrange(key, offset, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String getrange(String key, long startOffset, long endOffset) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.getrange(key, startOffset, endOffset);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String getSet(String key, String value) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.getSet(key, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long setnx(String key, String value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.setnx(key, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String setex(String key, int seconds, String value) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.setex(key, seconds, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long decrBy(String key, long integer) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.decrBy(key, integer);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long decr(String key) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.decr(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long incrBy(String key, long integer) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.incrBy(key, integer);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long incr(String key) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.incr(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long append(String key, String value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.append(key, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String substr(String key, int start, int end) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.substr(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hset(String key, String field, String value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hset(key, field, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String hget(String key, String field) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hget(key, field);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hsetnx(String key, String field, String value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hsetnx(key, field, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String hmset(String key, Map<String, String> hash) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hmset(key, hash);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public /* varargs */ List<String> hmget(String key, String... fields) throws Exception {
		List<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hmget(key, fields);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hincrBy(String key, String field, long value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hincrBy(key, field, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Boolean hexists(String key, String field) throws Exception {
		Boolean result;
		ShardedJedis jedis = null;
		result = false;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hexists(key, field);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hdel(String key, String field) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hdel(key, field);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hlen(String key) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hlen(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<String> hkeys(String key) throws Exception {
		Set<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hkeys(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public List<String> hvals(String key) throws Exception {
		List<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hvals(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Map<String, String> hgetAll(String key) throws Exception {
		Map<String, String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hgetAll(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long rpush(String key, String string) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.rpush(key, string);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long lpush(String key, String string) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lpush(key, string);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long llen(String key) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.llen(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public List<String> lrange(String key, long start, long end) throws Exception {
		List<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lrange(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String ltrim(String key, long start, long end) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.ltrim(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String lindex(String key, long index) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lindex(key, index);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String lset(String key, long index, String value) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lset(key, index, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long lrem(String key, long count, String value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lrem(key, count, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String lpop(String key) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lpop(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String rpop(String key) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.rpop(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long sadd(String key, String member) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.sadd(key, member);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<String> smembers(String key) throws Exception {
		Set<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.smembers(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long srem(String key, String member) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.srem(key, member);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String spop(String key) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.spop(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long scard(String key) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.scard(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Boolean sismember(String key, String member) throws Exception {
		Boolean result;
		ShardedJedis jedis = null;
		result = false;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.sismember(key, member);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String srandmember(String key) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.srandmember(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long zadd(String key, double score, String member) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zadd(key, score, member);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<String> zrange(String key, int start, int end) throws Exception {
		Set<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrange(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long zrem(String key, String member) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrem(key, member);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Double zincrby(String key, double score, String member) throws Exception {
		Double result;
		ShardedJedis jedis = null;
		result = 0.0;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zincrby(key, score, member);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long zrank(String key, String member) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrank(key, member);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long zrevrank(String key, String member) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrevrank(key, member);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<String> zrevrange(String key, int start, int end) throws Exception {
		Set<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrevrange(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<Tuple> zrangeWithScores(String key, int start, int end) throws Exception {
		Set<Tuple> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrangeWithScores(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<Tuple> zrevrangeWithScores(String key, int start, int end) throws Exception {
		Set<Tuple> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrevrangeWithScores(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long zcard(String key) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zcard(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Double zscore(String key, String member) throws Exception {
		Double result;
		ShardedJedis jedis = null;
		result = 0.0;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zscore(key, member);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public List<String> sort(String key) throws Exception {
		List<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.sort(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public List<String> sort(String key, SortingParams sortingParameters) throws Exception {
		List<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.sort(key, sortingParameters);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long zcount(String key, double min, double max) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zcount(key, min, max);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<String> zrangeByScore(String key, double min, double max) throws Exception {
		Set<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrangeByScore(key, min, max);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min) throws Exception {
		Set<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrevrangeByScore(key, max, min);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) throws Exception {
		Set<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrangeByScore(key, min, max, offset, count);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) throws Exception {
		Set<String> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrevrangeByScore(key, max, min, offset, count);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) throws Exception {
		Set<Tuple> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrangeByScoreWithScores(key, min, max);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) throws Exception {
		Set<Tuple> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrevrangeByScoreWithScores(key, max, min);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count)
			throws Exception {
		Set<Tuple> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrangeByScoreWithScores(key, min, max, offset, count);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count)
			throws Exception {
		Set<Tuple> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long zremrangeByRank(String key, int start, int end) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zremrangeByRank(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long zremrangeByScore(String key, double start, double end) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.zremrangeByScore(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.linsert(key, where, pivot, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String set(byte[] key, byte[] value) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.set(key, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public byte[] get(byte[] key) throws Exception {
		byte[] result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.get(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long expire(byte[] key, int seconds) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.expire(key, seconds);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long expireAt(byte[] key, long unixTime) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.expireAt(key, unixTime);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hset(byte[] key, byte[] field, byte[] value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hset(key, field, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public byte[] hget(byte[] key, byte[] field) throws Exception {
		byte[] result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hget(key, field);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hsetnx(byte[] key, byte[] field, byte[] value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hsetnx(key, field, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String hmset(byte[] key, Map<byte[], byte[]> hash) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hmset(key, hash);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public /* varargs */ List<byte[]> hmget(byte[] key, byte[]... fields) throws Exception {
		List<byte[]> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hmget(key, fields);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hincrBy(byte[] key, byte[] field, long value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hincrBy(key, field, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Boolean hexists(byte[] key, byte[] field) throws Exception {
		Boolean result;
		ShardedJedis jedis = null;
		result = false;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hexists(key, field);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hdel(byte[] key, byte[] field) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hdel(key, field);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long hlen(byte[] key) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hlen(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Set<byte[]> hkeys(byte[] key) throws Exception {
		Set<byte[]> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hkeys(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public List<byte[]> hvals(byte[] key) throws Exception {
		Collection<byte[]> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hvals(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return (List<byte[]>) result;
	}

	@Override
	public Map<byte[], byte[]> hgetAll(byte[] key) throws Exception {
		Map<byte[], byte[]> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.hgetAll(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long rpush(byte[] key, byte[] string) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.rpush(key, string);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long lpush(byte[] key, byte[] string) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lpush(key, string);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long llen(byte[] key) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.llen(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public List<byte[]> lrange(byte[] key, int start, int end) throws Exception {
		List<byte[]> result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lrange(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String ltrim(byte[] key, int start, int end) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.ltrim(key, start, end);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public byte[] lindex(byte[] key, int index) throws Exception {
		byte[] result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lindex(key, index);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public String lset(byte[] key, int index, byte[] value) throws Exception {
		String result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lset(key, index, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public Long lrem(byte[] key, int count, byte[] value) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lrem(key, count, value);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public byte[] lpop(byte[] key) throws Exception {
		byte[] result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.lpop(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public byte[] rpop(byte[] key) throws Exception {
		byte[] result;
		ShardedJedis jedis = null;
		result = null;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				result = jedis.rpop(key);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public /* varargs */ Long del(byte[]... fields) throws Exception {
		Long result;
		ShardedJedis jedis = null;
		result = 0L;
		try {
			try {
				jedis = (ShardedJedis) this.pool.getResource();
				byte[][] arrby = fields;
				int n = arrby.length;
				int n2 = 0;
				while (n2 < n) {
					byte[] field = arrby[n2];
					result = jedis.del(new String(field));
					++n2;
				}
			} catch (Exception e) {
				throw new Exception(e);
			}
		} finally {
			if (jedis != null) {
				this.pool.returnResource(jedis);
			}
		}
		return result;
	}
}

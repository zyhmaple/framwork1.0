/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

public interface YaoHuaNormalJedis {
    public String set(String var1, String var2) throws Exception;

    public String get(String var1) throws Exception;

    public /* varargs */ Long del(String ... var1) throws Exception;

    public String set(byte[] var1, byte[] var2) throws Exception;

    public byte[] get(byte[] var1) throws Exception;

    public /* varargs */ Long del(byte[] ... var1) throws Exception;

    public Boolean exists(String var1) throws Exception;

    public String type(String var1) throws Exception;

    public Long expire(String var1, int var2) throws Exception;

    public Long expireAt(String var1, long var2) throws Exception;

    public Long expire(byte[] var1, int var2) throws Exception;

    public Long expireAt(byte[] var1, long var2) throws Exception;

    public Long ttl(String var1) throws Exception;

    public Boolean setbit(String var1, long var2, boolean var4) throws Exception;

    public Boolean getbit(String var1, long var2) throws Exception;

    public Long setrange(String var1, long var2, String var4) throws Exception;

    public String getrange(String var1, long var2, long var4) throws Exception;

    public String getSet(String var1, String var2) throws Exception;

    public Long setnx(String var1, String var2) throws Exception;

    public String setex(String var1, int var2, String var3) throws Exception;

    public Long decrBy(String var1, long var2) throws Exception;

    public Long decr(String var1) throws Exception;

    public Long incrBy(String var1, long var2) throws Exception;

    public Long incr(String var1) throws Exception;

    public Long append(String var1, String var2) throws Exception;

    public String substr(String var1, int var2, int var3) throws Exception;

    public Long hset(String var1, String var2, String var3) throws Exception;

    public String hget(String var1, String var2) throws Exception;

    public Long hsetnx(String var1, String var2, String var3) throws Exception;

    public String hmset(String var1, Map<String, String> var2) throws Exception;

    public /* varargs */ List<String> hmget(String var1, String ... var2) throws Exception;

    public Long hincrBy(String var1, String var2, long var3) throws Exception;

    public Boolean hexists(String var1, String var2) throws Exception;

    public Long hdel(String var1, String var2) throws Exception;

    public Long hlen(String var1) throws Exception;

    public Set<String> hkeys(String var1) throws Exception;

	public List<String> hvals(String var1) throws Exception;

    public Map<String, String> hgetAll(String var1) throws Exception;

    public Long hset(byte[] var1, byte[] var2, byte[] var3) throws Exception;

    public byte[] hget(byte[] var1, byte[] var2) throws Exception;

    public Long hsetnx(byte[] var1, byte[] var2, byte[] var3) throws Exception;

    public String hmset(byte[] var1, Map<byte[], byte[]> var2) throws Exception;

    public /* varargs */ List<byte[]> hmget(byte[] var1, byte[] ... var2) throws Exception;

    public Long hincrBy(byte[] var1, byte[] var2, long var3) throws Exception;

    public Boolean hexists(byte[] var1, byte[] var2) throws Exception;

    public Long hdel(byte[] var1, byte[] var2) throws Exception;

    public Long hlen(byte[] var1) throws Exception;

    public Set<byte[]> hkeys(byte[] var1) throws Exception;

    public List<byte[]> hvals(byte[] var1) throws Exception;

    public Map<byte[], byte[]> hgetAll(byte[] var1) throws Exception;

    public Long rpush(String var1, String var2) throws Exception;

    public Long lpush(String var1, String var2) throws Exception;

    public Long llen(String var1) throws Exception;

    public List<String> lrange(String var1, long var2, long var4) throws Exception;

    public String ltrim(String var1, long var2, long var4) throws Exception;

    public String lindex(String var1, long var2) throws Exception;

    public String lset(String var1, long var2, String var4) throws Exception;

    public Long lrem(String var1, long var2, String var4) throws Exception;

    public String lpop(String var1) throws Exception;

    public String rpop(String var1) throws Exception;

    public Long rpush(byte[] var1, byte[] var2) throws Exception;

    public Long lpush(byte[] var1, byte[] var2) throws Exception;

    public Long llen(byte[] var1) throws Exception;

    public List<byte[]> lrange(byte[] var1, int var2, int var3) throws Exception;

    public String ltrim(byte[] var1, int var2, int var3) throws Exception;

    public byte[] lindex(byte[] var1, int var2) throws Exception;

    public String lset(byte[] var1, int var2, byte[] var3) throws Exception;

    public Long lrem(byte[] var1, int var2, byte[] var3) throws Exception;

    public byte[] lpop(byte[] var1) throws Exception;

    public byte[] rpop(byte[] var1) throws Exception;

    public Long sadd(String var1, String var2) throws Exception;

    public Set<String> smembers(String var1) throws Exception;

    public Long srem(String var1, String var2) throws Exception;

    public String spop(String var1) throws Exception;

    public Long scard(String var1) throws Exception;

    public Boolean sismember(String var1, String var2) throws Exception;

    public String srandmember(String var1) throws Exception;

    public Long zadd(String var1, double var2, String var4) throws Exception;

    public Set<String> zrange(String var1, int var2, int var3) throws Exception;

    public Long zrem(String var1, String var2) throws Exception;

    public Double zincrby(String var1, double var2, String var4) throws Exception;

    public Long zrank(String var1, String var2) throws Exception;

    public Long zrevrank(String var1, String var2) throws Exception;

    public Set<String> zrevrange(String var1, int var2, int var3) throws Exception;

    public Set<Tuple> zrangeWithScores(String var1, int var2, int var3) throws Exception;

    public Set<Tuple> zrevrangeWithScores(String var1, int var2, int var3) throws Exception;

    public Long zcard(String var1) throws Exception;

    public Double zscore(String var1, String var2) throws Exception;

    public List<String> sort(String var1) throws Exception;

    public List<String> sort(String var1, SortingParams var2) throws Exception;

    public Long zcount(String var1, double var2, double var4) throws Exception;

    public Set<String> zrangeByScore(String var1, double var2, double var4) throws Exception;

    public Set<String> zrevrangeByScore(String var1, double var2, double var4) throws Exception;

    public Set<String> zrangeByScore(String var1, double var2, double var4, int var6, int var7) throws Exception;

    public Set<String> zrevrangeByScore(String var1, double var2, double var4, int var6, int var7) throws Exception;

    public Set<Tuple> zrangeByScoreWithScores(String var1, double var2, double var4) throws Exception;

    public Set<Tuple> zrevrangeByScoreWithScores(String var1, double var2, double var4) throws Exception;

    public Set<Tuple> zrangeByScoreWithScores(String var1, double var2, double var4, int var6, int var7) throws Exception;

    public Set<Tuple> zrevrangeByScoreWithScores(String var1, double var2, double var4, int var6, int var7) throws Exception;

    public Long zremrangeByRank(String var1, int var2, int var3) throws Exception;

    public Long zremrangeByScore(String var1, double var2, double var4) throws Exception;

    public Long linsert(String var1, BinaryClient.LIST_POSITION var2, String var3, String var4) throws Exception;
}


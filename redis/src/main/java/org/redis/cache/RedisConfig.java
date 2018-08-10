package org.service.redis.cache;

/**
 * @Author Zhao.Fei
 * @Param
 * @Date 2018/8/10 9:59
 * @return
 * @Description redis缓存配置
 **/
public class RedisConfig {
	/**
	 * 有效期
	 */
	private Long expire;
	/**
	 * 是否自动延期
	 */
	private Boolean isDelay;

	public RedisConfig() {
	}

	public RedisConfig(Long expire, Boolean isDelay) {
		this.expire = expire;
		this.isDelay = isDelay;
	}

	public Long getExpire() {
		return expire;
	}

	public void setExpire(Long expire) {
		this.expire = expire;
	}

	public Boolean getIsDelay() {
		return isDelay;
	}

	public void setIsDelay(Boolean isDelay) {
		this.isDelay = isDelay;
	}

}

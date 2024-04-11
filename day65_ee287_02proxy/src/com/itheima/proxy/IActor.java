package com.itheima.proxy;

/**
 * 经纪公司对签约艺人的标准
 * @author 86131
 *
 */
public interface IActor {
	/**
	 * 基本的演出
	 */
	public void basicAct(float money);
	
	/**
	 * 危险的表演
	 */
	public void dangerAct(float money);

}

package org.core.entity;

/**
 * @Author Zhao.Fei
 * @Param
 * @Date 2018/8/9 15:53
 * @return
 * @Description 排序辅助类
 **/
public class Sort {

	private String field;
	private String direction;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDirection() {
		if (direction != null && ("ASC".equalsIgnoreCase(direction) || "DESC".equalsIgnoreCase(direction))) {
			return direction;
		} else {
			return "ASC";
		}
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}

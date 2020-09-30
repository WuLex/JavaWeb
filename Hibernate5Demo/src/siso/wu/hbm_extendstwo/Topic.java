package siso.wu.hbm_extendstwo;

/**
 * 主题
 * 
 * @author 
 * 
 */
public class Topic extends Article {
	private int type; // 主题类型，比如精华帖、置顶帖等等

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}

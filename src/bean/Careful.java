package bean;

import java.io.Serializable;

//　注意事項
public class Careful implements Serializable {
	private boolean walk;
	private boolean eat;
	private boolean bath;
	private boolean sleep;
	private boolean drag;
	private boolean toilet;
	private boolean wcar;

//	ゲッター
	public boolean isWalk() {
		return walk;
	}
	public boolean isEat() {
		return eat;
	}
	public boolean isBath() {
		return bath;
	}
	public boolean isSleep() {
		return sleep;
	}
	public boolean isDrag() {
		return drag;
	}
	public boolean isToilet() {
		return toilet;
	}
	public boolean isWcar() {
		return wcar;
	}

//	セッター
	public void setWalk(boolean walk) {
		this.walk = walk;
	}
	public void setEat(boolean eat) {
		this.eat = eat;
	}
	public void setBath(boolean bath) {
		this.bath = bath;
	}
	public void setSleep(boolean sleep) {
		this.sleep = sleep;
	}
	public void setDrag(boolean drag) {
		this.drag = drag;
	}
	public void setToilet(boolean toilet) {
		this.toilet = toilet;
	}
	public void setWcar(boolean wcar) {
		this.wcar = wcar;
	}
}

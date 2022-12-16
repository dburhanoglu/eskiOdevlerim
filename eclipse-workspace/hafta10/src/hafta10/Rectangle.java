package hafta10;

public class Rectangle implements Movable {
	private int x;
	private int y;
	
	public Rectangle(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
public int alan () {return x*y;}
@Override
public void turnLeft() {
	// TODO Auto-generated method stub
	
}
@Override
public void turnRight() {
	// TODO Auto-generated method stub
	
}
@Override
public void foward() {
	// TODO Auto-generated method stub
	
}
@Override
public void backward() {
	// TODO Auto-generated method stub
	
}
}

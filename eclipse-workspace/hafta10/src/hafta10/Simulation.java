package hafta10;

public class Simulation {
	public static void main(String[] args) {
	Movable m=new Car("merc");
	Movable[] mobjects=new Movable[5];
	mobjects[0]=m;

	mobjects[1]=new Rectangle(3,4);
	mobjects[2]=new Rectangle(7,8);
	mobjects[3]=new Rectangle(2,5);
	mobjects[4]=new Car("tof");
	
	for(int i=0;i<5;i++)
		mobjects[i].foward();
}}

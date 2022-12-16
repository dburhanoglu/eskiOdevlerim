package asýl;
import java.util.*;
public class Stack {
	private Object[] elements;
	private int top;
	public  Stack() {
		elements=new Object [100];
		top=0;
	}
	
public Stack(int size) {
	elements=new Object[size];
	top=0;
}
public Stack(Stack copy) {
	elements=new Object[copy.elements.length];
	top=copy.top;
	for(int i=0;i<top;i++) {
		elements[i]=copy.elements[i];
		
	}
}
public Object pop() {
	if(top>0) 
		return elements[--top];
	return Integer.MIN_VALUE;
	
		
	}
public void  push(Object value) {
	if(top>=elements.length) return;
	elements[top++]=value;
	
}
public int getNumberOfelements() {
	return top;
}
public int getCapacity() {
	return elements.length;
	
}
}

package dersCalisma2;

public class filanException extends Exception {
String hataMetni="hata metni"	;
String hataTipi="hata tipim";
public void filanException() {
	
}
@Override
public String toString() {
	hataMetni+= String.format(":"+hataTipi)
;
	return hataMetni;
}

}

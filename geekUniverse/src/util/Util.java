package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	
	public  String getMd5(String valor) throws NoSuchAlgorithmException{
			
		   String s = valor;
	       MessageDigest md = MessageDigest.getInstance("MD5");
	       md.update(s.getBytes(),0,s.length());
	       return (new BigInteger(1,md.digest()).toString(16));
	}
	
	public static Double getDoubleFromRealString(String valor){
		String resultado = valor.replaceAll("R", " ");
		resultado = resultado.replace("$", " ");
		resultado = resultado.replaceAll(",", ".");
		resultado = resultado.trim();
		System.out.println(resultado);
		
		return Double.parseDouble(resultado);
	}

}

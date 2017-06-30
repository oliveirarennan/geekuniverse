package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static String getMd5(String valor) throws NoSuchAlgorithmException{
			
		   String s = valor;
	       MessageDigest md = MessageDigest.getInstance("MD5");
	       md.update(s.getBytes(),0,s.length());
	       return (new BigInteger(1,md.digest()).toString(16));
	}
	
	public static Double getDoubleFromRealString(String valor){
		String resultado = valor.replaceAll("R", "");
		resultado = resultado.replace("$", "");
		resultado = resultado.replace(".", "");
		resultado = resultado.trim();
		Double numeroConvertido = Double.parseDouble(resultado);
		return numeroConvertido;
	}
	
	public static Date formartaData(String data){
		SimpleDateFormat std = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return std.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String converteStatus(int status){
		if(status == 1){
			return "Ativado";
		}else{
			return "Desativado";
		}
	}
	
	public static int statusParseInt(String status){
		if(status.equals("true")){
			return 1;
		}else{
			return 0;
		}
	}

}

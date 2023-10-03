// Actividad11
// Joseba Martinez
package code;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Actividad11 {
	public static void main(String[] args) {
		Runtime r=Runtime.getRuntime();
		//	String comando="/Applications/Firefox.app/Contents/MacOS/firefox";
		//  String comando="Notepad"; // en windows
		String comando="java code.Ejemplo2"; // en linux
		Process p;
		try {
			p = r.exec(comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader (new InputStreamReader(is));
			String linea;
			while((linea = br.readLine()) != null) // lee una linea
				System.out.println(linea);
			br.close();
		}catch (Exception e){
			
			System.out.println("error en:"+comando);
			e.printStackTrace();			
		}
	}	
}

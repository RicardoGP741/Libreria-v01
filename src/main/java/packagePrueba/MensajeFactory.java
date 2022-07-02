package packagePrueba;

import java.io.IOException;
import java.util.Properties;

public class MensajeFactory {
		public static Mensaje getMensaje() {
			Properties propiedades = new Properties();
			Mensaje mensaje = null;
			
			try {
				propiedades.load(Principal.class.getResourceAsStream("mensaje.properties"));
				String tipo = propiedades.getProperty("tipo");
				if(tipo.equals("html")) {
					mensaje = new MensajeHTML();
				} else {
					mensaje = new MensajePlano();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mensaje;
		}
}

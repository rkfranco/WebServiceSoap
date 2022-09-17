package Client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import Controller.IBaseController;

public class LanGamerClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://127.0.0.1:9876/Controller?wsdl");
		QName qname = new QName("http://Controller/", "LanGamerControllerImplService");
		Service ws = Service.create(url, qname);
		IBaseController controller = ws.getPort(IBaseController.class);

		controller.postSala(1);
		controller.postSala(2);

		System.out.println("Sala 1: "+controller.getComputadoresSala(1));
		System.out.println("Sala 2: "+controller.getComputadoresSala(2));
		
//		controller.postComputador("HB20", "Acer", 1, 1);
		controller.postComputador("GOL", "Acer", 2, 1);
		controller.postComputador("Celta", "Dell", 3, 2);
		System.out.println("Sala 2: " + controller.getComputadoresSala(2));
		System.out.println("Sala 1: " + controller.getComputadoresSala(1));
	}
}

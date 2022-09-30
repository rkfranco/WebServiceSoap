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

		controller.postSala(1, "Alexandre", 2);
		controller.postSala(2, "Rodrigo", 5);
		System.out.println(controller.postSala(3, "Joshua", 15));

		System.out.println("-------------------------------------");
		System.out.println("Sala 2: " + controller.getComputadoresSala(2));
		System.out.println("");
		System.out.println("Sala 1: " + controller.getComputadoresSala(1));
		System.out.println("");

		controller.postComputador("HB20", "Acer", 1, 1);
		controller.postComputador("GOL", "Acer", 2, 2);
		controller.postComputador("Celta", "Dell", 3, 2);

		System.out.println("-------------------------------------");
		System.out.println("Sala 2: " + controller.getComputadoresSala(2));
		System.out.println("");
		System.out.println("Sala 1: " + controller.getComputadoresSala(1));
		System.out.println("");

		controller.postComputador("Audi R8", "IBM", 4, 1);
		System.out.println(controller.postComputador("Onix", "Positivo", 5, 1)); 
		controller.startSession(1);
		controller.addDefeito("Teclas grudentas", 1);
		controller.addDefeito("Tela trincada", 1);
		controller.startSession(2);
		controller.startSession(3);

		System.out.println("START");
		System.out.println("-------------------------------------");
		System.out.println("Sala 2: " + controller.getComputadoresSala(2));
		System.out.println("");
		System.out.println("Sala 1: " + controller.getComputadoresSala(1));
		System.out.println("");

		controller.limpaDefeitos(1);
		controller.endSession(1);
		controller.endSession(2);
		controller.endSession(3);

		System.out.println("-------------------------------------");
		System.out.println("END");
		System.out.println("Sala 2: " + controller.getComputadoresSala(2));
		System.out.println("");
		System.out.println("Sala 1: " + controller.getComputadoresSala(1));
		System.out.println("");
		
		System.out.println(controller.deleteSala(1));
		System.out.println(controller.deleteComputador(1));
		System.out.println(controller.deleteComputador(4));
		System.out.println(controller.deleteSala(1));
		
		System.out.println("-------------------------------------");
		System.out.println("END");
		System.out.println("Sala 2: " + controller.getComputadoresSala(2));
		System.out.println("");
		System.out.println("Sala 1: " + controller.getComputadoresSala(1));
		System.out.println("");

	}
}

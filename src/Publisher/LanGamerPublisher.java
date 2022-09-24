package Publisher;

import javax.xml.ws.Endpoint;

import Controller.IBaseController;
import Controller.LanGamerControllerImpl;

public class LanGamerPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9876/Controller", new LanGamerControllerImpl());
		
//		IBaseController controller = new LanGamerControllerImpl();
//		controller.postSala(1);
//		controller.postSala(2);
//		controller.postSala(2);
//
//		System.out.println("-------------------------------------");
//		System.out.println("Sala 2: " + controller.getComputadoresSala(2));
//		System.out.println("");
//		System.out.println("Sala 1: " + controller.getComputadoresSala(1));
//		System.out.println("");
//
//		controller.postComputador("HB20", "Acer", 1, 1);
//		
//		System.out.println("Sala 1: " + controller.getComputadoresSala(1));
//		System.out.println("");
	}
}

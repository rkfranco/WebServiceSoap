package Publisher;

import javax.xml.ws.Endpoint;

import Controller.LanGamerControllerImpl;

public class LanGamerPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9876/Controller", new LanGamerControllerImpl());
	}
}

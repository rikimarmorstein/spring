package app.core.beabs;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BasicEngine implements Engine {

	@Override
	public void turnOn() {
		System.out.println("basic engine on");
	}

	@Override
	public void turnOff() {
		System.out.println("basic engine off");

	}

}

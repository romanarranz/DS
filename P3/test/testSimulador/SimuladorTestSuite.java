package testSimulador;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	InterfazTest.class,
	ListaObservadoresObservablesTest.class,
	PanelBotonesTest.class,
	SimulacionTest.class
})
public class SimuladorTestSuite {   
}
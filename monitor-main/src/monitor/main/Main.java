package monitor.main;

import monitor.core.MonitorEngine;
import monitor.gui.MonitorWindow;

public class Main {
	public static void main(String[] args) {

		MonitorEngine m = new MonitorEngine("/home/marcio");
		m.inicia();
		
		MonitorWindow w = new MonitorWindow(m);
		w.visible();
		
		// componente main precisa do compoente change
		// m.addDiskSpaceListener(w);
		
	}
}

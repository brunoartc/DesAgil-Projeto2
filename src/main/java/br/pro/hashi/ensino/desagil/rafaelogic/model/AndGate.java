package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate{
	
	private NandGate nand = new NandGate();
	private NotGate  not = new NotGate();
	private Emitter[] emitters;
	
	public AndGate() {
		emitters = new Emitter[2];
	}
	
	@Override
	 public void connect(int pinIndex, Emitter emitter) {
		 emitters[pinIndex] = emitter;
	}
	
	@Override
	public boolean read() {
		nand.connect(0, emitters[0]);
		nand.connect(1, emitters[1]);
		
		not.connect(0,nand);
		
		return(not.read());
	}
	
}

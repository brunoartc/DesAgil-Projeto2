package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class NotGate extends Gate{
	private NandGate gate;
	private Emitter[] emitters;
	private boolean Nand1;

	public NotGate() {
		super("NotGate", 1);
		emitters = new Emitter[1];
		gate = new NandGate();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		emitters[pinIndex] = emitter;
	}

	@Override
	public boolean read() {
		gate.connect(0, emitters[0]);
		gate.connect(1, emitters[0]);
		Nand1 = gate.read();
		
		return (Nand1);
	}

}

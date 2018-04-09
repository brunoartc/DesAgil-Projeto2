package br.pro.hashi.ensino.desagil.rafaelogic.model;



public class OrGate extends Gate{
	private NandGate  nandA = new NandGate();
	private NandGate  nandB = new NandGate();
	private NandGate  nandOut = new NandGate();

	public OrGate(){
		super("OrGate",2);
	}

	public void connect(int pinIndex, Emitter emitter){
		if(pinIndex == 0){
			nandA.connect(0, emitter);
			nandA.connect(1, emitter);
			nandOut.connect(0,nandA);
		}
		else if(pinIndex == 1){
			nandB.connect(0, emitter);
			nandB.connect(1, emitter);
			nandOut.connect(1,nandB);
		}
	}

	public boolean read(){	
		return nandOut.read();
	}

}

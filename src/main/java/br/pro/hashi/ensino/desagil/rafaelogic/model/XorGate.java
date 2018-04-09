package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class XorGate extends Gate{
	
	private NandGate  nand = new NandGate();
	private Emitter[] emitters;
	
	private Gate nand1 = new NandGate();
	private Gate nand2 = new NandGate();
	private Gate nand3 = new NandGate();
	
	public XorGate() {
		super("XorGate",2);
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
		
		
		nand1.connect(0,nand);
		nand1.connect(1, emitters[0]);
		
		
		nand2.connect(0, nand);
		nand2.connect(1, emitters[1]);
		
		nand3.connect(0, nand2);
		nand3.connect(1, nand1);
		
		return(nand3.read());
		
	}
	
}

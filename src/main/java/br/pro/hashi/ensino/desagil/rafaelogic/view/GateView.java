package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;


import java.net.URL;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.NotGate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class GateView extends SimplePanel implements ItemListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private Gate gate;
	

	private	JCheckBox inputABox;
	Source sourceA;
	
	private	JCheckBox inputBBox;
	Source sourceB;
	
	private	JCheckBox output;
	
	private Color color;
	private Image image;
	
	
	private Color ColorChanger;

	public GateView(Gate gate) {
		super(200, 200); //tamanho da tela
		
		ColorChanger = Color.RED;
		
		this.gate = gate;
		
		sourceA = new Source();
		inputABox = new JCheckBox("Input A");  //define o checkbox A
		inputABox.setSelected(false);
		inputABox.addItemListener(this);
		
		inputBBox = new JCheckBox("Input B");
		inputBBox.setSelected(false); //define o checkbox A
		inputBBox.addItemListener(this);
		sourceB = new Source();
		
		
		output = new JCheckBox(); //define o checkbox saida (so para controle a partir dessa versao)
		output.setEnabled(false); //nao pode mudar
		
		if (gate.toString() == "NotGate"){
			add(inputABox, 12, 100, 20, 20); //se for o notgate (ou seja uma saida)
			gate.connect(0, sourceA);
		}
		
		else {
			add(inputABox, 12, 50, 20, 20);
			add(inputBBox, 12, 100, 20, 20); //se nao for o not gate (2 saidas)
			gate.connect(0, sourceA);
			gate.connect(1, sourceB); //TODO um for que faca automatico para diversas saidas @vinigl @wesleygas
		}

		
		
		
		
		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path); //puxa a imagem do pc (diretorio bin)
		image = new ImageIcon(url).getImage();
		
		addMouseListener(this);
	}
	
	public void itemStateChanged(ItemEvent e) {
		sourceA.turn(inputABox.isSelected());
		if (gate.toString() != "NotGate") sourceB.turn(inputBBox.isSelected()); //atualiza na memoria(variavel) o estado
		output.setSelected(gate.read());//atualiza o output (Nao é mostrado nesssa versao)
		update();
	}

	private void update() {
		if (output.isSelected()){
			color = ColorChanger; //troca para a cor escolhida
			repaint(); //repinta a tela
		}
		
		else{
			color = Color.BLACK;
			repaint();
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		update(); //update da tela
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {

		int x = event.getX();
		int y = event.getY();

		if (color !=  Color.BLACK){
			if(Math.pow(x-115, 2)+Math.pow(y-90, 2)<=100) { //15 pixel a mais acha o mouse dentro do ciculo 

				ColorChanger = JColorChooser.showDialog(this, null, color); //abre o seletor
				color = ColorChanger; //salva a cor pra quando precisar
				repaint(); //repinta o circulo
			}
		}
		
	}
	@Override
	public void mousePressed(MouseEvent event) {
	}
	@Override
	public void mouseReleased(MouseEvent event) {
	}
	@Override
	public void mouseEntered(MouseEvent event) {
	}
	@Override
	public void mouseExited(MouseEvent event) {
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(image, 30, 30, 100, 100, null); //desenha tela
		
		g.setColor(color); //define core
	    g.fillOval(100, 75, 30, 30); //faz elipse (no caso circulo)

		getToolkit().sync();
    }
}
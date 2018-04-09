package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.util.LinkedList;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class GateView extends JPanel implements ItemListener{
	
	private static final long serialVersionUID = 1L;
	
	private Gate gate;
	
	private JCheckBox inputABox;
	private Source sourceA;

	private JCheckBox inputBBox;
	private Source sourceB;
	
	private JCheckBox output;
	
	public GateView(Gate gate) {
		//TODO usar algum método para generalizar de acordo com o
		//número de entradas no gate
		this.gate = gate;		
		JLabel entradaLabel = new JLabel("Entrada:");
		
		inputABox = new JCheckBox("Input A");
		inputABox.setSelected(false);
		inputABox.addItemListener(this);
		sourceA = new Source();
		this.gate.connect(0, sourceA);
		
		inputBBox = new JCheckBox("Input B");
		inputBBox.setSelected(false);
		inputBBox.addItemListener(this);
		sourceB = new Source();
		this.gate.connect(1, sourceB);
		
		JLabel saidaLabel = new JLabel("Saida:");
		output = new JCheckBox("Output");
		output.setEnabled(false);
		output.setSelected(gate.read());
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(entradaLabel);
		add(inputABox);
		add(inputBBox);
		add(saidaLabel);
		add(output);
		
		inputABox.addItemListener(this);
        inputBBox.addItemListener(this);
        output.addItemListener(this);	
		
	}


	public void itemStateChanged(ItemEvent e) {
		sourceA.turn(inputABox.isSelected());
		sourceB.turn(inputBBox.isSelected());
		output.setSelected(gate.read());
		
	}
	
	
}

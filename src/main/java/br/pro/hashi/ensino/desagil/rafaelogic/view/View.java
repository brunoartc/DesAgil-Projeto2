package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;

public class View extends JPanel implements ItemListener,ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Gate> menu;
	private GateView gateView;
	
	public View(LinkedList<Gate> model) {
		menu = new JComboBox<Gate>();
		
		for(Gate gate: model) {
			menu.addItem(gate);
		}
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(menu);
		
		addGateView(0);
		
		menu.addActionListener(this);
	}
	
	private void addGateView(int index) {
		Gate gate = menu.getItemAt(index);
		gateView = new GateView(gate);
		add(gateView);
		
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		remove(gateView);
		int index = menu.getSelectedIndex();
		addGateView(index);
		
		((JFrame) SwingUtilities.getRoot(this)).pack();
		
	}

}

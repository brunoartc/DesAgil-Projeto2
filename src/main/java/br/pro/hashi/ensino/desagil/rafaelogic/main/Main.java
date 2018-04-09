package br.pro.hashi.ensino.desagil.rafaelogic.main;

import java.util.LinkedList;

import javax.swing.JFrame;

import br.pro.hashi.ensino.desagil.rafaelogic.model.*;
import br.pro.hashi.ensino.desagil.rafaelogic.view.View;

public class Main {
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LinkedList<Gate> model = new LinkedList<>();
				model.add(new AndGate());
				model.add(new NandGate());
				model.add(new OrGate());
				model.add(new XorGate());
				
				View view = new View(model);
				
				JFrame frame = new JFrame();
            	frame.setContentPane(view);
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	frame.setResizable(false);
            	frame.pack();
            	frame.setVisible(true);
			}
		});
		
	}
}

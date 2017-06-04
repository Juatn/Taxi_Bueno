package Main;

import javax.swing.UIManager;

import GUI.Entrada;


public class Arranque {

	public static void main(String[] args) {
		
		Entrada window = new Entrada();
		 for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
	            if("Nimbus".equals(laf.getName()))
	                try {
	                UIManager.setLookAndFeel(laf.getClassName());
	            } catch (Exception ex) {
	            }
	        }
		window.frame.setVisible(true);

	}

}

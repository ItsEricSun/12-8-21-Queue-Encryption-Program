import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBFrame;

public class GUI extends GBFrame {

	static JFrame frm;
	Cryptor c = new Cryptor();
	JTextField keyField;
	JTextField messageField;
	JButton EncryptButton;
	JButton DecryptButton;
	
	public void MainMenu() {
		JLabel inputLabel = addLabel("Enter Key (One Space in between each Number):", 1,1,1,1);
		keyField = addTextField("", 2,1,1,1);
		JLabel inputLabel2 = addLabel("Enter Message to be Encrypted or Decrypted:", 3,1,1,1);
		messageField = addTextField("", 4,1,1,1);
		EncryptButton = addButton("Encrypt", 5,1,1,1);
		DecryptButton = addButton("Decrypt", 6,1,1,1);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == EncryptButton) {
			try {
				String key = keyField.getText();
				String m = messageField.getText();
				c.toKey(key);
				messageBox("Encrypted: " + c.encrypt(m));
			} catch (Exception e) {
				messageBox("Input Error");
			}
		} else if(buttonObj == DecryptButton) {
			try {
				String key = keyField.getText();
				String m = messageField.getText();
				c.toKey(key);
				messageBox("Decrypted: " + c.decrypt(m));
			} catch (Exception e) {
				messageBox("Input Error");
			}
		}
	}
	
	public GUI() {
		MainMenu();
	}
	
	public static void main(String[] args) {
		frm = new GUI();
		frm.setTitle("Encryption");
		frm.setSize(450, 200);
		frm.setVisible(true);
	}

}

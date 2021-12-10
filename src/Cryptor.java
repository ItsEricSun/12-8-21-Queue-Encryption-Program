
public class Cryptor {

	LinkedQueue<Integer> queue;
	
	Cryptor() {
		queue = new LinkedQueue<Integer>();
	}
	
	void toKey(String k) {
		queue = new LinkedQueue<Integer>();
		String[] input = k.split(" ");
		for(int i = 0; i < input.length; i++) {
			queue.enqueue(Integer.parseInt(input[i]) % 26);
		}
	}
	
	String encrypt(String m) {
		String result = "";
		for(int i = 0; i < m.length(); i++) {
			char c = m.charAt(i);
			int ascii = (int)c;
			//UPPERCASE
			if(ascii >= 65 && ascii <= 90) {
				int translate = queue.dequeue();
				int newc = ascii + translate;
				if(newc > 90) {
					newc = newc - 26;
				}
				result = result + (char)newc;
				queue.enqueue(translate);
			}
			//LOWERCASE
			else if(ascii >= 97 && ascii <= 122) {
				int translate = queue.dequeue();
				int newc = ascii + translate;
				if(newc > 122) {
					newc = newc - 26;
				}
				result = result + (char)newc;
				queue.enqueue(translate);
			} else {
				result = result + c;
			}
		}
		return result;
	}
	
	String decrypt(String m) {
		String result = "";
		for(int i = 0; i < m.length(); i++) {
			char c = m.charAt(i);
			int ascii = (int)c;
			//UPPERCASE
			if(ascii >= 65 && ascii <= 90) {
				int translate = queue.dequeue();
				int newc = ascii - translate;
				if(newc < 65) {
					newc = newc + 26;
				}
				result = result + (char)newc;
				queue.enqueue(translate);
			}
			//LOWERCASE
			else if(ascii >= 97 && ascii <= 122) {
				int translate = queue.dequeue();
				int newc = ascii - translate;
				if(newc < 97) {
					newc = newc + 26;
				}
				result = result + (char)newc;
				queue.enqueue(translate);
			} else {
				result = result + c;
			}
		}
		return result;
	}
	
}

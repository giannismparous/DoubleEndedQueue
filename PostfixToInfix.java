import java.util.Scanner;

public class PostfixToInfix {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Dwse Postfix Morfh:");
		char[] arr = inp.nextLine().toCharArray();
		if (arr[arr.length-1]!='+' && arr[arr.length-1]!='-' && arr[arr.length-1]!='*' && arr[arr.length-1]!='/') {//elegxei an to input teleiwnei se telesth.
			System.out.println("Incorrect Postfix Form... Input doesn't end with an operator... Exiting");
			System.exit(1);
		}
		StringDoubleEndedQueueImpl<String> q = new StringDoubleEndedQueueImpl<String>();
		for (int i=0 ; i<arr.length; i++ ) {
			if ((arr[i] >= '0') && (arr[i] <= '9')) {//eisagei ton antistoixo akeraio sto telos ths Dequeue.
				q.addLast(String.valueOf(arr[i]));
			}else if (((arr[i] == '+') || (arr[i] == '*'|| (arr[i] == '-') || (arr[i] == '/')))) {//vgazei tous 2 teleytaious akeraious ths Dequeue, efarmozei ton telesth praxh metaxy twn 2 prohgoumenwn akeraiwn mesa se parentheseis kai to topothetei sto telos ths Dequeue.
				String k = q.removeLast(); String l = q.removeLast();
				q.addLast("(" + l + arr[i] + k + ")");
			}else {//elegxei an eisaxthei akyros xarakthras.
				System.out.println("Incorrect Postfix Form... Invalid character found... Exiting.");
				System.exit(1);
			}
		}
		if (q.size()!=1) {//elegxei an perissevoun arithmoi
			System.out.println("Incorrect Postfix Form ... Numbers are unused... Exiting.");
			System.exit(1);
		}
		q.printQueue(System.out);//emfanizei infix morfh.
		inp.close();
	}
}
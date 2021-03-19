import java.util.Scanner;

public class DNAPalindrome {

	public static void main(String[] args) {
		System.out.println("Dwse Noukleotidikh alysida:");
		Scanner inp = new Scanner(System.in);
		String in=inp.nextLine().trim();//afairei kena aristera kai dexia tou input.
		char[] arr = in.toCharArray();
		StringDoubleEndedQueueImpl<String> q = new StringDoubleEndedQueueImpl<String>();
		for (int i=0 ; i<arr.length; i++ ) {//analogws to char prostithetai to antistoixo symplhrwmatiko String sthn arxh tou Deqeue.
			if ((arr[i] =='A')) {
				q.addFirst("T");
			}else if (arr[i] == 'T') {
				q.addFirst("A");
			}else if (arr[i]=='G') {
				q.addFirst("C");
			}else if (arr[i]== 'C') {
				q.addFirst("G");
			}
			else if (arr[i]== ' '){//elegxei an uparxei keno anamesa sta noukleotidia.
				System.out.println("Incorrect Form ... Blank space found between 2 nucleotides ... Exiting.");
				System.exit(1);
			}
			else {//elegxei an eisaxthei akyros xarakthras.
				System.out.println("Incorrect Form ... Invalid character found... Exiting.");
				System.exit(1);
			}
		}
		int k = q.size();
		for (int i=0; i<k-1; i++) {//prosthithontai ola ta zeygh twn String metaxy tous wste na meinei olh h symplhrwmatikh palindromh alysida monh ths sthn arxh ths listas kai epeita na sygkrithei me to arxiko input.
			q.addFirst(q.removeFirst()+q.removeFirst());
		}
		if (in.equals(q.getLast())) {//elegxos akolouthias.
			System.out.println("Akolouthia Watson-Crick");
		}else {
			System.out.println("Oxi akolouthia Watson-Crick");
		}
		inp.close();
	}
}
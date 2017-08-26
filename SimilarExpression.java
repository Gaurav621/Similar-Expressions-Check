import java.util.Scanner;

public class SimilarExpression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = new String(sc.next());
		StringBuffer sb = new StringBuffer(s);
		int i = sb.length() - 1;

		while (i > 0) {
			if (sb.charAt(i) == '(') {
				if (sb.charAt(i - 1) == '-') {
					int j = i + 1;
					while (sb.charAt(j) != ')') {
						if (sb.charAt(j) == '-') {
							sb.setCharAt(j, '+');
						} else if (sb.charAt(j) == '+') {
							sb.setCharAt(j, '-');
						}
						j++;
					}
					sb.deleteCharAt(j);
					sb.deleteCharAt(i);
					if (sb.charAt(i) == '+' || sb.charAt(i) == '-') {
						sb.deleteCharAt(i - 1);
					}
				} else if (sb.charAt(i - 1) == '+') {
					int j = i + 1;
					while (sb.charAt(j) != ')') {
						j++;
					}
					sb.deleteCharAt(j);
					sb.deleteCharAt(i);
					if (sb.charAt(i) == '+' || sb.charAt(i) == '-') {
						sb.deleteCharAt(i - 1);
					}
				} else {
					int j = i + 1;
					while (sb.charAt(j) != ')') {
						j++;
					}
					sb.deleteCharAt(j);
					sb.deleteCharAt(i);
				}
			}
			i--;
		}
		for (int i2 = sb.length() - 1; i2 >= 0; i2--) {
			if (sb.charAt(i2) == '(' || sb.charAt(i2) == ')') {
				sb.deleteCharAt(i2);
			}
		}

		String s1 = new String(sc.next());
		StringBuffer sb1 = new StringBuffer(s1);
		int i11 = sb1.length() - 1;

		while (i11 > 0) {
			if (sb1.charAt(i11) == '(') {
				if (sb1.charAt(i11 - 1) == '-') {
					int j = i11 + 1;
					while (sb1.charAt(j) != ')') {
						if (sb1.charAt(j) == '-') {
							sb1.setCharAt(j, '+');
						} else if (sb1.charAt(j) == '+') {
							sb1.setCharAt(j, '-');
						}
						j++;
					}
					sb1.deleteCharAt(j);
					sb1.deleteCharAt(i11);
					if (sb1.charAt(i11) == '+' || sb1.charAt(i11) == '-') {
						sb1.deleteCharAt(i11 - 1);
					}
				} else if (sb1.charAt(i11 - 1) == '+') {
					int j = i11 + 1;
					while (sb1.charAt(j) != ')') {
						j++;
					}
					sb1.deleteCharAt(j);
					sb1.deleteCharAt(i11);
					if (sb1.charAt(i11) == '+' || sb1.charAt(i11) == '-') {
						sb1.deleteCharAt(i11 - 1);
					}
				} else {
					int j = i11 + 1;
					while (sb1.charAt(j) != ')') {
						j++;
					}
					sb1.deleteCharAt(j);
					sb1.deleteCharAt(i11);
				}
			}
			i11--;
		}
		for (int i2 = sb1.length() - 1; i2 >= 0; i2--) {
			if (sb1.charAt(i2) == '(' || sb1.charAt(i2) == ')') {
				sb1.deleteCharAt(i2);
			}
		}

		if (!((sb.charAt(0) != '+') ^ (sb.charAt(0) != '-'))) {
			sb.insert(0, '+');
		}
		if (!((sb1.charAt(0) != '+') ^ (sb1.charAt(0) != '-'))) {
			sb1.insert(0, '+');
		}

		StringBuffer innersb1 = new StringBuffer();
		int a = 0;
		for (int k = 0; k < sb.length(); k++) {
			if (sb.charAt(k) == '+') {
				innersb1.insert(a, sb.charAt(k));
				a++;
				innersb1.insert(a, sb.charAt(k + 1));
				a++;
			}
			if (sb.charAt(k) == '-') {
				innersb1.append(sb.charAt(k));
				innersb1.append(sb.charAt(k + 1));
			}
		}
		sb = innersb1;
		innersb1 = new StringBuffer();

		for (int j = 97; j < 123; j++) {
			for (int k = 1; k < sb.length(); k += 2) {
				if (sb.charAt(k) == j) {
					innersb1.append(sb.charAt(k - 1));
					innersb1.append(sb.charAt(k));
				}
			}
		}

		StringBuffer innersb2 = new StringBuffer();
		int a1 = 0;
		for (int k = 0; k < sb1.length(); k++) {
			if (sb1.charAt(k) == '+') {
				innersb2.insert(a1, sb1.charAt(k));
				a1++;
				innersb2.insert(a1, sb1.charAt(k + 1));
				a1++;
			}
			if (sb1.charAt(k) == '-') {
				innersb2.append(sb1.charAt(k));
				innersb2.append(sb1.charAt(k + 1));
			}
		}
		sb1 = innersb2;
		innersb2 = new StringBuffer();
		for (int j = 97; j < 123; j++) {
			for (int k = 1; k < sb1.length(); k += 2) {
				if (sb1.charAt(k) == j) {
					innersb2.append(sb1.charAt(k - 1));
					innersb2.append(sb1.charAt(k));
				}
			}
		}

		sb = innersb1;
		sb1 = innersb2;
		int j = sb.length() - 1;
		while (j > 0) {
			if (sb.charAt(j) == '-') {
				for (int k = sb.length() - 1; k >= 0; k--) {
					if (sb.charAt(k) == sb.charAt(j + 1)) {
						if (sb.charAt(k - 1) == '+') {
							innersb1.deleteCharAt(j + 1);
							innersb1.deleteCharAt(j);
							innersb1.deleteCharAt(k);
							innersb1.deleteCharAt(k - 1);
							j -= 3;
							break;
						}
					}
				}
			}
			j--;
		}
		
		int j1 = sb1.length() - 1;
		while (j1 > 0) {
			if (sb1.charAt(j1) == '-') {
				for (int k = sb1.length() - 1; k >= 0; k--) {
					if (sb1.charAt(k) == sb1.charAt(j1 + 1)) {
						if (sb1.charAt(k - 1) == '+') {
							innersb2.deleteCharAt(j1 + 1);
							innersb2.deleteCharAt(j1);
							innersb2.deleteCharAt(k);
							innersb2.deleteCharAt(k - 1);
							j1 -= 3;
							break;
						}
					}
				}
			}
			j1--;
		}
		
		System.out.println(sb);
		System.out.println(sb1);

		if (sb.toString().equals(sb1.toString())) {
			System.out.println("YES");
		} else
			System.out.println("NO");
	}
}

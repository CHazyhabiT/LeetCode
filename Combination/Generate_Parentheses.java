import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		HashSet<String> medResult = new HashSet<String>();
		if (n < 1)
			return result;
		medResult.add("()");
		for (int i = 1; i < n; ++i) {
			HashSet<String> current = medResult;
			medResult = new HashSet<String>();
			Iterator<String> iter = current.iterator();
			while (iter.hasNext()) {
				String str = iter.next();
				ArrayList<String> parenA = parse(str);
				int length = parenA.size();
				for (int j = 0; j <= length; ++j) {
					addParen(parenA, j, medResult);

				}

			}

		}
		Iterator<String> iter = medResult.iterator();
		while (iter.hasNext()) {
			result.add(iter.next());
		}
		return result;

	}

	private ArrayList<String> parse(String str) {
		char[] charA = str.toCharArray();
		ArrayList<String> result = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		int flag = 0;
		for (char c : charA) {
			Character C = c;
			sb.append(c);
			if (C.equals('(')) {
				++flag;
			} else
				--flag;
			if (flag == 0) {
				result.add(sb.toString());
				sb = new StringBuffer();
			}

		}
		return result;

	}

	private void addParen(ArrayList<String> al, int i, HashSet<String> hs) {
		int count = al.size() - i;

		for (int j = 0; j <= count; ++j) {
			StringBuffer sb = new StringBuffer();
			int count1 = 0;

			while (count1 < j) {
				sb.append(al.get(count1++));
			}

			sb.append("(");
			int count2 = 0;
			while (count2 < i) {
				sb.append(al.get(count1++));
				count2++;
			}
			sb.append(")");

			while (count1 < al.size()) {
				sb.append(al.get(count1++));
			}

			hs.add(sb.toString());

		}
	}
        
        
        
        
        
    
    
}

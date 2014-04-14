import java.util.Hashtable;
import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		if (num.length <= 2){
		    return new ArrayList<ArrayList<Integer>>();
		    
		}

		sort(num);

		ArrayList<ArrayList<Integer>> resultA = new ArrayList<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> mark = new HashSet<ArrayList<Integer>>();
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		for (int i = 0; i < num.length-1; i++) {

			for (int j = i + 1; j < num.length; j++) {
				int rest = 0 - num[i] - num[j];

				if (ht.containsKey(rest)) {
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(rest);
					result.add(num[i]);
					result.add(num[j]);
					if (!mark.contains(result)) {

						if (ht.get(rest) != i) {
							resultA.add(result);
							mark.add(result);
						}
					}
				}
				

			}
						ht.put(num[i], i);
		}

		return resultA;

	}

	private void sort(int[] num) {
		if (num.length <= 1)
			return;
		int[] aux = new int[num.length];
		sort(num, aux, 0, num.length - 1);

	}

	private void sort(int[] num, int[] aux, int i, int j) {
		if (i == j)
			return;
		int mid = (i + j) / 2;
		sort(num, aux, i, mid);
		sort(num, aux, mid + 1, j);
		merge(num, aux, i, mid, j);

	}

	private void merge(int[] num, int[] aux, int i, int mid, int j) {
		for (int k = i; k <= j; k++) {
			aux[k] = num[k];
		}
		int p = i;
		int q = mid + 1;

		for (int k = i; k <= j; k++) {
			if (p > mid)
				num[k] = aux[q++];
			else if (q > j)
				num[k] = aux[p++];
			else if (aux[p] > aux[q])
				num[k] = aux[q++];
			else
				num[k] = aux[p++];

		}
	}
}

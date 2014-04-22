// Chester

// O(n^2)
import java.util.Hashtable;
import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		if (num.length <= 2){
		    return new ArrayList<ArrayList<Integer>>();
		}

		sort(num); // could use the inserted sort method: Arrays.sort(num);

		ArrayList<ArrayList<Integer>> resultA = new ArrayList<ArrayList<Integer>>();
		// store the already found list
		HashSet<ArrayList<Integer>> mark = new HashSet<ArrayList<Integer>>();
		// store the already visited number with its index
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		for (int i = 0; i < num.length-1; i++) { // i<num.length-1
			for (int j = i + 1; j < num.length; j++) { // j<num.length
				int rest = 0 - num[i] - num[j];
				// at this point num[i] and num[i] haven't been stored in ht
				if (ht.containsKey(rest)) {
					ArrayList<Integer> result = new ArrayList<Integer>();
					// rest <= num[i] <= num[j]
					result.add(rest);
					result.add(num[i]);
					result.add(num[j]);
					if (!mark.contains(result)) {
						resultA.add(result);
						mark.add(result);
						
					}
				}
			}
		ht.put(num[i], i);
		}

		return resultA;

	}

	// merge-sort
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

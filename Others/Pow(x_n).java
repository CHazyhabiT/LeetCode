// Chester

// 1. first to define there is no overflow
// 2. n = negative infinite ~ positive infinite
// 3. Brute force x * x * ... * x (n)
// 4. improvement pow(x, n) = x^n/2 * x^n/2 ...
public class Solution {
    public double pow(double x, int n) {
        if(n==0) {
            double one = 1;
            return one;
        }
	// if n = -3 then a = n/2 = -1
        if(n==-1) return 1/x;
        if(n==1) return x;
        int l = n/2;
        int r = n - l;
	// cannot written as val = pow(x, l) * pow(x, l)
	// in this way, pow(x, l) will be computed twice
        double val = pow(x, l);        
	val *= val;
        if(l==r) return val;
        else return val * pow(x, r-l);
        
    }
}

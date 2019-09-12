package fenwicktree;

public class FenwickTree {
    int value;
    int leftSize;
    FenwickTree left;
    FenwickTree right;
    
    FenwickTree(int value){
        this.value = value;
        this.leftSize = 0;
        this.left = null;
        this.right = null;
    }

    FenwickTree(int leftSize, FenwickTree left, FenwickTree right){
        this.leftSize = leftSize;
        this.left = left;
        this.right = right;       
        this.value = left.value + right.value; 
   }

    public String toString(){
        if(left == null && right == null) return "[" + value + ", " + leftSize + "]";
         
        return  "[" + value + ", " + leftSize + ", " + left.toString() + ", " + right.toString() + "]";
    }

    static FenwickTree allZeros(int n){
	if(n == 0) return null;
	if(n == 1) return new FenwickTree(0);
	
	int m = n/2;
		
	return new FenwickTree(n-m, allZeros(n-m), allZeros(m));
    }
    
    
    int size(){
        if(left == null && right == null) return 1;
        
        return left.size() + right.size();
    }

    void increment(int i, int delta){
        this.value += delta;
        
        if(left == null && right == null)
            return;
        
        if(i < leftSize)
            left.increment(i, delta);
        else
            right.increment(i-leftSize, delta);
    }    
    
    int prefixSum(int upto){
        if(left == null && right == null) return value;
        
        int ret = 0;
        
        if(upto > 0){
            ret += left.prefixSum(upto);
            
            if(upto > leftSize)
                ret += right.prefixSum(upto-leftSize);
        }

	return ret;
    }

    int between(int lo, int hi){
	return prefixSum(hi)-prefixSum(lo);
    }
}

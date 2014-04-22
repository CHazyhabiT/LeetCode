// Chester

//if a number from S is the first one of the numbers with the same value, it can be used to extend all previous subsets and create new non-duplicate subsets.

//if a number from S is a duplicated number of some value, it cannot be used to extend all previous subsets. Only part of them. The idea is that this number should help make some different subsets than its predecessor. So it only needs to extend subsets which contains its predecessor.

/*
 * this answer is in C and not mine
 */
    //answer for SUBSETS II
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        sort(S.begin(), S.end());
        vector<vector<int>> result(1);
        int oldval=S[0];
        int oldj=0;
        for(int i=0; i<S.size(); i++){
            int temp=oldj;
            if(S[i]!=oldval){
                oldval=S[i]; temp=0;
            }
            int j=result.size();
            oldj=j;
            while(j-->temp){
                //note temp here help avoid creating duplicate subsets
                result.push_back(result[j]);
                result.back().push_back(S[i]);
            }
        }
        return result;
    } 

// Chester

// test cases:
// /home/ => /home
// /a/./b/../../c/ => /c
// /../ => /
// /..ha/c/ => /..ha/c
// /... => /...

import java.util.ArrayList;
public class Solution {
    public String simplifyPath(String path) {
        if(path==null) return path;
	// regular expression "/+" stands for one or more "/"
        String[] strings = path.split("/+");
        ArrayList<String> al = new ArrayList<String>();
        for(String string : strings) {
	    // equal whether two strings are equal, must use String.equals()
	    // str1 == str2 will result whether they are the stored in the same place
            if(string.equals("")) continue;
            if(string.equals("..")) {
                if(!al.isEmpty())
                    al.remove(al.size()-1);
            } else if(string.equals(".")) continue;
                else al.add(string);
        }
        StringBuffer sb = new StringBuffer();
        for(String string : al) {
            sb.append('/');
            sb.append(string);
        }
        if(sb.length()==0) sb.append('/');
        return sb.toString();
    }
}

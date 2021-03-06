package tree;

public class verifyPostorder {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return process(postorder,0,postorder.length -1);

        }
        boolean process(int[] postorder,int i ,int j) {
            if(i>=j)return true;
            int p = i;
            while(postorder[p]<postorder[j])p++;
            int m = p;
            while(postorder[p]>postorder[j])p++;
            return p==j && process(postorder,i,m-1) && process(postorder,m,j-1);
        }

    }
}

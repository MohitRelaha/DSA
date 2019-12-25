/*

Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST

*/





void findans(treenode* cur,int* val,int* ans)
{
    if(cur)
    {
        findans(cur->left,val,ans);
        *val = *val-1;
        if(*val == 0)
        {   *ans = cur->val;
            return;
        }
        else if(cur->right)
            findans(cur->right,val,ans);
    }
   
}
 
 
int kthsmallest(treenode* A, int B) {
    int ans = 0;
    findans(A,&B,&ans);
    return ans;
}

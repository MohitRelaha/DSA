/*

Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.


*/






int check(treenode* root,int value)
 {
    if(root == NULL)
        return 0;
    if(root->val == value)
        return 1;
    else
        return check(root->left,value) || check(root->right,value);
 }
 
treenode* LCA(treenode* root,int val1,int val2)
{
    if(root == NULL)
        return NULL;
    
    if(root->val == val1 || root->val == val2)
        return root;
        
    treenode* x = LCA(root->left,val1,val2);
    treenode* y = LCA(root->right,val1,val2);
    
    if(x && y)
        return root;
    else if(x)
        return x;
    else if(y)
        return y;
    
    return NULL;
}
 
 
int lca(treenode* A, int val1, int val2) {
    int a = check(A,val1);
    int b = check(A,val2);
    
    if(a == 0 || b == 0)   //if(!(a && b)) return -1;
        return -1;
        
    return LCA(A,val1,val2)->val;
}


/*

Given a binary tree, invert the binary tree and return it.
Look at the example for more details.

Example :
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4

*/







void swap(treenode** left,treenode** right)
{
    treenode* temp = *left;
    *left = *right;
    *right = temp;
}

void invert(treenode* A)
{
    if(A==NULL)
        return;
        
    swap(&(A->left),&(A->right));
    invert(A->left);
    invert(A->right);
}

treenode* invertTree(treenode* A) {
    invert(A);
    return A;
}

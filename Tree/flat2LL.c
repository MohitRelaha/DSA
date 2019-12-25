/*

Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.

*/



void flat(treenode* cur)
{
    if(cur == NULL || !(cur->left || cur->right))
        return;
    else if(cur->left)
    {
        flat(cur->left);
        
        treenode* temp = cur->right;
        cur->right = cur->left;
        treenode* temporary = cur->left;
        cur->left = NULL;
        while(temporary->right)
            temporary = temporary->right;
        temporary->right = temp;
        
        flat(temp);
    }
    else if(cur->right)
        flat(cur->right);
}
 
treenode* flatten(treenode* A) {
    flat(A);
    return A;
}

/*

Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes

Your solution should run in linear time and not take memory more than O(height of T).
Assume all values in BST are distinct.
Example :

Input 1: 

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2: 

T:        10
         / \
        9   20

K = 40

Return: 0

*/







int find(treenode* node,int value){
    if(node == NULL)
        return 0;
    else if(node->val == value)
        return 1;
    else if(node->val > value)
        return find(node->left,value);
    else
        return find(node->right,value);
} 
 
int cal(treenode* root,treenode* cur,int K){
    if(cur == NULL)
        return 0;
        
    if(cur->val >= (K+1)/2)
        return cal(root,cur->left,K);
    else{
        int found = find(root,K-cur->val);
        if(found)
            return 1;
        else
            return cal(root,cur->left,K) || cal(root,cur->right,K); 
    }
}

int t2Sum(treenode* A, int B) {
    return cal(A,A,B);
}

/*

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity.

*/






typedef struct stack{
    treenode* nod;
    struct stack* next;
}st ;

void push(st** s,treenode* n){
    st* temp = (st*)malloc(sizeof(st));
    temp->nod = n;
    temp->next = *s;
    *s = temp;
    
}

void pop(st** s){
    st* temp = *s;
    *s = (*s)->next;
    free(temp);
}


treenode* peek(st* s){
    if(s == NULL)
        return NULL;
    
    return s->nod;
}

int isEmpty(st* s){
    if(s == NULL)
        return 1;
        
    return 0;
}


st* s = NULL;


void init(treenode* root) {
    while(root){
        push(&s,root);
        root = root->left;
    }
}

/** @return 0 / 1 based on whether we have a next smallest number */
int hasNext() {
    return !(isEmpty(s));
}

/** @return the next smallest number */
int next() {
    treenode* top = peek(s);
    pop(&s);
    
    if(top->right)
        init(top->right);
    
    return top->val;
}

/**
 * Your BSTIterator will be called like this:
 * init(root);
 * while(hasNext()) printf("%d ", next());
 */

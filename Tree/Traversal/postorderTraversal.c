/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 * 
 * typedef struct TreeNode treenode;
 * 
 * treenode* treenode_new(int val) {
 *     treenode* node = (treenode *) malloc(sizeof(treenode));
 *     node->val = val;
 *     node->left = NULL;
 *     node->right = NULL;
 *     return node;
 * }
 */
/**
 * @input A : Root pointer of the tree 
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
struct stack{
  treenode* data;
  struct stack* next;
};

typedef struct stack st;

void push(st** top,treenode* val)
{
    st* temp = (st*)malloc(sizeof(st));
    temp->data = val;
    temp->next = *top;
    *top = temp;
}

void pop(st** top)
{
    if(*top == NULL)
        return;
    
    st* temp = *top;
    *top = (*top)->next ;
    free(temp);
    temp = NULL;
}
 
treenode* peek(st* top)
{
    if(top == NULL)
        return NULL;
        
    return top->data;
}

int empty(st* top)
{
    if(top == NULL)
        return 1;
    
    return 0;
}
 
int* postorderTraversal(treenode* A, int *len1) {
    int* arr = (int*)malloc(sizeof(int)*0);
    int count = 0;
    
    treenode* cur = A;
    
    st* s = NULL;
    
    while(cur || !empty(s)){
        while(cur)
        {
            push(&s,cur);
            cur = cur->left;
        }
        
        treenode* temp = peek(s);
        
        if(temp->right)
        {
            cur = temp->right ;
        }
        else
        {
            count++;
            arr = (int*)realloc(arr,sizeof(int)*count);
            arr[count-1] = temp->val;
            pop(&s);
            
            while(!empty(s) && peek(s)->right == temp)
            {
                temp = peek(s);
                pop(&s);
                count++;
                arr = (int*)realloc(arr,sizeof(int)*count);
                arr[count-1] = temp->val;
            }
            
            if(peek(s))
                cur = peek(s)->right;
        }
        
    }while(cur || !empty(s));
    
    *len1 = count;
    return arr;
}

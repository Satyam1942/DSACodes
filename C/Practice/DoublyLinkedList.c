#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    /* data */
   int val;
   struct node* next;
   struct node* prev;
}node;

void printLinkedListForward(node* head)
{
    printf("Linked List  is : ");
    while(head!=NULL)
    {
        printf("%d ",head->val);
        head = head->next;
    }
    printf("\n");
}
void printLinkedListBackward(node* tail)
{
    printf("Linked List in opposite direction is : ");
    while(tail!=NULL)
    {
        printf("%d ",tail->val);
        tail = tail->prev;
    }
    printf("\n");
}
void  appendLinkedListFront(int val ,node** head , node **tail)
{
    node* h = *head;
    node* t = *tail;

    if(h==NULL)
    {
        node* newNode = (node*) malloc(sizeof(node));
        newNode->val = val;
        newNode->next = NULL;
        newNode->prev = NULL;
        h = newNode;
        t = newNode;
        
        *head = h;
        *tail = t;
    }
    else
    {
        while(h->next != NULL) h = h->next;
        node* newNode = (node*) malloc(sizeof(node));
        newNode->val = val;
        newNode->next = NULL;
        h->next = newNode;
        newNode->prev = h;
        *tail = newNode;
    }
}

void  appendLinkedListBack(int val ,node** head , node **tail)
{
    node* h = *head;
    node* t = *tail;

    if(h==NULL)
    {
        node* newNode = (node*) malloc(sizeof(node));
        newNode->val = val;
        newNode->next = NULL;
        newNode->prev = NULL;
        h = newNode;
        t = newNode;
        
        *head = h;
        *tail = t;
    }
    else
    {
        while(t->prev != NULL) t = t->prev;
        node* newNode = (node*) malloc(sizeof(node));
        newNode->val = val;
        newNode->prev = NULL;
        t->prev = newNode;
        newNode->next = t;
        *head = newNode;
    }
}

int main(int argc, char const *argv[])
{
    node *head = NULL;
    node *tail = NULL;
    printf("Enter elements of Linked List:\n");

    while(1)
    {
        printf("Enter the value or Enter -1 to quit\n");
        int val;
        scanf("%d",&val);
        if(val == -1) {break;}
        appendLinkedListFront(val, &head, &tail);
        
    }
     printLinkedListForward(head);
     printLinkedListBackward(tail);


    return 0;
}

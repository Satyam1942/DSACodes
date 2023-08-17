#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    /* data */
   int val;
   struct node* next;
}node;

void printLinkedList(node* head)
{
    printf("Linked List  is : ");
    while(head!=NULL)
    {
        printf("%d ",head->val);
        head = head->next;
    }
    printf("\n");
}

void appendLinkedList(int val , node** temp)
{
    node*  head = *temp;
    if(head != NULL)
    { 
        while(head->next !=NULL)  {head = head->next;}
     }


    node* newNode = (node*) malloc(sizeof(node));
    newNode->val = val;
    newNode->next = NULL;

    if(head==NULL) {head = newNode; *temp = head; }
    else  head->next = newNode;
}

node* searchNode(int num,node *head)
{
    if(head->val == num) return head;

    while(head->next!=NULL)
    { 
        if(head->next->val == num) return head; 
        head = head->next;
    }

    return NULL;
}

void deleteNode(int val , node**temp)
{
    node* head = *temp;
    node* parentPointer = searchNode(val,head);
    if(parentPointer==head)
    {
        *temp = parentPointer->next;
        free(parentPointer);
        printLinkedList(*temp);
         return;
    }

    if(parentPointer!=NULL)
    {
        node* curPointer = parentPointer->next;
        node* nextPointer = curPointer->next;
        parentPointer->next = nextPointer;
        free(curPointer);
    }
    printLinkedList(head);
}

void reverseLinkedList(node **temp)
{
    node* head = *temp;
    node* prev = NULL;
    node* next = head->next;

    while(head!=NULL)
    {
        head->next = prev;
        prev= head;
        head = next;
        if(next!=NULL)
        next = next->next;
    }

    *temp = prev;
}

int main(int argc, char const *argv[])
{
    /* code */
    node *head = NULL;
    printf("Enter elements of Linked List:\n");
    char decision;
    while(1)
    {
        printf("Enter the value\n");
        int val;
        scanf("%d",&val);
        appendLinkedList(val, &head);

        fflush(stdin);
        printf("Do you want to continue?\n");
        scanf("%c",&decision);
        if(decision=='N'||decision=='n') break;
    }
     printLinkedList(head);

     int searchNo, deleteNo;
     printf("Enter the number to be searched\n");
     scanf("%d",&searchNo);
     if(searchNode(searchNo,head) != NULL) printf("Present\n");
     else printf("Not Present\n");

     printf("Enter the number to be deleted\n");
     scanf("%d",&deleteNo);
     deleteNode(deleteNo, &head);

     reverseLinkedList(&head);
     printLinkedList(head);
    return 0;
}

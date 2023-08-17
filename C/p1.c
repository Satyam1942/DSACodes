#include <stdio.h>
struct student{
  char name[20];
  int rno;
  float cgpa;
};
struct student s[100];
int n;
struct student search(char nm[], int arrsize[])
{
    for(int i=0;i<n;i++)
    {
        int cnt=0;
        int j=0;
        while(nm[j]!='\0'){
            if((nm[j]==s[i].name[j]))
            {
                    cnt++;
                    
            }
             j++;
        }
      //  printf("cnt = %d , arrsize = %d\n",cnt,arrsize[i]);
        if(cnt == arrsize[i]) return s[i];
    }
    struct student st;
    st.name[0]='\0';
    return st;
}

void sort()
{
	struct student temp;
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n-1;j++)
		{
			if(s[j].rno>s[j+1].rno)
			{
				temp=s[j];
				s[j]=s[j+1];
				s[j+1]=temp;
			}
		}
	}
}

void search2(int r)
{
    int c=0,min=0,max=n-1,mid;
    while(min<max)
    {
        mid=(min+max)/2;
        if(s[mid].rno==r)
        {   printf("Details of student with Roll No %d are\n",s[mid].rno);
            printf("NAME: %s\n",s[mid].name);
            printf("ROLL NO: %d\n",s[mid].rno);
            printf("CGPA: %f\n",s[mid].cgpa);
            c++;
            break;
        }
        else if(s[mid].rno<r)
         min=mid+1;
        else
         max=mid-1;
    }
    if(c==0)
    printf("Student not found");
}

int main() {
    // Write C code here
    int arrsize[20];
    printf("Enter no of students\n");
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        printf("Enter name , rno and cgpa of  %d  student\n",i+1);
    
        scanf("%s",&s[i].name);
        int j=0;
        while(s[i].name[j++]!='\0');
        arrsize[i] = j-1;
        scanf("%d",&s[i].rno);
        scanf("%f",&s[i].cgpa);
    }

    printf("-------SEARCHING BY NAME -------\n");
    printf("Enter student name\n");
    char nm[20];
    scanf("%s",&nm);
    struct student st;
    st=search(nm,arrsize);
    if(st.name[0]=='\0')
      printf("Student not found\n");
    else
    {
        printf("Details of %s are: \n",st.name);
        printf("Name : %s\n",st.name);
        printf("Roll No: %d\n",st.rno);
        printf("CGPA: %f\n",st.cgpa);
    }
    printf("---Data in sorted order is----\n");
    sort();
    for(int i=0;i<n;i++)
    {
        printf("Name: %s\n",s[i].name);
        printf("Roll No: %d\n",s[i].rno);
        printf("CGPA: %f\n",s[i].cgpa);
    }
    printf("------SEARCHING BY ROLL NO-----\n");
    printf("Enter student rollno\n");
    int r;
    scanf("%d",&r);
    search2(r);
    printf("--------------\n");
    return 0;
}
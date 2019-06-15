# NaumTodolliALG2019
#include <fstream> 
#include <iostream> 
#include <string>
using namespace std;
  struct fjale{
	char a;
	string fjal;
};

struct nyje{ 
    fjale word; 
    struct nyje *left; 
    struct nyje *right; 
    int height; 
}; 
  

int max(int a, int b); 
  

int height(struct nyje *N) 
{ 
    if (N == NULL) 
        return 0; 
    return N->height; 
} 
  

int max(int a, int b) 
{ 
    return (a > b)? a : b; 
} 
  

struct nyje* newnyje(string s) 
{ 
   nyje* nyj = new nyje;
   fjale a;
   a.fjal=s;
   a.a=s.at(0);
    nyj->word   = a; 
    nyj->left   = NULL; 
    nyj->right  = NULL; 
    nyj->height = 1;  
    return nyj; 
} 
  

struct nyje *rrotDjatht(struct nyje *y) 
{ 
    struct nyje *x = y->left; 
    struct nyje *T2 = x->right; 
  
   
    x->right = y; 
    y->left = T2; 
  
     
    y->height = max(height(y->left), height(y->right))+1; 
    x->height = max(height(x->left), height(x->right))+1; 
  
    
    return x; 
} 
  

struct nyje *rrotMajt(struct nyje *x) 
{ 
    struct nyje *y = x->right; 
    struct nyje *T2 = y->left; 
  
    
    y->left = x; 
    x->right = T2; 
  
    
    x->height = max(height(x->left), height(x->right))+1; 
    y->height = max(height(y->left), height(y->right))+1; 
  
   
    return y; 
} 
  
 
int Balance(struct nyje *N) 
{ 
    if (N == NULL) 
        return 0; 
    return height(N->left) - height(N->right); 
} 
  

struct nyje* shto(struct nyje* nyje, string key) 
{ 
    if (nyje == NULL) 
        return(newnyje(key)); 
  
    if (key.at(0) < nyje->word.fjal.at(0)) 
        nyje->left  = shto(nyje->left, key); 
    else if (key.at(0) >= nyje->word.fjal.at(0)) 
        nyje->right = shto(nyje->right, key); 
  

    nyje->height = 1 + max(height(nyje->left), 
                           height(nyje->right)); 
  
    int balance =Balance(nyje); 
  
    
    if (balance > 1 && key.at(0) < nyje->left->word.fjal.at(0)) 
        return rrotDjatht(nyje); 
  
     
    if (balance < -1 && key.at(0) > nyje->right->word.fjal.at(0)) 
        return rrotMajt(nyje); 
  
    
    if (balance > 1 && key.at(0) > nyje->left->word.fjal.at(0)) 
    { 
        nyje->left =  rrotMajt(nyje->left); 
        return rrotDjatht(nyje); 
    } 
   
    if (balance < -1 && key.at(0) < nyje->right->word.fjal.at(0)) 
    { 
        nyje->right = rrotDjatht(nyje->right); 
        return rrotMajt(nyje); 
    } 
  
    return nyje; 
} 
  
void print(struct nyje *root) 
{ 
    if(root != NULL) 
    { 
        cout<<root->word.fjal<<" "; 
        print(root->left); 
        print(root->right); 
    } 
} 
  
int kerko(nyje *T,string a)
{
	if(T==NULL)
	{
		return 0;
	}
	else if(T->word.fjal==a)	
	return 1;
	return kerko(T->left,a)+kerko(T->right,a);
		
		}


int main() 
{ 
  struct nyje *rrenje = NULL; 
  
fstream in;
	in.open("kot.txt");
	if(in.is_open())
	{
		while(!in.eof())
		{
			string str;
			in>>str;
		if(kerko(rrenje,str)==0)
			{
			
			
			rrenje = shto(rrenje, str);}
		}
	}
  
 print(rrenje);
  
  return 0; 
} 

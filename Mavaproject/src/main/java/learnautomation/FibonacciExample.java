package learnautomation;

public class FibonacciExample {

	public static void main(String[] args) {
	
		int n1=0,n2=1,sum,i,range=8;    
		 System.out.print(n1+" "+n2);
		    
		 for(i=2;i<range;++i)    
		 {    
		  sum=n1+n2;    
		  System.out.print(" "+sum);    
		  n1=n2;    
		  n2=sum;    
		 }    
	}

}

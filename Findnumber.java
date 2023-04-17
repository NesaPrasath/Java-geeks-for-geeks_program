/{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            long n=Long.parseLong(in.readLine());
            Solution ob=new Solution();
            out.println(ob.findNumber(n));
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long findNumber(long N)
    {
        long ans=1;
        boolean check=false;
        for(long i=1,j=1;i<N;)
        {
            j+=2;
            char fd=Long.toString(j).charAt(0);
            if(fd=='1'||fd=='3'||fd=='5'||fd=='7'||fd=='9')
            {
                long temp=j;
                for(;temp>0;)
                {
                   long temp2=temp%10;
                   if(temp2%2==0)
                   {
                      check=false;
                      break;
                   }
                   else
                   check=true;
                   temp=temp/10;
                }
            }
            if(check==true)
            {
                ans=j;
                i++;
            }
            check=false;
        }
        return ans;
    }
}

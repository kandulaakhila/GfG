class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        // write code here
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int i=0;
        int j=0;
        int k=0;
        int n=a.length;
        int []result=new int[3];
        int mindiff=Integer.MAX_VALUE;
        int minsum=Integer.MAX_VALUE;
        while(i<n && j<n && k<n){
            int min=Math.min(a[i],Math.min(b[j],c[k]));
            int max=Math.max(a[i],Math.max(b[j],c[k]));
            int diff=max-min;
            int sum=a[i]+b[j]+c[k];
            if(diff<mindiff || (diff==mindiff && sum<minsum)){
                mindiff=diff;
                minsum=sum;
                result[0]=a[i];
                result[1]=b[j];
                result[2]=c[k];
            }
            if(min==a[i])i++;
            else if(min==b[j])j++;
            else k++;
        }
        Arrays.sort(result);//ascending 
        int temp=result[0];
        result[0]=result[2];
        result[2]=temp;
        return result;
        }
    }

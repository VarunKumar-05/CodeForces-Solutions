import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder output=new StringBuilder();
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            int min=0;
            int max=0;
            int l=-1;
            int r=-1;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='1'){
                    if(l==-1){ l=i;
                        r=i;
                    }else if(i-r<=2)r=i;
                    else{
                        int length=r-l+1;
                        min+=(length/2)+1;
                        max+=length;
                        l=i;
                        r=i;

                    }
                }
            }
        
        if(l!=-1){
                    int length=r-l+1;
                    min+=length/2+1;
                    max+=length;
                }
            output.append(min).append(" ").append(max).append("\n");
            }
        System.out.print(output);
        }
}

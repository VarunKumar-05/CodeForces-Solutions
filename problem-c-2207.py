import sys
input=sys.stdin.readline

def solve():
    t=int(input())
    out=[]
    for _ in range(t):
        n,h=map(int,input().split())
        a=list(map(int,input().split()))

        left=[0]*n
        for i in range(n):
            mx=0;s=0
            for j in range(i,-1,-1):
                v=a[j]
                if v>mx:mx=v
                if mx<h:s+=h-mx
            left[i]=s

        right=[0]*n
        for i in range(n):
            mx=0;s=0
            for j in range(i,n):
                v=a[j]
                if v>mx:mx=v
                if mx<h:s+=h-mx
            right[i]=s

        val=[0]*n;mxr=[0]*n;best_left=[0]*n
        for p in range(n):
            best=0;ap=a[p]
            for i in range(p):
                if ap>mxr[i]:mxr[i]=ap
                mx=mxr[i]
                if mx<h:val[i]+=h-mx
                if val[i]>best:best=val[i]
            mxr[p]=ap;val[p]=left[p]
            if val[p]>best:best=val[p]
            best_left[p]=best

        val2=[0]*n;mxl=[0]*n;best_right=[0]*n
        for p in range(n-1,-1,-1):
            best=0;ap=a[p]
            for i in range(p+1,n):
                if ap>mxl[i]:mxl[i]=ap
                mx=mxl[i]
                if mx<h:val2[i]+=h-mx
                if val2[i]>best:best=val2[i]
            mxl[p]=ap;val2[p]=right[p]
            if val2[p]>best:best=val2[p]
            best_right[p]=best

        ans=best_left[n-1]
        for p in range(n-1):
            v=best_left[p]+best_right[p+1]
            if v>ans:ans=v
        out.append(ans)
    sys.stdout.write('\n'.join(map(str,out))+'\n')

solve()
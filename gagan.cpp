std::vector<int> computeLPS(string &pat) {
    int i=1;
    int j=0;
    int m=pat.length();
    std::vector<int> lps(m);
    lps[0]=0;
    while(i<m) {
        if(pat[i]==pat[j])
            {
                j++;
                lps[i]=j;
                i++;
            }
        else {
              if(j>0)
                j=lps[j-1];
            else 
               i++;
        }

    }
    return lps;
}

int KMP(string &txt,string &pat) {
    int i=0;
    int j=0;//index in pat to match
    std::vector<int> LPS = computeLPS(pat);
    int n=txt.length();
    int m=pat.length();
    int solved = 0;
    while(i<n) {
        if(txt[i]==pat[j])
            i++,j++;
        if(j==m) {
            j=LPS[j-1];
            //cout<<(i-m)<<endl;
            solved=1;
        }
        else if(i<n && txt[i]!=pat[j]) {
            if(j>0)
                j=LPS[j-1];
            else i++;
        }

    }
    return solved;
}
# center



if(n == 0) return 1;
        
        if(n%2==0){
           return  myPow(x, n / 2) * myPow(x, n / 2);
        }else{
            if(n < 0){
                return  myPow(x, n / 2) * myPow(x, n / 2) * (1 / x);
            }else{
                return myPow(x, n / 2) * myPow(x, n / 2) * x;
            }
        }
     

        
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        if(n%2 == 0){
            return  myPow(x*x, n/2);
        }else{
            return  x*myPow(x*x, n/2);
        }

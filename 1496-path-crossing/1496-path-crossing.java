class Solution {
    public boolean isPathCrossing(String path) {
          Set<String>set=new HashSet<>();
        int x=0;
        int y=0;
        set.add(x+"$"+y);
       
        for(char c:path.toCharArray()){
            if(c=='N')
                y++;
              else if(c=='S')
                  y--;
                  else if(c=='E')
                      x++;
                      else{
                          x--;
                          
                      }
            String co=x+"$"+y;
            if(set.contains(co)){
                return true;
            }
            set.add(co);
        }
         return false;
    }
}
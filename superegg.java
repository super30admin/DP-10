/*
Time Complexity: O(KN)
Space Complexity: O(N)
*/
class Solution {

Map<String, Integer> map = new HashMap<>();

public int superEggDrop(int eggs, int floors) {
 
    return solve(eggs,floors);
    
}

public int solve(int eggs, int floors)
{
    String key = eggs+""+floors;
    int min = Integer.MAX_VALUE;
    
    if(eggs==1)
    {
        return floors;
    }
    
    if(floors ==0 || floors==1)
    {
        return floors;
    }

    if(map.containsKey(key))
    {
        return map.get(key);
    }
    
    int ground=1,top=floors;
    
    while(ground<=top)
    {
        int mid = (ground+top)/2;
        
        int egg_doesnt_break = superEggDrop(eggs,floors-mid);
        int egg_breaks = superEggDrop(eggs-1,mid-1);
        
        if(egg_doesnt_break>egg_breaks)
        {
            ground = mid+1;
        }
        else
        {
            top = mid-1;
        }
        
         min = Math.min(min, 1+ Math.max(egg_breaks,egg_doesnt_break));
        
    }
      map.put(key,min);  
        
        return min;
}
}
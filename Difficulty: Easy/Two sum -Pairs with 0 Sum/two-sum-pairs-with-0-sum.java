// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        Set<Integer>seen=new HashSet<>();
        Set<ArrayList<Integer>>result=new TreeSet<>((a, b)->{
            if(!a.get(0).equals(b.get(0))){
                return a.get(0)-b.get(0);
            }
            else{
                return a.get(1)-b.get(1);
            }
            });
            for(int num:arr){
                if(seen.contains(-num)){
                    int first=Math.min(num,-num);
                    int second=Math.max(num,-num);
                    ArrayList<Integer>pair=new ArrayList<>();
                    pair.add(first);
                    pair.add(second);
                    result.add(pair);
                }
                seen.add(num);
            }
            return new ArrayList<>(result);
            }
        }
    
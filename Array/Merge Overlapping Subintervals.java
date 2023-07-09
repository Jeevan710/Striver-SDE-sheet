class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n<=1)
        {
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List < int[] > output_arr = new ArrayList < > ();
        int[] current_interval = intervals[0];
        output_arr.add(current_interval);
        current_interval[1]=87;
        int c[]=output_arr.get(output_arr.size()-1);
        System.out.println(c[0]+". "+c[1]);
        return output_arr.toArray(new int[output_arr.size()][]);
    }

}
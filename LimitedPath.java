class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] ans=new boolean[queries.length];
        edgeList=sorting(edgeList);
        System.out.println(Arrays.deepToString(edgeList));
        for(int i=0;i<queries.length;i++)
        {
            int start=queries[i][0];
            int end=queries[i][1];
            int distance=queries[i][2];
            boolean temp=true;
            for(int j=0;j<edgeList.length;j++)
            {
                
                if(edgeList[j][0]==start&&edgeList[j][1]==end)
                {
                    if(edgeList[j][2]<distance)
                    {
                        temp=true;
                        break;
                    }
                    temp=false;
                    break;

                }
                if(edgeList[j][0]>=start&&edgeList[j][1]<=end&&edgeList[j][1]!=start)
                {
                    if(edgeList[j][2]>=distance)
                    {
                        temp=false;
                        // break;
                    }
                    else
                    temp=true;
                }
            }
            ans[i]=temp;
        }

        return ans;
    }

    public int[][] sorting(int[][] arr)
    {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; 
            } else {
                return a[0] - b[0];
            }
        });
        for(int[] element:arr)
        {
            priorityQueue.add(element);
        }
        int[][] sortedArr = new int[arr.length][3];

        int k = 0;
        while (!priorityQueue.isEmpty()) {
            sortedArr[k] = priorityQueue.poll();
            k++;
        }
        return sortedArr;
    }
}

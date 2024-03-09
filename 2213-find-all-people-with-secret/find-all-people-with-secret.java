class DisjointSet{
    List<Integer> parent;
    List<Integer> size;

    DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    int findUltimateParent(int node){
        if(parent.get(node)==node)
            return node;
        int ultimPar = findUltimateParent(parent.get(node));
        parent.set(node,ultimPar);
        return ultimPar;
    }

    void unionBySize(int u, int v){
        int ultimParentU = findUltimateParent(u);
        int ultimParentV = findUltimateParent(v);

        if(ultimParentU==ultimParentV)
            return;
        if(size.get(ultimParentU)>=size.get(ultimParentV)){
            parent.set(ultimParentV,ultimParentU);
            size.set(ultimParentU,size.get(ultimParentU)+size.get(ultimParentV));
        }else{
            parent.set(ultimParentU,ultimParentV);
            size.set(ultimParentV,size.get(ultimParentU)+size.get(ultimParentV));
        }
    }

    void reset(int node){
        parent.set(node,node);
        size.set(node,1);
    }

    boolean isConnected(int node1 ,int node2){
        return findUltimateParent(node1)==findUltimateParent(node2);
    }
}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int numberOfMeetings = meetings.length;
        DisjointSet ds  = new DisjointSet(n);
        TreeSet<Integer> timeSet = new TreeSet<>();
        List<Integer> secretSequence = new ArrayList<>();

        Arrays.sort(meetings,(a,b)->(a[2]-b[2]));
        
        for(int i=0;i<numberOfMeetings;i++){
            timeSet.add(meetings[i][2]);
        }
        
        ds.unionBySize(0,firstPerson);

        int j = 0;
        for(int time:timeSet){
            HashSet<Integer> poolOfNodes = new HashSet<>();

            while(j<numberOfMeetings && meetings[j][2]<=time){
                int u = meetings[j][0];
                int v = meetings[j][1];
                ds.unionBySize(u,v);
                poolOfNodes.add(u);
                poolOfNodes.add(v);
                j++;
            }
        
            for(int node:poolOfNodes){
                if(!ds.isConnected(node,0)){
                    ds.reset(node);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(ds.isConnected(i,0))
                secretSequence.add(i);
        }

        return secretSequence;
    }
}
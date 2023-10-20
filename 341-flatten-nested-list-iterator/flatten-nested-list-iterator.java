/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    int iterator;
    int listIter;
    List<NestedInteger> nestedList;
    List<Integer> temp = new ArrayList<>();
    boolean flag;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList; 
        flag = false;
        iterator = 0;
        listIter= 0;
    }

    @Override
    public Integer next() {
        Integer val = 0;
       

        if(!flag)
        {
        if(nestedList.get(iterator).isInteger()) 
        {
        val = nestedList.get(iterator++).getInteger();
        }
        else
        {
        NestedIterator i =  new NestedIterator(nestedList.get(iterator).getList());
        while(i.hasNext())  temp.add(i.next());
        flag = true;
        }
        }

        

        if(flag)  
        {
            val = temp.get(listIter++);
            if(listIter==temp.size())
            {
                temp.clear();
                listIter=0;
                iterator++;
                flag = false;
            }
        }
        
        return val;
    }

    @Override
    public boolean hasNext() {

        if(iterator!=nestedList.size())
        {
        if(!nestedList.get(iterator).isInteger())
        {
            NestedIterator i =  new NestedIterator(nestedList.get(iterator).getList());
            while(!i.hasNext()) 
            {
            iterator++;
            if(iterator==nestedList.size()) break;
             if(!nestedList.get(iterator).isInteger())
            {
             i =  new NestedIterator(nestedList.get(iterator).getList());
            }
            else return true;
            }
            return iterator!=nestedList.size();
        }
        return true;
        }
        else return false;
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
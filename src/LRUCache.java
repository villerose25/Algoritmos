import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Dictionary;
import java.util.Hashtable;
/* Both operations need to be in O(1) time complexity

Design and implement data structure for least recently used cacheIt should support the get and put operations

When cache reached its capacity, put should invalidate the least recently used item before inserting a new item
The capacity is initialized with a positive capacity

LRU -> Least recently used is a policy that is used to remove items from the cache

Stacks follow the LIFO policy, queus follow the FIFO, a cache can follow the LRU policy

Example
cache: [2,3,4,5] -> 2 was accessed the most recently, followed by 3, followed by 4 and then 5
size -> 4

If we want to add a new item 1, where would we add it? -> [1,2,3,4,5]
but size is 4, so we need to remove the first item inserted ->[1,2,3,4] 5
If we want to get 2, we will move it to the first of the list  [2,1,3,4

For fast look ups, we'll use hash maps
For fast removals, we'll use double ended queues

Steps
  // If key is not present in map, return -1
  // Remove key from our deque
  // push the key to the front of the deque
  // return the value of our key from the map

  put(key, value) {
      if(m[key] not in map) {
          if(deq size is c) {
              -last = deq.back();
              -m.erase(last)
              -remove last element from deque
          }
      } else { //key is present in the map
          -remove key from deque
      }
      -m[key] = value;
      -push key front of deque
  }
*/
public class LRUCache {

    int c;
    Dictionary<Integer, Integer> m;
    Deque<Integer> deq;

    public LRUCache(int capacity) {
        this.c = capacity;
        deq = new ArrayDeque<Integer>();
        m = new Hashtable<>();
    }

    public int getLRUCache(int key) {
        int value;
        if(m.get(key) != null) {
            value = m.get(key);
            // send to the front of the deque
            deq.remove(key);
            deq.add(key);
            return value;
        } else
            return -1;
    }
    public void putLRUCache(int key, int value) {
        int oldest;
        if(m.get(key) != null) {
            if(deq.size() == c) { //full capacity
                oldest = deq.peekFirst();
                deq.pop(); //renmove
                // remove the element
                m.remove(oldest);
            }
        }else {
            deq.remove(key);
        }

        m.put(key, value);
        deq.add(key);
    }

}

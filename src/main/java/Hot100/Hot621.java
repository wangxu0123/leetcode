package Hot100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hot621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }
        
        // 具有最多执行次数的任务数量（maxCount简单来说就是图中最后一行有几个任务）
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                maxCount++;
            }
        }
        
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
    
    @Test
    public void test() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
    
}

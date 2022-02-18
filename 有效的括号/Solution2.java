import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
Java中实际上提供了java.util.Stack来实现栈结构,但官方目前已不推荐使用,而是使用java.util.Deque双端队列来实现队列与栈的各种需求.
* 如下图所示java.util.Deque的实现子类有java.util.LinkedList和java.util.ArrayDeque.顾名思义前者是基于链表,后者基于数组实现的双端队列.
*
* 帖子连接：https://blog.csdn.net/u013967628/article/details/85210036

* */
public class Solution {
    public boolean isValid(String s) {
        //当给定字符串长度为奇数时，返回false
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pair = new HashMap<>() {
            //隐式声明及代码块初始化
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        Deque<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (pair.containsKey(temp)) {
                if (stack.isEmpty() || stack.peek() != pair.get(ch)) {
                    return false;
                }
            } else {
                stack.push(temp);
            }
        }
    }
}
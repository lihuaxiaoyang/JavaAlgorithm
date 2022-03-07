package 排序相关;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @auther lihua
 * @create 2022-03-06 16:42
 */
public class 小根堆 {
    public void sortedArrDistanceLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();//小顶堆，默认容量为11
        //大顶堆，容量11
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){ //大顶堆，容量11
//            @Override
//            public int compare(Integer i1,Integer i2){
//                return i2-i1;
//            }
//        });

        /*
         * 常用方法剖析
         * 1.插入元素：add()和offer()
         * 前者插入失败会抛出异常，后者返回false
         * 2.获取但不删除队列首元素：element()和peek()
         * 前者获取失败会抛出异常，后者返回null
         * 3.获取并删除队列首元素：remove()和pll()
         * 前者删除失败会抛出异常，后者返回null
         * */
        int index = 0;
        for (; index <= Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }

        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }

        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}

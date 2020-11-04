package DataStructure.stringANDline.list.listRealize;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-18 ����01:08:11
 * @author-Email liujunfirst@outlook.com
 * @description 单链表
 * 单链表的反转：数组和单个元素 （头插和尾插）
 * 1、利用数组结构 来反转链表
 * 2、利用系统栈递归,配合数组使用
 * 3、利用指针关系 反转链表
 * 4、利用系统栈递归,无需配合数组使用
 * <p>
 * 部分反转：
 * 1、反转从index1 到 index2 之间的数据
 */
public class SinglyLinkedListReverse {

    //利用数组 来反转链表
    public int[] reverse_array(SinglyLinkedList listlj) {
        if (listlj == null || listlj.head.value == 0) {
            return new int[]{};
        }
        Nodelj node = listlj.head.next;
        int[] array = new int[listlj.head.value];
        for (int i = listlj.head.value - 1; i >= 0; i--) {
            array[i] = node.value;
            node = node.next;
        }
        return array;
    }

    //利用系统堆栈 来反转链表
    public int[] reverse_SYSstack(SinglyLinkedList listlj) {
        if (listlj == null || listlj.head.value == 0) {
            return new int[]{};
        }
        Nodelj node = listlj.head.next;
        int[] array = new int[listlj.head.value];
        SYSstack(node, array, listlj.head.value - 1);
        return array;
    }

    private int[] SYSstack(Nodelj nodelj, int[] arr, int depth) {
        if (nodelj != null) {
            SYSstack(nodelj.next, arr, depth - 1);
            arr[depth] = nodelj.value;
        }
        return arr;
    }

    //利用多指针 来反转链表
    public int[] reverse_point(SinglyLinkedList listlj) {
        if (listlj == null || listlj.head.value == 0) {
            return new int[]{};
        }
        Nodelj node = listlj.head.next;
        Nodelj node_pre;
        Nodelj head = null;
        while (node != null) {
            node_pre = node;
            node = node.next;
            node_pre.next = head;
            head = node_pre;
        }
        listlj.head.next = head;
        int[] array = listlj.toArray();
        return array;
    }

    //利用堆栈来反转链表
    public int[] reverse_SYSstack2(SinglyLinkedList listlj) {
        if (listlj == null || listlj.head.value == 0) {
            return new int[]{};
        }
        Nodelj node = listlj.head.next;
        listlj.head.next = SYSstack(node);
        int[] array = listlj.toArray();
        return array;
    }

    private Nodelj SYSstack(Nodelj nodelj) {
        if (nodelj == null || nodelj.next == null) {
            return nodelj;
        }
        Nodelj n = SYSstack(nodelj.next);
        nodelj.next.next = nodelj;
        nodelj.next = null;
        return n;
    }

    //反转从index1 到 index2 之间的数据，区间是 左闭右闭
    public int[] revert_part(SinglyLinkedList listlj, int index1, int index2) {
        if (listlj == null) {
            return new int[]{};
        }
        if (listlj.head.value == 0 || index1 > listlj.head.value || index2 > listlj.head.value) {
            return listlj.toArray();
        }
        int count = 0;
        Nodelj node = listlj.head.next;
        Nodelj preout = listlj.head;
        while (count++ < index1) {
            preout = node;
            node = node.next;
        }
        Nodelj prein = node;

        Nodelj next;
        Nodelj pre1 = node;
        node = node.next;
        //node 节点需要超过 index2，在index2 的右边一位
        while (count++ <= index2) {
            next = node.next;
            node.next = pre1;
            pre1 = node;
            node = next;
        }
        preout.next = pre1;
        prein.next = node;
        int[] arr = listlj.toArray();
        return arr;
    }

    //每n个数反转一次
    public int[] revert_partn(SinglyLinkedList listlj, int n) {
        if (listlj == null) {
            return new int[]{};
        }
        if (listlj.head.value == 0 || n > listlj.head.value) {
            return listlj.toArray();
        }
        if (n == 1) {
            return listlj.toArray();
        }
        Nodelj head = listlj.head;
        listlj.head.next = revertn(head.next, n);
        int[] array = listlj.toArray();
        return array;
    }

    private Nodelj revertn(Nodelj nodelj, int n) {
        if (nodelj == null) {
            return null;
        }
        Nodelj tail = nodelj;
        Nodelj head = nodelj;
        for (int i = 1; i <= n; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        Nodelj newHead = revertHead_Tail(head, tail);
        head.next = revertn(tail.next, n);
        return newHead;
    }

    private Nodelj revertHead_Tail(Nodelj head, Nodelj tail) {
        Nodelj pre = head;
        Nodelj next;
        head = head.next;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }
}
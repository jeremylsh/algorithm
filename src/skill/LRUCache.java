package skill;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description TODO
 * @author Jeremy
 * @date 2019/08/23
 */
public class LRUCache {

	/**
	 * 方法一：直接使用lhm
	 */
	public static class LRUCache1 {
		private LinkedHashMap<String, String> cache;
		
		public LRUCache1(int cacheSize) {
			// 这里构造方法一定要设置 accessOrder=true，lhm按照读顺序来排序，否则按照插入顺序排序
			this.cache = new LinkedHashMap<String, String>(16,0.75F,true) {
				private static final long serialVersionUID = 1L;
				@Override
				protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
					return cache.size() == cacheSize + 1;
				}
			};
		}
		
		public String get(String key) {
			return cache.get(key);
		}
		
		public void put(String key, String value) {
			cache.put(key, value);
		}
		
		public void print() {
			for (Map.Entry<String, String> e : cache.entrySet()) {
				System.out.print(e.getValue());
			}
			System.out.println();
		}
	}
	
	/**
	 * 方法二（必须掌握）：hashmap+双端链表
	 */
	public static class LRUCache2 {
		
		public static class Node {
			String key;
			String value;
			Node pre;
			Node next;
			
			public Node(String key, String value) {
				this.key = key;
				this.value = value;
			}
		}
		
		Map<String, Node> map = new HashMap<>();
		int capacity;
		int size;
		Node head;
		Node tail;
		
		/**
		 * 1.插入头结点
		 */
		private void insertHead(Node node) {
			// 第一次插入
			if (this.head == null) {
				this.head = node;
				this.tail = node;
			} else {
				Node head = this.head;
				node.next = head;
				head.pre = node;
				this.head = node;
			}
		}
		
		/**
		 * 2.删除头结点
		 */
		private void deleteHead() {
			if (this.head != null) {
				Node newHead = this.head.next;
				newHead.pre = null;
				this.head = newHead;
			}
		}
		
		/**
		 * 3.删除尾结点
		 */
		private void deleteTail() {
			if (tail != null) {
				Node newTail = this.tail.pre;
				newTail.next = null;
				this.tail = newTail;
			}
		}
		
		/**
		 * 4.删除任意结点
		 */
		private void deleteNode(Node node) {
			if (node == head) {
				deleteHead();
			} else if (node == tail) {
				deleteTail();
			} else {
				Node pre = node.pre;
				Node next = node.next;
				if (pre != null) {
					pre.next = next;
				}
				if (next != null) {
					next.pre = pre;
				}
			}
		}
		
		public LRUCache2(int capacity) {
			this.capacity = capacity;
		}
		
		public String get(String key) {
			Node node = map.get(key);
			if (node == null) {
				return null;
			} 
			// 命中缓存，刷新链表位置
			else {
				deleteNode(node);
				insertHead(node);
				return node.value;
			}
		}
		
		public void put(String key, String value) {
			Node node = map.get(key);
			Node newNode = new Node(key, value);
			
			// 未命中缓存，则作插入操作
			if (node == null) {
				map.put(key, newNode);
				insertHead(newNode);
				size++;
				// 如果缓存空间已满，淘汰掉尾结点
				if (this.size > this.capacity) {
					map.remove(key);
					deleteTail();
				}
			} else {
				// 命中缓存，做更新操作
				map.put(key, newNode);
				deleteNode(node);
				insertHead(node);
			}
		}
		
		public void print() {
			Node cur = this.head;
			while (cur != null) {
				System.out.print(cur.value + " ");
				cur = cur.next;
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		// 如果用true，则1-2-3,2-3-4,3-4-5
		// 如果用false，则1-2-3,4-2-3,2-3-5，相当于改旧值时不会追加在尾部
//		LRUCache1 lru1 = new LRUCache1(3);
//		lru1.put("k1", "1");
//		lru1.put("k2", "2");
//		lru1.put("k3", "3");
//		lru1.get("k1");
//		lru1.print();
//		lru1.put("k4", "4");
//		lru1.print();
//		lru1.put("k5", "5");
//		lru1.print();
		
		LRUCache2 lru2 = new LRUCache2(3);
		lru2.put("k1", "1");
		lru2.put("k2", "2");
		lru2.put("k3", "3");
		lru2.print();
		lru2.get("k1");
		lru2.print();
		lru2.put("k4", "4");
		lru2.print();
	}
	
}

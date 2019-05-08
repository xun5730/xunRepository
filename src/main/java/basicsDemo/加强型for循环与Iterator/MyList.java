package basicsDemo.加强型for循环与Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class MyList<T> implements Iterable<T> {

	private ArrayList<T> list=new ArrayList<T>();
	
	public void addT(T t){
		list.add(t);
	}
	public boolean removeT( T t){
		return list.remove(t);
	}
	
	
	@Override
	public Iterator<T> iterator() {//扩展自iterable接口
		//为了简单起见，就直接使用已有的迭代器
		return list.iterator();
	}
	public static void main(String[] args) {
		
		MyList<String> myList=new MyList<String>();
		myList.addT("111");
		myList.addT("222");
		for(String item :myList){
			System.out.println(item);
		}
		
	}

}

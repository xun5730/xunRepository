package designPatternDemo.迭代子模式.idemo.黑箱聚集与内禀迭代子;

import designPatternDemo.迭代子模式.idemo.白箱聚集与外禀迭代子.Aggregate;
import designPatternDemo.迭代子模式.idemo.白箱聚集与外禀迭代子.ConcreteIterator;
import designPatternDemo.迭代子模式.idemo.白箱聚集与外禀迭代子.UIterator;

public class ConcreteAggregate2  extends Aggregate{

	
	
	private Object[] objArray = null;
    /**
     * 构造方法，传入聚合对象的具体内容
     */
    public ConcreteAggregate2(Object[] objArray){
        this.objArray = objArray;
    }
    
    @Override
    public UIterator createIterator() {

        return  new ConcreteIterator();
    }
    /**
     * 内部成员类，具体迭代子类
     */
    
    private class ConcreteIterator implements UIterator{

    	
    	//内部索引，记录当前迭代到的索引位置
        private int index = 0;
        //记录当前聚集对象的大小
        private int size = 0;
        /**
         * 构造函数
         */
        public ConcreteIterator(){
            
            this.size = objArray.length;
            index = 0;
        }
		@Override
		public void first() {
			index = 0;
		}

		@Override
		public void next() {
			if(index < size)
            {
                index ++;
            }
		}

		@Override
		public boolean isDone() {
			return (index >= size);
		}

		@Override
		public Object currentItem() {
			return objArray[index];
		}
    	
    	
    	
    }
    
    
    
    
    
    
	
}

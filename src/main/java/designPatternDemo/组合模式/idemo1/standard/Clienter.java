package designPatternDemo.组合模式.idemo1.standard;

import java.io.File;

public class Clienter {
	
	
	public static void main(String[] args) {
		
		Node noder=new Noder("D://ceshi");
		try {
			createTree(noder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noder.display();
	}

	private static void createTree(Node node) throws Exception {

		File file=new File(node.name);
		File f[]=  file.listFiles();
		for(File fi : f){
	        if(fi.isFile()){
			          Filer filer = new Filer(fi.getAbsolutePath());
			          node.addNode(filer);
			 }
			 if(fi.isDirectory()){
			          Noder noder = new Noder(fi.getAbsolutePath());
			          node.addNode(noder);
			          createTree(noder);//使用递归生成树结构
			  }
		}
			         
		
	}

}

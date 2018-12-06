package designPatternDemo.组合模式.idemo1.badDesign;

import java.io.File;

public class Clienter {
	
	public static void main(String[] args) {
		Noder noder =new Noder("D://ceshi");
		cereateTree(noder);
		noder.display();
		
	}

	private static void cereateTree(Noder noder) {

		File file=new File(noder.nodeName);
		File [] f=  file.listFiles();
		for(File fi:f){
			if(fi.isFile()){
				Filer filer=new Filer(fi.getAbsolutePath());
				noder.addFiler(filer);
			}
			if(fi.isDirectory()){
				Noder n=new Noder(fi.getAbsolutePath());
				n.addNoder(n);
				cereateTree(n);//使用递归生成树结构
				
			}
			
		}
		
	}

}

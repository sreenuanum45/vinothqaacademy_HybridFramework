package utilities;

import org.openqa.selenium.WebElement;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class ImagesCollection {
	public   void MyCollection(List<WebElement>images) throws InterruptedException {
		
		Thread.sleep(5000);
		//create the folder or existing folder also
		String s="src/test/resources/collectedimages";
		File folder=new File(s);
		  
	        if (!folder.exists()) {
	            folder.mkdirs();
	        }
	        //collect all images in page
	        
	       
	        Thread.sleep(5000);
	        System.out.println(images.size());
	        int count=0;
	        for(WebElement image:images) {
	        	
	        	//every image have src value

	        	String imageurl=image.getAttribute("src");
	        	if(imageurl!=null&&!imageurl.isBlank()) {
	        	//give the filename
					//add random name to file

	        	String filename="image"+count+".jpg";
	        	
	        	Path destinationpath=Path.of(folder.getAbsolutePath(),filename );
	        	//contact the src to url to download images

	        	Thread.sleep(5000);
	        	try {
	        	URL url=new URL(imageurl);
	        	//remote to local connection
	        	BufferedInputStream in=new BufferedInputStream(url.openStream());
	        	//save that images in our local folder
	        	Files.copy(in,destinationpath, StandardCopyOption.REPLACE_EXISTING);
	        	in.close();
	        	count++;
	        	}catch(Exception e) {
	        		System.out.println("wrong url"+imageurl+e.getMessage());
	        	}
	        }

	}
	        System.out.println("total images count:"+count);
	}

}

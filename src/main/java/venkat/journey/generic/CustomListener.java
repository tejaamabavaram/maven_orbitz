package venkat.journey.generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener,InterfaceConstants{
	String SUCESS_PHOTOPATH ="C:/Users/venkatarami.reddy/eclipse-workspace/venkat.journey/Sucess_Result_Images";
	String FAILURE_PHOTOPATH= "C:/Users/venkatarami.reddy/eclipse-workspace/venkat.journey/Failure_Result_Images";
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		try{
			Robot r=new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();			
			Rectangle screenRect=new Rectangle(d);
			BufferedImage img = r.createScreenCapture(screenRect);
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			String now = s.format(new Date());
			ImageIO.write(img, "png",new File(FAILURE_PHOTOPATH+testName+now+".png"));
		   }
		 catch(Exception e){
			}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		try{
			Robot r=new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();			
			Rectangle screenRect=new Rectangle(d);
			BufferedImage img = r.createScreenCapture(screenRect);
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			String now = s.format(new Date());
			ImageIO.write(img, "png",new File(SUCESS_PHOTOPATH+testName+now+".png"));
		   }
		 catch(Exception e){
			}
		
	}

}

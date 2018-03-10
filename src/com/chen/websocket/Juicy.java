package com.chen.websocket;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.websocket.Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Juicy {
	 Session session;
//	static SelectDriver sd = SelectDriver.instance();
//	static WebDriver driver = sd.driverName("chrome");
//
//	boolean ElementExist(By Locator) {
//		try {
//			driver.findElement(Locator);
//			return true;
//		} catch (org.openqa.selenium.NoSuchElementException ex) {
//			return false;
//		}
//	}

	/*
	 * 处理字符串，把空格替换为%20
	 */
	 
	public  void transformer() throws Throwable {
		WebDriver driver = null;
		// TODO Auto-generated method stub
		// String window = "window.open('" + str + "')";
		// ((JavascriptExecutor) dr).executeScript(window);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("headless");
		option.addArguments("disable-infobars");
		// option.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User
		// Data");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(ChromeOptions.CAPABILITY, option);

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		int x = 0;
		for(int i=0;i<0;i++){
			System.out.println(1+"---");
		}

		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		try {
			 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get(
					"http://www.foxnews.com/us/2018/03/09/gunman-at-veterans-home-california-in-yountville-has-3-hostages-motive-remains-unclear.html");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             session.getBasicRemote().sendText("正在扫描文章...");
		} catch (Exception e) {
		} finally {

			WebElement element = driver.findElement(By.className("article-body"));
			List<WebElement> sets = element.findElements(By.tagName("p"));
			for (WebElement ele : sets) {
				int p = x++;

				map.put(p, new String(ele.getText()));

				// System.out.println(map.get(p)+" "+ele.getText());
			}

			driver.close();
			driver.quit();

		}

		// System.out.println(map.toString());
		Thread.sleep(2000);
		int t = 0;
		if (map.size() > 5) {
			if (map.size() % 6 != 0) {
				t = 6 - map.size() % 6;
			}
              session.getBasicRemote().sendText("需要"+t + "个补偿线程...");
			System.out.println("需要"+t + "个补偿线程...");
			Horse.ex = t;
			new CarrierTest(6, map,session);
			// barrier加速线程
		} else {
			new CarrierTest(map.size(), map,session);
		}

		//

		// System.out.println(element.getText());
		// 关闭浏览器
		// driver.quit();
		// 关闭 ChromeDriver 接口
	}


public Juicy(Session session) {
	super();
	this.session = session;
}
}
//	public static String encode(String arg) throws UnsupportedEncodingException {
//		String encodeString = URLEncoder.encode(arg, "utf-8").replaceAll("\\+", "%20");
//		return encodeString;
//	}
//
//	public static void started(String args)
//			throws MalformedURLException, UnsupportedEncodingException, IOException, Throwable {
//		translate(encode(args));
//	}

//	public static void translate(String args) throws Exception, MalformedURLException, IOException {
//		// 得到所有窗口的句柄
//
//		String window = "window.open('http://fanyi.baidu.com/?aldtype=16047#en/zh/" + args + "')";
//		((JavascriptExecutor) driver).executeScript(window);
//
//		// 排除当前窗口的句柄，则剩下是新窗口
//		String handle = driver.getWindowHandle();
//		// 获取所有页面的句柄，并循环判断不是当前的句柄
//		for (String handles : driver.getWindowHandles()) {
//			if (handles.equals(handle))
//				continue;
//			driver.switchTo().window(handles);
//		}
//		// String lockWindow = driver.getWindowHandle();
//		// 用下面代码也可以实现
//		// driver.navigate().to("http://www.baidu.com");
//		// 获取 网页的 title
//		// System.out.println(" Page title is: " + driver.getTitle());
//		// 通过 id 找到 input 的 DOM
//		Thread.sleep(10000);
//		// driver.getWindowHandle();
//		// Set<String> handles = driver.getWindowHandles();
//		// Iterator<String> it = handles.iterator();
//		// while (it.hasNext()) {
//		// String handle = it.next();
//		// if (currentWindow.equals(handle))
//		// continue;
//		// driver.switchTo().window(handle);
//		// }
//		WebElement container2 = driver.findElement(By.className("target-output"));
//		WebElement element = driver.findElement(By.className("keywords-inner"));
//		// String js = "alert(\"我是警告框！！\")";
//		String js = "document.getElementsByClassName('keywords-container')[0].style.cssText='overflow:visible';var getDom=document.getElementsByClassName('keywords-content');for(var i=0;i<getDom.length;i++){getDom[i].style.cssText='overflow:visible'}";
//		// String js="var
//		// getDom=document.getElementsByClassName('keywords-mean');"
//		// + "for(var i=0;i<getDom.length;i++){ "
//		// + "
//		// getDom[i].style.visibility='visible';getDom[i].style.overflow='scroll'}";
//		//
//
//		((JavascriptExecutor) driver).executeScript(js);
//
//		WebElement container = element.findElement(By.className("keywords-container"));
//
//		System.out.println(container2.getText());
//		// <p class="ordinary-output target-output clearfix"> <span
//		// left-pos="0|65" right-pos="0|65" space="">王牌是“大胜利”后，法官维护边境墙工程</span>
//		// </p>
//		List<WebElement> elements = container.findElements(By.className("keywords-content"));
//		// for (WebElement es : elements) {
//		// WebElement a = es.findElement(By.className("keywords-word"));
//		// System.out.print(a.getText() + " ");
//		// WebElement means = es.findElement(By.className("keywords-means"));
//		// List<WebElement> mean =
//		// means.findElements(By.className("keywords-mean"));
//		//
//		// for (WebElement e : mean) {
//		//
//		// System.out.print(e.getText() + ";");
//		// }
//		// System.out.println();
//		//
//		// }
//
//		// Set<String> handles = driver.getWindowHandles();
//		// for (String i : handles) {
//		// System.out.println("--------->");
//		// driver.switchTo().window(i);
//		//
//		// se = driver.getCurrentUrl();
//		// // System.out.println(se);
//		// }
//		// System.out.println(handles.toString());
//		// Thread.sleep(5000);
//		// ByteArrayOutputStream out = new ByteArrayOutputStream();
//		// URL url = new URL(
//		// "http://fanyi.baidu.com///gettts?lan=en&text=the%20magazine%20attempted%20to%20tie%20them%20to%20Tom%27s%20eventual%20deal%20with%20the%20National%20Enquirer%27s%20parent%20company%20%2CAmerican%20Media%20Inc&amp;spd=3&amp;source=web");
//		// InputStream in = url.openStream();
//		// byte[] data = new byte[1024];
//		// int len = 0;
//		// while ((len = in.read(data)) != -1) {
//		// out.write(data, 0, len);
//		// }
//		// byte[] sound = out.toByteArray();
//		// File soundtrack = new File("sound.mp3");
//		// FileOutputStream output = new FileOutputStream(soundtrack);
//		// output.write(sound);
//		// in.close();
//		// output.close();
//
//		// System.out.println(element.getText());
//		// 关闭浏览器
//		// driver.close();
//		// 关闭 ChromeDriver 接口
//	}
//
//	// <audio id="dictVoice" style="display: none"
//	// src="/gettts?lan=en&amp;text=dispute&amp;spd=3&amp;source=web"></audio>
//	// <audio id="dictVoice" style="display: none"
//	// src="/gettts?lan=en&text=the%20magazine%20attempted%20to%20tie%20them%20to%20Tom's%20eventual%20deal%20with%20the%20National%20Enquirer's%20parent%20company%20%2CAmerican%20Media%20Inc&amp;spd=3&amp;source=web"></audio>
//
//}
